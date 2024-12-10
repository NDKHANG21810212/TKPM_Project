package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Answer;
import java.util.List;

public interface AnswerService {
    Answer findById(Long id);
    List<Answer> findAll();
    Answer save(Answer answer);
    void deleteById(Long id);
}
