package com.parsing.controller;

import com.parsing.repository.*;
import com.parsing.service.HeadHunter.HeadHunterSelenium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@Controller
public class ParsingController {

    @Autowired
    private ParsingRepository parsingRepository;

    @Autowired
    private PublishRepository publishRepository;

    @GetMapping("/main2")
    public String mainPage1(
            Map<String, Object> model
    ) {

        try {
            new HeadHunterSelenium().parsing("","","","", parsingRepository, publishRepository);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "main";
    }

    @PostMapping("/main2")
    public String main2(
            Map<String, Object> model
    ) throws InterruptedException {


        try {
            new HeadHunterSelenium().parsing("","","","", parsingRepository, publishRepository);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "main";
    }



}
