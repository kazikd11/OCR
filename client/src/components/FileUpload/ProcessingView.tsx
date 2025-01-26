import { motion } from "framer-motion";

export const ProcessingView = () => {
  return (
    <motion.div
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      className="w-full flex flex-col items-center justify-center gap-6"
    >
      <div className="flex items-center justify-center">
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
        </motion.div>
      </div>
      <div className=" h-1 w-32 md:w-48 bg-neutral-200 rounded-full overflow-hidden">
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
