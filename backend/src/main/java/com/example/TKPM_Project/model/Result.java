package com.example.TKPM_Project.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Liên kết với bảng User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "exam_score")
    private Double score;

    @Column(name = "exam_date")
    private LocalDate examDate;

    // Constructor không tham số
    public Result() {
    }

    // Constructor có tham số
    public Result(User user, Double score, LocalDate examDate) {
        this.user = user;
        this.score = score;
        this.examDate = examDate;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }
}
