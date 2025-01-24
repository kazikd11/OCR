
package com.proj.ocr1;

import com.proj.ocr1.service.OcrService;
import com.proj.ocr1.utils.ImageProcessor;
import com.proj.ocr1.ocr.OcrAlgorithm;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <inputImagePath> <outputImagePath>");
            return;
        }

        String inputImagePath = args[0];
        String outputImagePath = args[1];

        ImageProcessor imageProcessor = new ImageProcessor();
        OcrAlgorithm ocrAlgorithm = new OcrAlgorithm();
        OcrService ocrService = new OcrService(imageProcessor, ocrAlgorithm);

        try {
            File inputFile = new File(inputImagePath);
            File outputFile = new File(outputImagePath);
            String extractedText = ocrService.processImageFile(inputFile, outputFile);
            System.out.println("Extracted Text: " + extractedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}