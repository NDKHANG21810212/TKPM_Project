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
    public Exam update(Long id, Exam examDetails) {
        return examRepository.findById(id).map(existingExam -> {
            existingExam.setTitle(examDetails.getTitle()); // Cập nhật tiêu đề bài thi
            existingExam.setDescription(examDetails.getDescription()); // Cập nhật mô tả bài thi
            existingExam.setCategory(examDetails.getCategory()); // Cập nhật danh mục
            return examRepository.save(existingExam);
        }).orElse(null); // Trả về null nếu không tìm thấy bài thi
    }

    @Override
    public void deleteById(Long id) {
        examRepository.deleteById(id);
    }
}
