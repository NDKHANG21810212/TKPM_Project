package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {

    // Tìm các lựa chọn của câu hỏi theo Question entity
    @Query("SELECT c FROM Choice c WHERE c.question.id = :questionId")
    List<Choice> findByQuestionId(@Param("questionId") Long questionId);

    // Tìm các lựa chọn của câu hỏi dựa trên câu hỏi (Choice sẽ liên kết với Question)
    List<Choice> findByQuestion_Id(Long questionId);
}
