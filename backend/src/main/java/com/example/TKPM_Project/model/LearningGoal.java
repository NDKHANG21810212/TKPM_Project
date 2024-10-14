package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "learning_goals")
public class LearningGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "goal_description")
    private String goalDescription;

    @Column(name = "user_id")
    private Long userId; // ID của người dùng tương ứng với mục tiêu học tập

    // Constructors
    public LearningGoal() {
    }

    public LearningGoal(String goalDescription, Long userId) {
        this.goalDescription = goalDescription;
        this.userId = userId;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
