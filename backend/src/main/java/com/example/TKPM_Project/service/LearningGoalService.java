package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Category;
import com.example.TKPM_Project.model.LearningGoal;

import java.util.List;

public interface LearningGoalService {
    LearningGoal findById(Long id);
    List<LearningGoal> findAll();
    LearningGoal save(LearningGoal learningGoal);
    void deleteById(Long id);
}
