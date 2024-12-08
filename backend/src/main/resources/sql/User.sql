-- File: User.sql

-- Xóa dữ liệu trong bảng users nếu đã tồn tại để tránh trùng lặp
DELETE FROM users;

-- Thêm dữ liệu cho bảng users
INSERT INTO users (id, email, is_guest, password, role, username)
VALUES
    (1, 'admin@example.com', 0, 'AdminPass123', 'Admin', 'admin_user'),
    (2, 'teacher@example.com', 0, 'TeacherPass123', 'Teacher', 'teacher_user'),
    (3, 'student1@example.com', 0, 'StudentPass123', 'Student', 'student_user1'),
    (4, 'student2@example.com', 0, 'StudentPass456', 'Student', 'student_user2'),
    (5, 'guest@example.com', 1, NULL, 'Guest', 'guest_user'),
    (6, 'mailtest@xample.com',0,null,'test','TestDB');