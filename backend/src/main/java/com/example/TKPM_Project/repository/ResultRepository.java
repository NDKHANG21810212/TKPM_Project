package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    @Query("SELECT r FROM Result r WHERE r.user.id = :userId ORDER BY r.score DESC")
    List<Result> findTopResultsByUser(@Param("userId") Long userId, Pageable pageable);
}
