package src.main.java.com.example.TKPM_Project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "difficulty_level") // Thêm cột độ khó
    private String difficultyLevel; // Độ khó của thể loại

    // Danh sách các câu hỏi thuộc danh mục này
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Question> questions;
    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    private Exam exam;
    // Constructors
    public Category() {
    }

    public Category(String categoryName, String difficultyLevel) {
        this.categoryName = categoryName;
        this.difficultyLevel = difficultyLevel;
    }

    // Getters và Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
