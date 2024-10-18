package com.example.TKPM_Project.service;
import com.example.TKPM_Project.model.Category;
import com.example.TKPM_Project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    @Override
    public Category update(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            // Cập nhật các thuộc tính của thể loại
            existingCategory.setCategoryName(category.getCategoryName()); // Cập nhật tên thể loại
            existingCategory.setDifficultyLevel(category.getDifficultyLevel()); // Cập nhật độ khó

            // Lưu lại thể loại đã cập nhật
            return categoryRepository.save(existingCategory);
        }
        return null; // Hoặc ném ngoại lệ nếu thể loại không tìm thấy
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
