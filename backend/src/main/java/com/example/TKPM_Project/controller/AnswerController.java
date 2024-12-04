package src.main.java.com.example.TKPM_Project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.example.TKPM_Project.service.AnswerService;
import src.main.java.com.example.TKPM_Project.model.Answer;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
@CrossOrigin(origins = "http://localhost:3000")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @GetMapping
    public List<Answer> getAllAnswers() {
        return answerService.findAll();
    }
}
