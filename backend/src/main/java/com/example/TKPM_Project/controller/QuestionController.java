package com.example.TKPM_Project.controller;

import com.example.TKPM_Project.model.Question;
import com.example.TKPM_Project.service.ChoiceService;
import com.example.TKPM_Project.service.QuestionService;
import com.example.TKPM_Project.service.AnswerAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:3000") // Hỗ trợ frontend tại port 3000
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    protected String getExamPart() {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getQuestionsByExamPart(getExamPart()));
    }

    @GetMapping("/{examId}")
    public ResponseEntity<List<Question>> getQuestionsByExamId(@PathVariable Long examId) {
        return ResponseEntity.ok(questionService.getQuestionsByExamPartAndExamId(getExamPart(), examId));
    }

    @PostMapping
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        question.setExamPart(getExamPart());
        return ResponseEntity.ok(questionService.saveQuestion(question));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
