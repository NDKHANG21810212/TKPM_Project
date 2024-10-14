package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String action; // Hành động (ví dụ: đăng nhập, tạo đề thi)

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true) // Có thể không có người dùng
    private User user;

    @Column(nullable = false)
    private String timestamp; // Thời gian xảy ra sự kiện

    // Getters và Setters
}
