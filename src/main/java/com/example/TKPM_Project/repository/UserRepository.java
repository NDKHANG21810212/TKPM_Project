package com.example.TKPM_Project.repository;
import com.example.TKPM_Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Bạn có thể thêm các phương thức tìm kiếm tùy chỉnh dựa trên tên, email, v.v.
    User findByUsername(String username);
}