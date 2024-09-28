package com.example.TKPM_Project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "log_message", nullable = false)
    private String logMessage;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    // Getters và Setters
}