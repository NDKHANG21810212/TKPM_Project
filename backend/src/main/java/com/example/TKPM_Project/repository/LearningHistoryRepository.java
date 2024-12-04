package src.main.java.com.example.TKPM_Project.repository;

import src.main.java.com.example.TKPM_Project.model.LearningHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningHistoryRepository extends JpaRepository<LearningHistory, Long> {

    // Tìm lịch sử học tập của người dùng
    @Query("SELECT lh FROM LearningHistory lh WHERE lh.user.id = :userId")
    List<LearningHistory> findByUserId(@Param("userId") Long userId);
}
