package com.parsing.controller;

import com.parsing.repository.ParsingRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
private final ParsingRepository parsingRepository;

    public MainController(ParsingRepository parsingRepository) {
        this.parsingRepository = parsingRepository;
    }

    @GetMapping("/")
    public String mainPage1(
            Map<String, Object> model
    ) {
        return "main";
    }
}
