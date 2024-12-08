package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity

@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "selected_choice")
    private String selectedChoice;

    public Answer() {
    }

    public Answer(User user, Question question, String selectedChoice) {
        this.user = user;
        this.question = question;
        this.selectedChoice = selectedChoice;
    }

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getSelectedChoice() {
        return selectedChoice;
    }

    public void setSelectedChoice(String selectedChoice) {
        this.selectedChoice = selectedChoice;
    }
// Getters và Setters...
}
