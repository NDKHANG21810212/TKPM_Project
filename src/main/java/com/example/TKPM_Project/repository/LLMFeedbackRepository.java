package com.example.TKPM_Project.repository;


import com.example.TKPM_Project.model.LLMFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LLMFeedbackRepository extends JpaRepository<LLMFeedback, Integer> {
}