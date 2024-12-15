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

    @Column(name = "question_text")
    private String questionText;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "passage_text")
    private String passageText;

    @Column(name = "audio_path")
    private String audioPath;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

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

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Choice> choices; // Mối quan hệ với các lựa chọn câu hỏi

    // Constructors, Getters và Setters
    public Question() {}

    public Question(String questionText, Category category, String passageText, String audioPath, Exam exam) {
        this.questionText = questionText;
        this.category = category;
        this.passageText = passageText;
        this.audioPath = audioPath;
        this.exam = exam;
    }

    // Getters và Setters
    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
