package src.main.java.com.example.TKPM_Project.controller;

import src.main.java.com.example.TKPM_Project.model.Exam;
import src.main.java.com.example.TKPM_Project.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    // Lấy tất cả các bài thi
    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams() {
        List<Exam> exams = examService.findAll();
        return ResponseEntity.ok(exams);
    }

    // Lấy bài thi theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Exam exam = examService.findById(id);
        return exam != null ? ResponseEntity.ok(exam) : ResponseEntity.notFound().build();
    }

    // Thêm bài thi mới
    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        Exam createdExam = examService.save(exam);
        return ResponseEntity.ok(createdExam);
    }

    // Cập nhật bài thi
    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam examDetails) {
        Exam updatedExam = examService.update(id, examDetails);
        return updatedExam != null ? ResponseEntity.ok(updatedExam) : ResponseEntity.notFound().build();
    }

    // Xóa bài thi theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        examService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
