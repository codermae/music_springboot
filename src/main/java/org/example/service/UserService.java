package org.example.service;

import org.example.entity.DailyLoginCount;
import org.example.entity.User;
import org.example.mapper.DailyLoginCountMapper;
import org.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final DailyLoginCountMapper dailyLoginCountMapper;
    public UserService(UserMapper userMapper,DailyLoginCountMapper dailyLoginCountMapper) {
        this.userMapper = userMapper;
        this.dailyLoginCountMapper = dailyLoginCountMapper;
    }

    public int countUser(){
        return userMapper.countAllUser();
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
        List<DailyLoginCount> dailyLoginCounts = dailyLoginCountMapper.loginCount();
        DailyLoginCount dailyLoginCount = null;
        //获取当前登录日期y-m-d
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //检查今日登录次数
        for (DailyLoginCount count : dailyLoginCounts) {
            String datePart = extractDatePart(count.getDate());
            if (datePart.equals(formattedDate)) {
                dailyLoginCount = count;
                break;
            }
        }
        if (user != null && user.getPassword().equals(password)) {
            if (dailyLoginCount != null) {
                this.dailyLoginCountMapper.updateLoginCount(formattedDate);
            } else {
                this.dailyLoginCountMapper.insertLoginCount(formattedDate);
            }
            return user;
        } else {
            return null;
        }
    }
    private String extractDatePart(String dateTimeStr) {
        // 提取日期部分
        ZonedDateTime dateTime = ZonedDateTime.parse(dateTimeStr);
        LocalDate date = dateTime.toLocalDate();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public List<DailyLoginCount> loginCount() {
        return dailyLoginCountMapper.loginCount();
    }

}
