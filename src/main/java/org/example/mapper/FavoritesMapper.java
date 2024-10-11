package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.Favorites;
import org.example.entity.FavoritsSongDTO;
import org.example.entity.Songs;

import java.util.List;

@Mapper
public interface FavoritesMapper {
    //===============================================================================
    //已测试：select、insert、delete
    //===============================================================================
    //  查询用户的收藏列表
    @Select("SELECT \n" +
            "    f.user_id,\n" +
            "    s.song_id,\n" +
            "    s.song_name,\n" +
            "    s.file_path,\n" +
            "    a.album_name,\n" +
            "    ar.artist_name\n" +
            "FROM \n" +
            "    favorites f\n" +
            "JOIN \n" +
            "    songs s ON f.song_id = s.song_id\n" +
            "JOIN \n" +
            "    albums a ON s.album_id = a.album_id\n" +
            "JOIN \n" +
            "    artists ar ON s.artist_id = ar.artist_id\n" +
            "WHERE \n" +
            "    f.user_id = #{user_id}")
    List<FavoritsSongDTO> favoritesByUser_id(String user_id);
    //  添加收藏
    @Insert("INSERT INTO favorites (user_id,song_id) VALUES (#{user_id},#{song_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Favorites favorites);
    //  取消收藏
    @Delete("DELETE FROM favorites WHERE song_id = #{song_id} AND user_id = #{user_id}")
    int delete(Favorites favorites);
}
