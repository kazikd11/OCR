package com.proj.ocr1.controller;

import com.proj.ocr1.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PostController{

    private final ImageService imageService;

    @Autowired
    public PostController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestAttribute MultipartFile file){
        if(file == null){
            return ResponseEntity.status(400).body("No file provided");
        }
        try {
            String response = imageService.processImage(file);
            return ResponseEntity.ok(response);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body("Image upload failed");
        }
    }
}