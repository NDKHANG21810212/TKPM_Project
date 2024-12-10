// src/axiosInstance.js
import axios from "axios";

// Tạo instance của Axios với cấu hình mặc định
const axiosInstance = axios.create({
    baseURL: "http://localhost:8080",  // Thay đổi theo URL API của bạn
    timeout: 10000,  // Thời gian timeout
    headers: {
        "Content-Type": "application/json",
    },
});

export default axiosInstance;
