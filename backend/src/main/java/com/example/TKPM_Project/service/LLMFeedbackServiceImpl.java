package src.main.java.com.example.TKPM_Project.service;

import src.main.java.com.example.TKPM_Project.model.LLMFeedback;
import src.main.java.com.example.TKPM_Project.model.LearningGoal;
import src.main.java.com.example.TKPM_Project.repository.LLMFeedbackRepository;
import src.main.java.com.example.TKPM_Project.repository.LearningGoalRepository;
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
