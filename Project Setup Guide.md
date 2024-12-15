# HƯỚNG DẪN CẤU HÌNH VÀ KHỞI CHẠY PROJECT
## 1. Yêu cầu hệ thống
- Java Development Kit (JDK): Phiên bản 22 hoặc cao hơn.
- Apache Maven: Phiên bản mới nhất.
- Node.js: Phiên bản mới nhất (dành cho frontend).
- MySQL Server: Phiên bản 8.0 hoặc cao hơn.
- Công cụ quản lý cơ sở dữ liệu: MySQL Workbench hoặc tương đương.
---
## 2. Chuẩn bị môi trường

### 2.1. Cài đặt các phần mềm cần thiết
1. Cài đặt Java JDK 22:
    - Tải JDK từ trang chính thức của Oracle: [https://www.oracle.com/java/technologies/javase-downloads.html](https://www.oracle.com/java/technologies/javase-downloads.html).
    - Cấu hình biến môi trường `JAVA_HOME` trỏ đến thư mục cài đặt JDK.

2. Cài đặt Maven:
    - Tải Maven từ trang chính thức: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi).
    - Cấu hình biến môi trường `MAVEN_HOME` trỏ đến thư mục cài đặt Maven và thêm vào `PATH`.

3. Cài đặt Node.js:
    - Tải Node.js từ [https://nodejs.org/](https://nodejs.org/) và làm theo hướng dẫn cài đặt.

4. Cài đặt MySQL Server:
    - Tải và cài đặt từ [https://dev.mysql.com/downloads/mysql/](https://dev.mysql.com/downloads/mysql/).
    - Tạo tài khoản `root` và cấu hình mật khẩu.

---

## 3. Cấu hình project

### 3.1. Tải source code từ GitHub
- Clone repository bằng lệnh:
  git clone gh repo clone NDKHANG21810212/TKPM_Project
- Hoặc git clone https://github.com/NDKHANG21810212/TKPM_Project.git
  cd TKPM_Project
  ```

### 3.2. Cấu hình backend

Tệp cấu hình `application.properties`:
Mở tệp `src/main/resources/application.properties` và đảm bảo các thông số sau được cấu hình:
```properties
spring.application.name=TKPM_Project
spring.datasource.url=jdbc:mysql://localhost:3306/vstep_exam_db
spring.datasource.username=root
spring.datasource.password=Mysql123
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
jwt.secret=your-actual-secret-key
assemblyai.api.key=426a928a08d2448f913526a9380c5f85
```

 Cấu hình MySQL:
1. Đăng nhập MySQL:
   bash
   mysql -u root -p
2. Tạo database:
   sql
   CREATE DATABASE vstep_exam_db;
   ```

Cài đặt thư viện:
- Mở terminal, chuyển đến thư mục backend, chạy lệnh:

  mvn clean install
  
- Maven sẽ tải các thư viện cần thiết dựa trên `pom.xml`.

3.3. Cấu hình frontend
1. Chuyển đến thư mục frontend:
   cd TKPM_Project/frontend
2. Cài đặt các gói cần thiết:
   npm install
3. Kiểm tra file `.env` trong thư mục frontend, đảm bảo URL API backend được cấu hình đúng:
   REACT_APP_API_URL=http://localhost:8080/api
## 4. Khởi chạy project

4.1. Khởi chạy backend
1. Dùng IntelliJ IDEA hoặc terminal:
    - IntelliJ IDEA:
        - Mở project trong IntelliJ IDEA.
        - Chạy file `TkpmProjectApplication.java`.
    - Terminal:
      mvn spring-boot:run
2. Kiểm tra backend hoạt động:
    - Mở trình duyệt và truy cập: `http://localhost:8080`.
    - Đảm bảo backend trả về thông báo hoặc API đang hoạt động.
### 4.2. Thêm dữ liệu mẫu
1. Chạy các file SQL trong thư mục:
   backend/src/main/resources/sql

### 4.3. Khởi chạy frontend
1. Dùng terminal:
   cd TKPM_Project/frontend
   npm start
2. Mở trình duyệt và truy cập: `http://localhost:3000` để kiểm tra giao diện frontend.
## 5. Kiểm tra tính năng chính
 5.1. Test API backend
- Dùng Postman hoặc Curl để gửi request đến các API của backend, ví dụ:
  curl -X GET http://localhost:8080/api/test/db-connection
- Nếu kết nối database thành công, API sẽ trả về thông báo xác nhận.
### 5.2. Test tính năng chuyển đổi giọng nói (Speech-to-Text)
1. Gửi request để chuyển đổi âm thanh thành văn bản qua API AssemblyAI:
   ```http
   POST http://localhost:8080/api/audio/transcribe
   Body: { "audio_url": "https://example.com/audio.mp3" }
2. Kiểm tra kết quả trả về từ AssemblyAI.
 5.3. Test tính năng phân tích câu trả lời (LLM)
1. Gửi câu trả lời văn bản đến API phân tích của backend:
   POST http://localhost:8080/api/answers/analyze
   Body: { "userAnswer": "This is an example answer." }
2. Kiểm tra phản hồi từ LLM (Hugging Face).
## 6. Xử lý lỗi phổ biến
Lỗi không kết nối được MySQL:
- Kiểm tra cấu hình trong `application.properties`:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/vstep_exam_db
  spring.datasource.username=root
  spring.datasource.password=Mysql123
- Đảm bảo MySQL Server đang chạy.
### Lỗi thiếu thư viện:
- Chạy lại lệnh Maven để tải lại thư viện:
  mvn clean install
  
Lỗi không chạy được frontend:
- Đảm bảo Node.js đã cài đặt đầy đủ.
- Xóa thư mục `node_modules` và chạy lại:
  rm -rf node_modules
  npm install
lỗi "Could not find or load main class com.example.TKPM_Project.TkpmProjectApplication"
- Hãy đảm bảo file TkpmProjectApplication.java nằm trong thư mục tương ứng với package com.example.TKPM_Project.
  Đường dẫn trong hệ thống tệp nên là:
  src/main/java/com/example/TKPM_Project/TkpmProjectApplication.java.
- Kiểm tra cấu hình Maven
  Xác minh rằng bạn đã reload Maven sau khi tải dự án từ GitHub:
  Trong IntelliJ IDEA, nhấp chuột phải vào file pom.xml > Maven > Reload Project.
  
- Trong IntelliJ IDEA:
  Nhấp vào menu Build > Build Project.
  Hoặc chạy lệnh Maven sau trong terminal: mvn clean install 

