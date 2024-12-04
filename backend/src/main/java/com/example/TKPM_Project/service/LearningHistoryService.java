package src.main.java.com.example.TKPM_Project.service;

import src.main.java.com.example.TKPM_Project.model.Category;
import src.main.java.com.example.TKPM_Project.model.LearningHistory;

import java.util.List;

public interface LearningHistoryService {
    LearningHistory findById(Long id);
    List<LearningHistory> findAll();
    LearningHistory save(LearningHistory learningHistory);
    void deleteById(Long id);
}
