package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Question;
import com.example.TKPM_Project.model.User;

import java.util.List;

public interface QuestionService {
    Question findById(Long id);
    List<Question> findAll();
    Question save(Question question);
    Question update(Long id, Question question);
    void deleteById(Long id);
}
