package com.example.TKPM_Project.repository;

import com.example.TKPM_Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Tìm người dùng theo email
    Optional<User> findByEmail(String email);
    // Tìm người dùng theo tên người dùng (username)
    User findByUsername(String username);
    boolean existsByUsername(String username);
    // Tìm tất cả người dùng khách
    @Query("SELECT u FROM User u WHERE u.isGuest = true")
    List<User> findAllGuests();

    // Tìm tất cả người dùng không phải là khách
    @Query("SELECT u FROM User u WHERE u.isGuest = false")
    List<User> findAllNonGuests();

    // Tìm tất cả người dùng theo vai trò
    List<User> findByRole(String role);
}
