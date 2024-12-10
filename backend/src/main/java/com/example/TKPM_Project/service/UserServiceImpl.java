package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.User;
import com.example.TKPM_Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

     @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        user.setPassword((user.getPassword()));  // Mã hóa mật khẩu khi lưu
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());  // Mã hóa mật khẩu khi cập nhật
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findByRole(String role) {
        return List.of();
    }

    @Override
    public boolean isAdmin(User user) {
        return false;
    }

    @Override
    public boolean isTeacher(User user) {
        return false;
    }

    @Override
    public boolean isStudent(User user) {
        return false;
    }
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
