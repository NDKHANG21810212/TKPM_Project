package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title; // Tiêu đề bài thi

    @Column
    private String description; // Mô tả bài thi

    @Column(nullable = false)
    private String category; // Loại đề thi (Listening, Reading, Writing, Speaking)

    @Column(name = "created_by")
    private String createdBy; // Người tạo đề

    @Column(name = "difficulty_level")
    private String difficultyLevel; // Mức độ khó

    // Getters và Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    // Phương thức tiện ích (nếu cần)
    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                '}';
    }
}
