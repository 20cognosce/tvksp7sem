package com.mirea.app.runner;

import com.mirea.app.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor
@Component
public class Initializer implements CommandLineRunner {

    private final ImageService imageService;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {
        jdbcTemplate.execute("ALTER SEQUENCE image_id_seq RESTART WITH 1");
        loadImages();
        log.info("Database init: images created");
    }

    @SneakyThrows
    private void loadImages() {
        InputStream logoInputStream = new FileInputStream(imageService.getImageStorageDir() + "/mirea/logo.png");
        MultipartFile logoImage = new MockMultipartFile("logo.png", "logo.png", "image/png", logoInputStream);

        imageService.uploadImage(logoImage, "RTU MIREA logo!");
    }
}
