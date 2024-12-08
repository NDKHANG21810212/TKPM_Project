package src.main.java.com.example.TKPM_Project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class LLMApiService {

    private static final String HF_API_URL = "https://api-inference.huggingface.co/models/gpt-3.5-turbo"; // URL API của LLM
    private static final String HF_API_KEY = "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"; // API Key của bạn

    // Phương thức gọi API LLM để phân tích câu trả lời của người dùng
    public String analyzeAnswer(String userAnswer) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + HF_API_KEY);
        headers.set("Content-Type", "application/json");

        String jsonBody = "{ \"inputs\": \"" + userAnswer + "\", \"parameters\": {\"max_tokens\": 100} }";
        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(HF_API_URL, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }
}
