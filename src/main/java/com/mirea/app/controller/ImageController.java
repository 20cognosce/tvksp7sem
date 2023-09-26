package com.mirea.app.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RequestMapping("/images")
@Controller
public class ImageController {

    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String downloadImage(@PathVariable("id") Long id) {
        return "<html><body>" +
                "<img src='http://localhost:8080/rest/images/" + id + "'/>" +
                "</body></html>";
    }

    @ResponseBody
    @GetMapping("/logo")
    public String downloadLogoImage() {
        return """
                <html><body>
                <img src='http://localhost:8080/rest/images/logo'/>
                </body></html>
                """;
    }
}
