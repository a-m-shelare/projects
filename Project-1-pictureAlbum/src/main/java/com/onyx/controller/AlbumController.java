package com.onyx.controller;

import java.io.IOException;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.onyx.entity.Album;
import com.onyx.repository.AlbumRepo;

@RestController
@CrossOrigin("*")
public class AlbumController {
	@Autowired
	private AlbumRepo repo;
	
    @PostMapping("/upload")
    @CrossOrigin(origins = "http://localhost:5173/") // Add the origin of your frontend
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
           Album media = new Album();
            media.setImage(file.getBytes());
            repo.save(media);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

}
