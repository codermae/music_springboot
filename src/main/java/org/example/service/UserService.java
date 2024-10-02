package org.example.service;

import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public int insert(User user) {
        // 处理注册数据
        System.out.println(user);
        return userMapper.insert(user);
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User authenticate(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

}
