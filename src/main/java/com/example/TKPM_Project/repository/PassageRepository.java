package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.Passage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassageRepository extends JpaRepository<Passage, Integer> {
    // Ví dụ: lấy tất cả các đoạn văn theo mức độ khó
    List<Passage> findByDifficultyLevel(String difficultyLevel);
}