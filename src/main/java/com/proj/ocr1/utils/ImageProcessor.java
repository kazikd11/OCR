package com.proj.ocr1.utils;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.*;
import java.io.File;

public class ImageProcessor {

  public BufferedImage loadImage(File file) throws IOException {
      return ImageIO.read(file);
  }

  public BufferedImage convertToGrayscale(BufferedImage image) {
      BufferedImage grayImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
      for (int y = 0; y < image.getHeight(); y++) {
          for (int x = 0; x < image.getWidth(); x++) {
              int rgb = image.getRGB(x, y);
              int red = (rgb >> 16) & 0xFF;
              int green = (rgb >> 8) & 0xFF;
              int blue = rgb & 0xFF;
              int gray = (red + green + blue) / 3;
              grayImage.setRGB(x, y, (gray << 16) | (gray << 8) | gray);
          }
      }
      return grayImage;
  }

  public BufferedImage binarizeImage(BufferedImage grayImage) {
      int width = grayImage.getWidth();
      int height = grayImage.getHeight();
      BufferedImage binaryImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

      for (int y = 0; y < height; y++) {
          for (int x = 0; x < width; x++) {
              int rgb = grayImage.getRGB(x, y) & 0xFF;
              int threshold = 128; 
              int binary = rgb < threshold ? 0x00 : 0xFFFFFF;
              binaryImage.setRGB(x, y, binary);
          }
      }
      return binaryImage;
  }

  public void saveImage(BufferedImage image, String format, File file) throws IOException {
      ImageIO.write(image, format, file);
  }
}
