import { motion } from "framer-motion";

export function LogoAndDescription() {
  return (
    <div className="flex flex-col items-center">
      <motion.h1
        initial={{ opacity: 0, y: 20 }}
        animate={{ opacity: 1, y: 0 }}
        className="bg-gradient-to-r from-sky-600 via-sky-400 to-sky-200 bg-clip-text text-transparent text-6xl md:text-7xl lg:text-8xl font-bold text-center tracking-tighter"
      >
        OCRaider
      </motion.h1>
      <motion.p
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ delay: 0.2 }}
        className="text-neutral-400 text-center text-sm md:text-base mt-2 max-w-md md:max-w-xl leading-relaxed"
      >
        Konwertuj dokumenty w formacie JPG, PNG i JPEG
        <br />
        na czytelny tekst w kilka sekund
      </motion.p>
    </div>
  );
}
