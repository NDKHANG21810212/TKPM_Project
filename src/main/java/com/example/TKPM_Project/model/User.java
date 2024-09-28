package com.example.TKPM_Project.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    // Relationships, for example, with Exam and Results
    @OneToMany(mappedBy = "user")
    private List<Result> results;

    // Getters và Setters
}