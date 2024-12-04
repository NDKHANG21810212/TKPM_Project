package src.main.java.com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "selected_choice")
    private String selectedChoice;

    public Answer() {
    }

    public Answer(User user, Question question, String selectedChoice) {
        this.user = user;
        this.question = question;
        this.selectedChoice = selectedChoice;
    }

    // Getters và Setters...
}
