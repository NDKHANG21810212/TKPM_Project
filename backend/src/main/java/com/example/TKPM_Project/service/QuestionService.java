package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Question;
import com.example.TKPM_Project.model.User;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionsByExamPart(String examPart);
    List<Question> getQuestionsByExamPartAndExamId(String examPart, Long examId);
    Question saveQuestion(Question question);
    void deleteQuestion(Long id);
}
