package com.example.TKPM_Project.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "speaking_responses")
public class SpeakingResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_id", nullable = false)
    private Integer studentId; // Mã học viên

    @Column(name = "question_id", nullable = false)
    private Integer questionId; // Mã câu hỏi Speaking

    @Column(name = "audio_path")
    private String audioPath; // Đường dẫn đến file audio lưu trong hệ thống tập tin

    @Column(name = "submission_time", nullable = false)
    private LocalDateTime submissionTime; // Thời gian nộp bài

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(LocalDateTime submissionTime) {
        this.submissionTime = submissionTime;
    }
// Các getter và setter
}
