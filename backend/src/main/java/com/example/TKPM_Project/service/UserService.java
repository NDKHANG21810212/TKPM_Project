package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.User;
import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    User save(User user);
    User update(Long id, User user);
    void deleteById(Long id);
    List<User> findByRole(String role);  // Thêm phương thức tìm theo vai trò
    boolean isAdmin(User user);  // Kiểm tra người dùng có phải admin không
    boolean isTeacher(User user);  // Kiểm tra người dùng có phải giáo viên không
    boolean isStudent(User user);  // Kiểm tra người dùng có phải học sinh không
}
