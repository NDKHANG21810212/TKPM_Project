package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.LLMFeedback;
import com.example.TKPM_Project.model.LearningGoal;
import com.example.TKPM_Project.repository.LLMFeedbackRepository;
import com.example.TKPM_Project.repository.LearningGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LLMFeedbackServiceImpl implements LLMFeedbackService {
    @Autowired
    private LLMFeedbackRepository llmFeedbackRepository;

    @Override
    public LLMFeedback findById(Long id) {
        return llmFeedbackRepository.findById(id).orElse(null);
    }

    @Override
    public List<LLMFeedback> findAll() {
        return llmFeedbackRepository.findAll();
    }

    @Override
    public LLMFeedback save(LLMFeedback llmFeedback) {
        return llmFeedbackRepository.save(llmFeedback);
    }

    @Override
    public void deleteById(Long id) {
        llmFeedbackRepository.deleteById(id);
    }
}
