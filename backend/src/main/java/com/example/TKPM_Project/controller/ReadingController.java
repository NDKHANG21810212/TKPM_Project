package com.example.TKPM_Project.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reading")
@CrossOrigin(origins = "http://localhost:3000")
public class ReadingController extends QuestionController {
    @Override
    protected String getExamPart(){
        return "Reading";
    }
}
