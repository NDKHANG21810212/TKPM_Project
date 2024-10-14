package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "category_id")
    private Integer categoryId; // ID danh mục câu hỏi

    @Column(name = "passage_text")
    private String passageText; // Đoạn văn liên quan đến câu hỏi

    @Column(name = "audio_path")
    private String audioPath; // Đường dẫn đến file audio cho phần nghe

    // Constructors
    public Question() {
    }

    public Question(String questionText, String correctAnswer, Integer categoryId, String passageText, String audioPath) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.categoryId = categoryId;
        this.passageText = passageText;
        this.audioPath = audioPath;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getPassageText() {
        return passageText;
    }

    public void setPassageText(String passageText) {
        this.passageText = passageText;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }
}
