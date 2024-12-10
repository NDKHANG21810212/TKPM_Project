package com.example.TKPM_Project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.json.JSONObject;

@Service
public class SpeechToTextService {

    @Value("${assemblyai.api.key}")
    private String apiKey; // Đọc API key từ file cấu hình

    private static final String API_URL = "https://api.assemblyai.com/v2/transcript";

    public String transcribeAudio(String audioUrl) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("audio_url", audioUrl);

        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);

        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
        JSONObject responseJson = new JSONObject(response.getBody());
        return responseJson.getString("id");
    }

    public String getTranscriptionResult(String transcriptId) throws Exception {
        String statusUrl = "https://api.assemblyai.com/v2/transcript/" + transcriptId;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(statusUrl, HttpMethod.GET, entity, String.class);

        JSONObject responseJson = new JSONObject(response.getBody());
        if ("completed".equals(responseJson.getString("status"))) {
            return responseJson.getString("text");
        } else {
            return "Transcription is still in progress.";
        }
    }
}
