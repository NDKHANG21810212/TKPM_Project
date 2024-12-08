package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.LearningGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningGoalRepository extends JpaRepository<LearningGoal, Long> {

    // Tìm mục tiêu học tập theo người dùng
    @Query("SELECT lg FROM LearningGoal lg WHERE lg.userId = :userId")
    List<LearningGoal> findByUserId(@Param("userId") Long userId);
}
