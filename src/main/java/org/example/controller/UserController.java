package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping
    public int createUser(@RequestBody User user) {
        return userService.insert(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User credentials) {
        // 从请求体中获取用户名和密码
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        // 调用服务层进行验证
        User user = userService.authenticate(username, password);
        if (user != null) {
            // 如果认证成功，可以返回用户信息或其他成功标识
            return ResponseEntity.ok().body(user);
        } else {
            // 如果认证失败，返回未授权状态码
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/{id}")
    public int updateUser(@PathVariable int id, @RequestBody User user) {
//        user.setId(id); // 确保更新的是指定 ID 的用户
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable int id) {
        return userService.deleteById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
