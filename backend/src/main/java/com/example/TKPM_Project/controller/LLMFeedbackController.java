package com.example.TKPM_Project.controller;

import com.example.TKPM_Project.model.LLMFeedback;
import com.example.TKPM_Project.service.LLMFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/llmfeedbacks")
public class LLMFeedbackController {

    @Autowired
    private LLMFeedbackService llmFeedbackService;

    // Lấy tất cả các phản hồi từ LLM
    @GetMapping
    public ResponseEntity<List<LLMFeedback>> getAllLLMFeedbacks() {
        List<LLMFeedback> feedbacks = llmFeedbackService.findAll();
        return ResponseEntity.ok(feedbacks);
    }

    // Lấy phản hồi từ LLM theo ID
    @GetMapping("/{id}")
    public ResponseEntity<LLMFeedback> getLLMFeedbackById(@PathVariable Long id) {
        LLMFeedback feedback = llmFeedbackService.findById(id);
        return feedback != null ? ResponseEntity.ok(feedback) : ResponseEntity.notFound().build();
    }

    // Thêm phản hồi từ LLM mới
    @PostMapping
    public ResponseEntity<LLMFeedback> createLLMFeedback(@RequestBody LLMFeedback feedback) {
        LLMFeedback createdFeedback = llmFeedbackService.save(feedback);
        return ResponseEntity.ok(createdFeedback);
    }

    // Xóa phản hồi từ LLM theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLLMFeedback(@PathVariable Long id) {
        llmFeedbackService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
