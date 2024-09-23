package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserMapper userMapper;
    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/getAll")
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @PostMapping("/add")
    public void insertUser(@RequestBody User user) {
        userMapper.insertUser(user);
    }
}
