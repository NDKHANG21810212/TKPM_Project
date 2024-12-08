package src.main.java.com.example.TKPM_Project.controller;

import src.main.java.com.example.TKPM_Project.model.Question;
import src.main.java.com.example.TKPM_Project.service.QuestionService;
import src.main.java.com.example.TKPM_Project.service.AnswerAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:3000") // Hỗ trợ frontend tại port 3000
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Lấy danh sách tất cả câu hỏi
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.findAll();
        return ResponseEntity.ok(questions);
    }

    // Lấy thông tin câu hỏi theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionService.findById(id);
        return question != null ? ResponseEntity.ok(question) : ResponseEntity.notFound().build();
    }

    // Thêm mới câu hỏi
    @PostMapping
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question) {
        Question createdQuestion = questionService.save(question);
        return ResponseEntity.ok(createdQuestion);
    }

    // Cập nhật câu hỏi
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @Valid @RequestBody Question questionDetails) {
        Question updatedQuestion = questionService.update(id, questionDetails);
        return updatedQuestion != null ? ResponseEntity.ok(updatedQuestion) : ResponseEntity.notFound().build();
    }

    // Xóa câu hỏi theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Autowired
    private AnswerAnalysisService answerAnalysisService;  // Dịch vụ tổng hợp

    // Phân tích câu trả lời văn bản
    @PostMapping("/analyzeTextAnswer")
    public ResponseEntity<String> analyzeTextAnswer(@RequestParam String userAnswer) throws Exception {
        String feedback = answerAnalysisService.analyzeTextAnswer(userAnswer);
        return ResponseEntity.ok(feedback);
    }

    // Phân tích câu trả lời từ âm thanh (cung cấp URL âm thanh)
    @PostMapping("/analyzeAudioAnswer")
    public ResponseEntity<String> analyzeAudioAnswer(@RequestParam String audioUrl) throws Exception {
        String feedback = answerAnalysisService.analyzeAudioAnswer(audioUrl);
        return ResponseEntity.ok(feedback);
    }
}
