package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Question;
import com.example.TKPM_Project.model.User;
import com.example.TKPM_Project.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }
    @Override
    public Question update(Long id, Question question) {
            Question ques = questionRepository.findById(id).orElse(null);
            if (ques != null) {
                // Cập nhật các thuộc tính của câu hỏi
                ques.setQuestionText(question.getQuestionText());
                ques.setCorrectAnswer(question.getCorrectAnswer());
                ques.setCategory(question.getCategory());
                ques.setPassageText(question.getPassageText());
                ques.setAudioPath(question.getAudioPath());
                ques.setExam(question.getExam());
                // Lưu lại câu hỏi đã cập nhật
                return questionRepository.save(ques);
            // Hoặc ném ngoại lệ nếu câu hỏi không tìm thấy
        }
        return null; // Hoặc ném ngoại lệ nếu người dùng không tìm thấy
    }
    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}
