package src.main.java;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

public class HuggingFaceAPIExample {

    private static final String HF_API_URL = "https://api-inference.huggingface.co/models/bert-base-uncased";  // Mô hình cho task fill-mask
    private static final String HF_API_KEY = "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";

    public static void main(String[] args) throws Exception {
        // Đặt câu có token [MASK] để mô hình có thể điền từ vào
        String inputText = "Hello, how are you [MASK] today?";

        // Tạo HTTP client
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(HF_API_URL);

        // Thiết lập headers cho yêu cầu
        post.setHeader("Authorization", "Bearer " + HF_API_KEY);
        post.setHeader("Content-Type", "application/json");

        // Cấu trúc body của yêu cầu
        String jsonBody = "{ \"inputs\": \"" + inputText + "\" }";
        StringEntity entity = new StringEntity(jsonBody);
        post.setEntity(entity);

        // Gửi yêu cầu và nhận phản hồi
        try (CloseableHttpResponse response = client.execute(post)) {
            HttpEntity responseEntity = response.getEntity();
            String responseString = EntityUtils.toString(responseEntity);

            // In kết quả phản hồi
            System.out.println("Hugging Face API Response: " + responseString);

            // Giải mã phản hồi JSON
            // Phản hồi từ API là một mảng JSON, vì vậy ta dùng JSONArray
            JSONArray jsonArray = new JSONArray(responseString);
            System.out.println("Question is: "+inputText);
            // In ra các câu gợi ý và điểm số
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject suggestion = jsonArray.getJSONObject(i);
                String sequence = suggestion.getString("sequence");
                double score = suggestion.getDouble("score");

                System.out.println("Suggested sentence: " + sequence );
            }
        }
    }
}
