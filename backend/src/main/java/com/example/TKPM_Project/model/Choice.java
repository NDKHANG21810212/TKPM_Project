package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "choices")
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(nullable = false)
    private String choiceText;

    @Column(name = "is_correct", nullable = false)
    private boolean isCorrect;

    // Constructor mặc định (JPA yêu cầu có constructor mặc định)
    public Choice() {}

    // Constructor với các tham số
    public Choice(String choiceText, boolean isCorrect, Question question) {
        this.choiceText = choiceText;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
