import { useRef } from "react";
import { motion } from "framer-motion";
import { IconUpload } from "@tabler/icons-react";
import { useDropzone } from "react-dropzone";
import { cn } from "../../utils/utils";

const mainVariant = {
  initial: { x: 0, y: 0 },
  animate: { x: 20, y: -20, opacity: 0.9 },
};

const secondaryVariant = {
  initial: { opacity: 0 },
  animate: { opacity: 1 },
};

interface UploadZoneProps {
  onFileSelect: (file: File) => void;
}

export const UploadZone = ({ onFileSelect }: UploadZoneProps) => {
  const fileInputRef = useRef<HTMLInputElement>(null);

  const { isDragActive } = useDropzone({
    multiple: false,
    noClick: true,
    onDrop: (acceptedFiles) => {
      const file = acceptedFiles[0];
      if (file) onFileSelect(file);
    },
    onDropRejected: (error) => {
      console.log(error);
    },
  });

  return (
    <div className="w-full">
      <motion.div
        onClick={() => fileInputRef.current?.click()}
        whileHover="animate"
        className="group/file block rounded-lg cursor-pointer w-full relative overflow-hidden"
      >
        <input
          ref={fileInputRef}
          type="file"
          onChange={(e) => {
            const file = e.target.files?.[0];
            if (file) onFileSelect(file);
          }}
          className="hidden"
        />
        <div className="absolute inset-0 [mask-image:radial-gradient(ellipse_at_center,white,transparent)]"></div>
        <div className="flex flex-col items-center justify-center">
          <>
            <p className="relative z-20 bg-gradient-to-r from-sky-600 to-sky-400 bg-clip-text text-transparent text-xl md:text-2xl font-bold">
              Dodaj plik
            </p>
            <p className="relative z-20 font-sans font-normal text-neutral-500 dark:text-neutral-400 text-sm md:text-base mt-2 text-center">
              Przeciągnij plik tutaj
              <br />
              lub kliknij aby przeglądać
            </p>
            <div className="relative w-full mt-10 max-w-xl mx-auto">
              <motion.div
                layoutId="file-upload"
                variants={mainVariant}
                transition={{
                  type: "spring",
                  stiffness: 300,
                  damping: 20,
                }}
                className={cn(
                  "relative group-hover/file:shadow-xl z-40 bg-gradient-to-br from-sky-600 to-sky-400 flex items-center justify-center h-32 mt-4 w-full max-w-[8rem] mx-auto rounded-lg",
                  "shadow-lg transition-all duration-300 hover:scale-105"
                )}
              >
                {isDragActive ? (
                  <motion.p
                    initial={{ opacity: 0 }}
                    animate={{ opacity: 1 }}
                    className="text-neutral-100 flex flex-col items-center text-center"
                  >
                    Przeciągnij tutaj
                    <IconUpload className="h-4 w-4 text-neutral-100 mt-1" />
                  </motion.p>
                ) : (
                  <motion.div
                    animate={{ y: [0, -5, 0] }}
                    transition={{ repeat: Infinity, duration: 2 }}
                  >
                    <IconUpload className="h-6 w-6 text-neutral-100" />
                  </motion.div>
                )}
              </motion.div>
              <motion.div
                variants={secondaryVariant}
                className="absolute opacity-0 border border-dashed border-sky-400 inset-0 z-30 bg-transparent flex items-center justify-center h-32 mt-4 w-full max-w-[8rem] mx-auto rounded-md"
              ></motion.div>
            </div>
          </>
        </div>
      </motion.div>
    </div>
  );
};
