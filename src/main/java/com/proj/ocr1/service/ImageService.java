// package com.proj.ocr1.service;

// import com.proj.ocr1.utils.Algorithm;
// import org.springframework.stereotype.Component;
// import org.springframework.web.multipart.MultipartFile;

// import java.awt.image.BufferedImage;
// import java.io.IOException;

// @Component
// public class ImageService {

//     //dodac sprawdzanie formatu
//     public byte[][] rgb2gray(MultipartFile file) throws IOException {
//         BufferedImage image = javax.imageio.ImageIO.read(file.getInputStream());

//         byte[][] out = new byte[image.getHeight()][image.getWidth()];

//         for (int y = 0; y < image.getHeight(); y++) {
//             for (int x = 0; x < image.getWidth(); x++) {
//                 int pixel = image.getRGB(x, y);
//                 int red = (pixel >> 16) & 0xff;
//                 int green = (pixel >> 8) & 0xff;
//                 int blue = pixel & 0xff;
//                 int gray = (int)(0.2989 * red + 0.5870 * green + 0.1140 * blue);
//                 out[y][x] = (byte) gray;
//             }
//         }

//         return out;
//     }

//     public String processImage(MultipartFile file) throws IOException {
//         return Algorithm.process(rgb2gray(file));
//     }
// }
