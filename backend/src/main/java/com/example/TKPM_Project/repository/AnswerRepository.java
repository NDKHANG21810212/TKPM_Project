package src.main.java.com.example.TKPM_Project.repository;

import src.main.java.com.example.TKPM_Project.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    // Tìm câu trả lời của người dùng cho một câu hỏi
    @Query("SELECT a FROM Answer a WHERE a.user.id = :userId AND a.question.id = :questionId")
    Optional<Answer> findUserAnswer(@Param("userId") Long userId, @Param("questionId") Long questionId);
}
