package com.mirea.app.controller;

import com.mirea.app.domain.entity.Image;
import com.mirea.app.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/rest/images")
@RestController()
public class ImageRestController {

    private final ImageService imageService;

    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String uploadImage(@RequestBody MultipartFile image,
                              @RequestParam("title") String title) {
        return imageService.uploadImage(image, title);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadImage(@PathVariable("id") Long id) {
        var imageResource = imageService.downloadImage(id);
        return ResponseEntity.ok(imageResource);
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAll() {
        return ResponseEntity.ok(imageService.getAll());
    }

    @GetMapping("/logo")
    public ResponseEntity<Resource> downloadLogoImage() {
        var imageResource = imageService.downloadImage(1L);
        return ResponseEntity.ok(imageResource);
    }
}
