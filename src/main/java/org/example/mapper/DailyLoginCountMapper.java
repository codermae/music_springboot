package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.entity.DailyLoginCount;

import java.util.List;


@Mapper
public interface DailyLoginCountMapper {
    @Select("SELECT date,count FROM daily_login_counts")
    List<DailyLoginCount> loginCount();

    //登录次数+1 => UserService
    @Update("UPDATE daily_login_counts SET count = count + 1 WHERE date = #{date}")
    int updateLoginCount(String date);

    //新增今日登录=> UserService
    @Insert("INSERT INTO daily_login_counts (date, count) VALUES (#{date}, 1)")
    int insertLoginCount(String date);

}
