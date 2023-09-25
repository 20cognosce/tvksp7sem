package com.mirea.app.runner;

import com.mirea.app.Application;
import com.mirea.app.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor
@Component
public class Initializer implements CommandLineRunner {

    private final ImageService imageService;

    @Override
    public void run(String... args) {
        loadImages();
        log.info("Database init: images created");
    }

    @SneakyThrows
    private void loadImages() {
        InputStream logoInputStream = Application.class.getClassLoader().getResourceAsStream("static/logo.png");
        MultipartFile logoImage = new MockMultipartFile("logo.png", "logo.png", "image/png", logoInputStream);

        imageService.uploadImage(logoImage, "RTU MIREA logo!");
    }
}
