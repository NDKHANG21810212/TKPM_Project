package com.example.TKPM_Project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "passage_text")
    private String passageText;

    @ManyToOne
    @JoinColumn(name = "audio_id", referencedColumnName = "id")
    private Audio audio; // Liên kết với Audio

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Choice> choices;

    @Column(name = "exam_part", nullable = false)
    private String examPart;

    // Constructors
    public Question() {}

    public Question(String questionText, Category category, String passageText, Audio audio, Exam exam, String examPart) {
        this.questionText = questionText;
        this.category = category;
        this.passageText = passageText;
        this.audio = audio;
        this.exam = exam;
        this.examPart = examPart;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPassageText() {
        return passageText;
    }

    public void setPassageText(String passageText) {
        this.passageText = passageText;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public String getExamPart() {
        return examPart;
    }

    public void setExamPart(String examPart) {
        this.examPart = examPart;
    }
}
