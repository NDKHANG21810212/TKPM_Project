package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Tìm câu hỏi theo bài thi
    @Query("SELECT q FROM Question q JOIN q.exam e WHERE e.id = :examId")
    List<Question> findByExamId(@Param("examId") Integer examId);

    // Tìm câu hỏi theo danh mục
    @Query("SELECT q FROM Question q WHERE q.category.id = :categoryId")
    List<Question> findByCategoryId(@Param("categoryId") Long categoryId);
}
