package com.proj.ocr1.service;

import com.proj.ocr1.utils.ImageProcessor;
import com.proj.ocr1.ocr.OcrAlgorithm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OcrService {

    private final ImageProcessor imageProcessor;
    private final OcrAlgorithm ocrAlgorithm;

    public OcrService(ImageProcessor imageProcessor, OcrAlgorithm ocrAlgorithm) {
        this.imageProcessor = imageProcessor;
        this.ocrAlgorithm = ocrAlgorithm;
    }

    public String processImageFile(File inputFile, File outputFile) throws IOException {
        BufferedImage image = imageProcessor.loadImage(inputFile);
        BufferedImage grayImage = imageProcessor.convertToGrayscale(image);
        imageProcessor.saveImage(grayImage, "png", new File(outputFile.getParent(), "grayImage.png"));
        BufferedImage binaryImage = imageProcessor.binarizeImage(grayImage);
        imageProcessor.saveImage(binaryImage, "png", outputFile);
        return ocrAlgorithm.extractText(binaryImage);
    }
}
