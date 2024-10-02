package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.Favorites;
import org.example.entity.Songs;

import java.util.List;

@Mapper
public interface FavoritesMapper {
    //===============================================================================
    //已测试：select、insert、delete
    //===============================================================================
    //  查询用户的收藏列表
    @Select("SELECT songs.* FROM favorites RIGHT JOIN songs ON favorites.song_id = songs.song_id WHERE favorites.user_id = #{user_id}")
    List<Songs> favoritesByUser_id(String user_id);
    //  添加收藏
    @Insert("INSERT INTO favorites (user_id,song_id) VALUES (#{user_id},#{song_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Favorites favorites);
    //  取消收藏
    @Delete("DELETE FROM favorites WHERE song_id = #{song_id} AND user_id = #{user_id}")
    int delete(Favorites favorites);
}
