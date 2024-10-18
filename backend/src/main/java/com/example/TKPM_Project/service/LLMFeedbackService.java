package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Category;
import com.example.TKPM_Project.model.LLMFeedback;

import java.util.List;

public interface LLMFeedbackService {
    LLMFeedback findById(Long id);
    List<LLMFeedback> findAll();
    LLMFeedback save(LLMFeedback llmFeedback);
    void deleteById(Long id);
}
