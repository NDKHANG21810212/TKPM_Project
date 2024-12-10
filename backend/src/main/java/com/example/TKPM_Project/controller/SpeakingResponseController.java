package com.example.TKPM_Project.controller;
import com.example.TKPM_Project.model.SpeakingResponse;
import com.example.TKPM_Project.service.SpeakingResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/speaking-responses")
public class SpeakingResponseController {

    @Autowired
    private SpeakingResponseService speakingResponseService;

    // Lấy tất cả phản hồi bài nói
    @GetMapping
    public ResponseEntity<List<SpeakingResponse>> getAllSpeakingResponses() {
        List<SpeakingResponse> responses = speakingResponseService.findAll();
        return ResponseEntity.ok(responses);
    }

    // Lấy phản hồi bài nói theo ID
    @GetMapping("/{id}")
    public ResponseEntity<SpeakingResponse> getSpeakingResponseById(@PathVariable Long id) {
        SpeakingResponse response = speakingResponseService.findById(id);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    // Thêm mới phản hồi bài nói
    @PostMapping
    public ResponseEntity<SpeakingResponse> createSpeakingResponse(@RequestBody SpeakingResponse speakingResponse) {
        SpeakingResponse createdResponse = speakingResponseService.save(speakingResponse);
        return ResponseEntity.ok(createdResponse);
    }

    // Xóa phản hồi bài nói theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpeakingResponse(@PathVariable Long id) {
        speakingResponseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
