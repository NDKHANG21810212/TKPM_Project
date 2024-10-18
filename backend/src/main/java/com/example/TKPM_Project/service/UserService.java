package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.User;
import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    User save(User user);
    User update(Long id, User user);
    void deleteById(Long id);
}
