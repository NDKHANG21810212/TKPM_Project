package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.SpeakingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpeakingResponseRepository extends JpaRepository<SpeakingResponse, Long> {

    // Tìm câu trả lời ghi âm theo người dùng và câu hỏi
    @Query("SELECT sr FROM SpeakingResponse sr WHERE sr.questionId = :questionId AND sr.studentId = :studentId")
    Optional<SpeakingResponse> findByQuestionAndStudent(@Param("questionId") Long questionId, @Param("studentId") Long studentId);
}
