package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.LLMFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LLMFeedbackRepository extends JpaRepository<LLMFeedback, Long> {

    // Tìm phản hồi liên quan đến kết quả
    @Query("SELECT f FROM LLMFeedback f WHERE f.result.id = :resultId")
    List<LLMFeedback> findByResultId(@Param("resultId") Long resultId);
}
