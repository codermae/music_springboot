package org.example.mapper;
import org.apache.ibatis.annotations.*;
import org.example.entity.User;
import java.util.List;  //导入 Java 标准库中的 List 类，用于返回多个对象。
@Mapper     //标记这是一个 MyBatis 的 Mapper 接口。
public interface UserMapper {   //定义了一个名为 UserMapper 的公共接口。
    //===============================================================================
    //已测试：findAll、insert、delete
    //===============================================================================
    //  查询所有用户信息
    @Select("SELECT * FROM users")
    List<User> findAll();
    //返回用户总数
    @Select("SELECT COUNT(*) FROM users")
    int countAllUser();

    //  查询指定用户信息
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);   //定义方法 findByUsername，传入参数 String username，返回类型为 User。
    //  创建用户
    @Insert("INSERT INTO users (username, password_hash, privilege,mobile, regist_date, update_date) VALUES (#{username}, #{password}, #{privilege},#{mobile}, #{regist_date}, #{update_date})")
    @Options(useGeneratedKeys = true, keyProperty = "user_id")   //设置自动获取主键值，并将其设置到对象的 id 属性上。
    int insert(User user);
    //  更新密码
    @Update("UPDATE users SET username = #{username}, password_hash = #{password_hash}, privilege = #{privilege},mobile = #{mobile} WHERE user_id = #{user_id}")
    int update(User user);
    //  删除用户
    @Delete("DELETE FROM users WHERE user_id = #{id}")
    int deleteById(int id);

}
