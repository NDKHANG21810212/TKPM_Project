package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    // Tìm bài thi theo tiêu đề
    Optional<Exam> findByTitle(String title);

    // Tìm danh sách bài thi theo mức độ khó
    @Query("SELECT e FROM Exam e WHERE e.difficultyLevel = :difficultyLevel")
    List<Exam> findByDifficultyLevel(@Param("difficultyLevel") String difficultyLevel);
}
