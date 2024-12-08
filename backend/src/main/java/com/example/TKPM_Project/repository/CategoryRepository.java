package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Tìm category theo tên
    Optional<Category> findByCategoryName(String categoryName);

    // Tìm tất cả category thuộc bài thi
    @Query("SELECT c FROM Category c WHERE c.exam.id = :examId")
    List<Category> findByExamId(@Param("examId") Long examId);
}

