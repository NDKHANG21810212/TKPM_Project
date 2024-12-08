package src.main.java.com.example.TKPM_Project.model;

import jakarta.persistence.*;
import src.main.java.com.example.TKPM_Project.service.LLMApiService;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "passage_text")
    private String passageText;

    @Column(name = "audio_path")
    private String audioPath;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    // Thêm trường để lưu trữ phản hồi của API LLM
    @Column(name = "feedback")
    private String feedback;

    // Constructors
    public Question() {
    }

    public Question(String questionText, String correctAnswer, Category category, String passageText, String audioPath, Exam exam) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.passageText = passageText;
        this.audioPath = audioPath;
        this.exam = exam;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPassageText() {
        return passageText;
    }

    public void setPassageText(String passageText) {
        this.passageText = passageText;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    // Phương thức để gọi API LLM và phân tích câu trả lời
    public void analyzeAnswerWithLLM(String userAnswer) throws Exception {
        // Sử dụng LLMApiService để gọi API
        LLMApiService llmApiService = new LLMApiService();
        String feedback = llmApiService.analyzeAnswer(userAnswer);

        // Lưu phản hồi từ LLM
        this.feedback = feedback;
    }

    // Getter và Setter cho phản hồi
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
