package src.main.java.com.example.TKPM_Project.service;

import src.main.java.com.example.TKPM_Project.model.Category;
import src.main.java.com.example.TKPM_Project.model.LLMFeedback;

import java.util.List;

public interface LLMFeedbackService {
    LLMFeedback findById(Long id);
    List<LLMFeedback> findAll();
    LLMFeedback save(LLMFeedback llmFeedback);
    void deleteById(Long id);
}
