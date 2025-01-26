import { useState } from "react";
import { UploadZone } from "./FileUpload/UploadZone";
import { ProcessingView } from "./FileUpload/ProcessingView";
import { ResultView } from "./FileUpload/ResultView";

export const FileUpload = () => {
  const [file, setFile] = useState<File | null>(null);
  const [isProcessing, setIsProcessing] = useState(false);
  const [processedText, setProcessedText] = useState<string>("");
  const [error, setError] = useState<string | null>(null);

  const handleFileChange = async (newFile: File) => {
    const allowedExtensions = ["jpg", "jpeg", "png"];
    const fileExtension = newFile.name.split(".").pop()?.toLowerCase();

    if (!fileExtension || !allowedExtensions.includes(fileExtension)) {
      setError(
        "Nieprawidłowy format pliku. Dopuszczalne formaty: JPG, JPEG, PNG"
      );
      return;
    }

    setError(null);
    setFile(newFile);
    setIsProcessing(true);

    try {
      const formData = new FormData();
      formData.append("file", newFile);

      const response = await fetch("http://localhost:8000/ocr/upload/", {
        method: "POST",
        body: formData,
      });

      if (!response.ok) {
        throw new Error(`Błąd serwera: ${response.status}`);
      }

      const data = await response.json();
      setProcessedText(data.message || "");
    } catch (error) {
      setError(
        `Wystąpił błąd: ${
          error instanceof Error ? error.message : "Nieznany błąd"
        }`
      );
    } finally {
      setIsProcessing(false);
    }
  };

  const handleReset = () => {
    setFile(null);
    setProcessedText("");
    setIsProcessing(false);
    setError(null);
  };

  return (
    <div className="w-full p-10">
      {error && (
        <p className="mb-4 p-4 text-center text-red-600 rounded">{error}</p>
      )}
      {!file ? (
        <UploadZone onFileSelect={handleFileChange} />
      ) : isProcessing ? (
        <ProcessingView />
      ) : (
        <ResultView
          fileName={file.name}
          processedText={processedText}
          onReset={handleReset}
        />
      )}
    </div>
  );
};
