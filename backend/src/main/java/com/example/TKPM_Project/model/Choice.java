package src.main.java.com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "choices")
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(nullable = false)
    private String choiceText;

    @Column(name = "is_correct", nullable = false)
    private boolean isCorrect;

    // Getters và Setters
}
