package com.example.TKPM_Project.repository;


import com.example.TKPM_Project.model.LearningHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningHistoryRepository extends JpaRepository<LearningHistory, Integer> {
    // Ví dụ: lấy tất cả lịch sử học tập của một người dùng cụ thể
    List<LearningHistory> findByUserId(Integer userId);
}