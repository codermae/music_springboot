package org.example;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;  //导入 Java 标准库中的 List 类，用于返回多个对象。

@Mapper     //标记这是一个 MyBatis 的 Mapper 接口。
public interface UserMapper {   //定义了一个名为 UserMapper 的公共接口。
    @Select("SELECT * FROM userinfo")   //@Select 注解标记一个查询语句，从 userinfo 表中选择所有记录。
    List<User> getAllUser();    //定义了一个方法 getAllUser()，返回类型为 List<User>，表示返回一个用户列表。

    @Insert("INSERT INTO userinfo(Username,Password,Privileges) VALUES(#{Username},#{Password},#{Privileges})")
    void insertUser(User user); //定义了一个方法 insertUser()，接受一个 User 对象作为参数，并执行插入操作。
}
