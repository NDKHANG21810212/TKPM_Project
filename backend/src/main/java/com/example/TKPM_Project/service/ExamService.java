package src.main.java.com.example.TKPM_Project.service;

import src.main.java.com.example.TKPM_Project.model.Category;
import src.main.java.com.example.TKPM_Project.model.Exam;

import java.util.List;

public interface ExamService {
    Exam findById(Long id);
    List<Exam> findAll();
    Exam save(Exam exam);
    Exam update(Long id, Exam examDetails);
    void deleteById(Long id);
}
