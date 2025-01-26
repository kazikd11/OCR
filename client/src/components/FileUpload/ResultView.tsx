import { motion } from "framer-motion";

interface ResultViewProps {
  fileName: string;
  processedText: string;
  onReset: () => void;
}

export const ResultView = ({
  fileName,
  processedText,
  onReset,
}: ResultViewProps) => {
  return (
    <motion.div
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      className="text-center w-full"
    >
      <p className="text-lg md:text-xl font-semibold bg-gradient-to-r from-sky-600 to-sky-400 bg-clip-text text-transparent mb-4">
        Przetworzono plik:
        <br />
        <span className="text-neutral-700 dark:text-neutral-300 text-base md:text-lg font-normal">
          {fileName}
        </span>
      </p>
      <div className="max-w-2xl md:max-w-3xl mx-auto bg-neutral-100 dark:bg-neutral-800 p-4 md:p-6 rounded-lg mb-4">
        <p className="text-neutral-700 dark:text-neutral-300 whitespace-pre-wrap">
          {processedText}
        </p>
      </div>
      <button
        onClick={(e) => {
          e.preventDefault();
          e.stopPropagation();
          onReset();
        }}
        className="px-4 py-2 bg-sky-500 hover:bg-sky-600 text-white rounded-md transition-colors"
      >
        Przetwórz inny plik
      </button>
    </motion.div>
  );
};
