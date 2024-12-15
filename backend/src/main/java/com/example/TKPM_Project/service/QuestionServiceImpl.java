package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Question;
import com.example.TKPM_Project.model.User;
import com.example.TKPM_Project.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public List<Question> getQuestionsByExamPart(String examPart) {
        return questionRepository.findByExamPart(examPart);
    }

    @Override
    public List<Question> getQuestionsByExamPartAndExamId(String examPart, Long examId) {
        return questionRepository.findByExamPartAndExamId(examPart, examId);
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
