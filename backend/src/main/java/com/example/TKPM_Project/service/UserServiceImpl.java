package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.User;
import com.example.TKPM_Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return userRepository.save(user);
    }
    @Override
    public User update(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            user.setGuest(userDetails.isGuest());
            return userRepository.save(user);
        }
        return null; // Hoặc ném ngoại lệ nếu người dùng không tìm thấy
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
