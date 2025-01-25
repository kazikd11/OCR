import { motion } from "framer-motion";

export const ProcessingView = () => {
  return (
    <motion.div
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      className="text-center w-full"
    >
      <div className="flex items-center justify-center gap-2 mb-6">
        <motion.p
          className="font-bold text-neutral-700 dark:text-neutral-300"
          animate={{ opacity: [0.5, 1] }}
          transition={{ repeat: Infinity, duration: 1 }}
        >
          Przetwarzanie pliku
        </motion.p>
        <motion.div
          className="flex gap-1"
          animate={{ opacity: [0.5, 1] }}
          transition={{ repeat: Infinity, duration: 1 }}
        >
          <span>.</span>
          <span>.</span>
          <span>.</span>
        </motion.div>
      </div>
      <div className="mt-4 h-1 w-32 md:w-48 bg-neutral-200 rounded-full overflow-hidden">
        <motion.div
          className="h-full bg-sky-500"
          animate={{
            width: ["0%", "100%"],
          }}
          transition={{
            duration: 1,
            repeat: Infinity,
          }}
        />
      </div>
    </motion.div>
  );
};
