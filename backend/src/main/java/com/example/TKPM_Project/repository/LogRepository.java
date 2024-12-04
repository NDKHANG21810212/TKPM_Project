package src.main.java.com.example.TKPM_Project.repository;

import src.main.java.com.example.TKPM_Project.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    // Lấy nhật ký hoạt động của người dùng
    @Query("SELECT l FROM Log l WHERE l.user.id = :userId")
    List<Log> findByUserId(@Param("userId") Long userId);
}
