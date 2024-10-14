package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Có thể thêm các phương thức truy vấn tùy chỉnh nếu cần
}
