package src.main.java.com.example.TKPM_Project.repository;

import src.main.java.com.example.TKPM_Project.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    // Lấy kết quả bài thi của người dùng
    @Query("SELECT r FROM Result r WHERE r.user.id = :userId AND r.exam.id = :examId")
    Optional<Result> findByUserAndExam(@Param("userId") Long userId, @Param("examId") Long examId);

    // Tìm kết quả có điểm cao nhất
    @Query("SELECT r FROM Result r WHERE r.user.id = :userId ORDER BY r.score DESC")
    List<Result> findTopResultsByUser(@Param("userId") Long userId, Pageable pageable);
}
