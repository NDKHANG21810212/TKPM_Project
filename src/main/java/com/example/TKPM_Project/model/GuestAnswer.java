package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "guest_answers")
public class GuestAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "guest_result_id", nullable = false)
    private GuestResult guestResult;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "choice_id", nullable = false)
    private Choice choice;

    // Getters và Setters
}