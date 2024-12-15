package com.example.TKPM_Project.controller;
import com.example.TKPM_Project.model.LoginRequest;
import com.example.TKPM_Project.model.Role;
import com.example.TKPM_Project.model.User;
import com.example.TKPM_Project.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000") // Hỗ trợ frontend tại port 3000
public class UserController {

    @Autowired
    private UserService userService;

    // Lấy danh sách tất cả người dùng
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    // Lấy thông tin người dùng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // Thêm mới người dùng
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        // Khi tạo người dùng mới, đảm bảo vai trò được gán đúng
        if (user.getRole() == null) {
            user.setRole(Role.Student);  // Mặc định là học sinh
        }
        User createdUser = userService.save(user);
        return ResponseEntity.ok(createdUser);
    }

    // Cập nhật thông tin người dùng
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User userDetails) {
        User updatedUser = userService.update(id, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    // Xóa người dùng theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        // Kiểm tra thông tin đăng nhập
        if (userService.existsByUsername(loginRequest.getUsername())) {
            User user = userService.findByUsername(loginRequest.getUsername());
            // Kiểm tra mật khẩu
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok(user);  // Đăng nhập thành công
            }
        }

        // Nếu không đăng nhập thành công, tạo guest user và trả về
        User guestUser = new User();
        guestUser.setId(5L); // Id mặc định cho guest
        guestUser.setUsername("guest_user");
        guestUser.setPassword(null); // Không cần mật khẩu cho guest
        guestUser.setEmail("guest@example.com");
        guestUser.setRole(Role.Guest); // Vai trò guest
        guestUser.setGuest(true); // Đánh dấu là guest

        return ResponseEntity.ok(guestUser); // Trả về đối tượng guest

}


    // Đăng xuất
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();  // Xóa thông tin session khi đăng xuất
        return ResponseEntity.ok("Đăng xuất thành công");
    }
}
