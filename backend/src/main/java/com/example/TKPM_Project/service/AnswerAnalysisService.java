package com.example.TKPM_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerAnalysisService {

    @Autowired
    private LLMApiService llmApiService;  // Dịch vụ Hugging Face LLM
    @Autowired
    private SpeechToTextService speechToTextService;  // Dịch vụ AssemblyAI (chuyển âm thanh thành văn bản)

    // Phân tích câu trả lời dưới dạng văn bản
    public String analyzeTextAnswer(String userAnswer) throws Exception {
        // Gọi LLM API (Hugging Face) để phân tích câu trả lời văn bản
        return llmApiService.analyzeAnswer(userAnswer);
    }

    // Chuyển đổi âm thanh thành văn bản và phân tích câu trả lời
    public String analyzeAudioAnswer(String audioUrl) throws Exception {
        // Chuyển đổi âm thanh thành văn bản
        String transcriptId = speechToTextService.transcribeAudio(audioUrl);

        // Đợi kết quả phiên âm
        String transcriptText = speechToTextService.getTranscriptionResult(transcriptId);

        // Nếu có kết quả phiên âm, phân tích câu trả lời
        if (!"Transcription is still in progress.".equals(transcriptText)) {
            return llmApiService.analyzeAnswer(transcriptText);  // Phân tích câu trả lời sau khi chuyển âm thành văn bản
        } else {
            return "Audio transcription is still in progress.";  // Trả về thông báo nếu quá trình phiên âm chưa hoàn thành
        }
    }
}
