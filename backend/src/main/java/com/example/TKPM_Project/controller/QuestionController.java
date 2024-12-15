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

    @Autowired
    private ChoiceService choiceService; // Dịch vụ để lấy lựa chọn

    // Lấy danh sách tất cả câu hỏi kèm lựa chọn
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.findAll();
        questions.forEach(q -> q.setChoices(choiceService.findByQuestion(q))); // Thêm lựa chọn vào câu hỏi
        return ResponseEntity.ok(questions);
    }

    // Các API khác (GET, POST, PUT, DELETE) không thay đổi

    @Autowired
    private AnswerAnalysisService answerAnalysisService;

    // Phân tích câu trả lời văn bản
    @PostMapping("/analyzeTextAnswer")
    public ResponseEntity<String> analyzeTextAnswer(@RequestParam String userAnswer) throws Exception {
        String feedback = answerAnalysisService.analyzeTextAnswer(userAnswer);
        return ResponseEntity.ok(feedback);
    }

    // Phân tích câu trả lời từ âm thanh (cung cấp URL âm thanh)
    @PostMapping("/analyzeAudioAnswer")
    public ResponseEntity<String> analyzeAudioAnswer(@RequestParam String audioUrl) throws Exception {
        String feedback = answerAnalysisService.analyzeAudioAnswer(audioUrl);
        return ResponseEntity.ok(feedback);
    }
}
