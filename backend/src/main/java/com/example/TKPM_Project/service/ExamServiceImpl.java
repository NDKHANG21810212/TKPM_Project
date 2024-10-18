package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Exam;
import com.example.TKPM_Project.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam findById(Long id) {
        return examRepository.findById(id).orElse(null);
    }

    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public void deleteById(Long id) {
        examRepository.deleteById(id);
    }
}
