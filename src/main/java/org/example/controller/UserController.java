package org.example.controller;

import org.example.entity.ApiResponse;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.aop.interceptor.AbstractTraceInterceptor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/countAll")
    public int countAll(){
        return userService.countUser();
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

    @PostMapping("/login/back")
    public ResponseEntity<Object> loginback(@RequestBody User credentials) {
        // 从请求体中获取用户名和密码
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        // 调用服务层进行验证
        User user = userService.authenticate(username, password);
        System.out.println(user);
        if (user == null) {
            // 如果用户不存在或认证失败，返回未授权状态码
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if ("root".equals(user.getPrivilege()) || "admin".equals(user.getPrivilege()) ) {
            // 如果认证成功，可以返回用户信息或其他成功标识
            return ResponseEntity.ok().body(user);
        } else {
            // 如果认证失败，返回未授权状态码
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/login/out")
    public String logout(String token) {
        return "退出成功";
    }

    @GetMapping("/login/userinfo")
    public ResponseEntity<ApiResponse> loginUserinfo(String token) {
        System.out.println("token:"+token);
        Map<String,String> exampleData = new HashMap<>();
        exampleData.put("name","wowowowowow");
        exampleData.put("avatar","wwqwqwqwqwqw");
        ApiResponse response = new ApiResponse(200,"成功",exampleData);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public int updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id); // 确保更新的是指定 ID 的用户
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
