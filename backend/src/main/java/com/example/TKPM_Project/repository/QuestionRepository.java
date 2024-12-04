package src.main.java.com.example.TKPM_Project.repository;

import src.main.java.com.example.TKPM_Project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Tìm câu hỏi theo bài thi
    @Query("SELECT q FROM Question q WHERE q.exam.id = :examId")
    List<Question> findByExamId(@Param("examId") Long examId);

    // Tìm câu hỏi theo danh mục
    @Query("SELECT q FROM Question q WHERE q.category.id = :categoryId")
    List<Question> findByCategoryId(@Param("categoryId") Long categoryId);
}

