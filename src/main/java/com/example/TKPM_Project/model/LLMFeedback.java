package com.example.TKPM_Project.model;


import jakarta.persistence.*;

@Entity
@Table(name = "llm_feedback")
public class LLMFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = false)
    private Result result;

    @Column(name = "feedback_text")
    private String feedbackText;

    // Getters và Setters
}