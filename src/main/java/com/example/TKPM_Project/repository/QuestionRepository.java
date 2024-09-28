package com.example.TKPM_Project.repository;


import com.example.TKPM_Project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // Ví dụ: lấy câu hỏi theo loại và độ khó
    List<Question> findByQuestionTypeAndDifficultyLevel(String questionType, String difficultyLevel);
}