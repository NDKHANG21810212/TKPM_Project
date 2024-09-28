package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    // Ví dụ: lấy kết quả theo người dùng và bài thi
    List<Result> findByUserIdAndExamId(Integer userId, Integer examId);
}