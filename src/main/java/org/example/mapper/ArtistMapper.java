package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.Artists;

import java.util.List;

@Mapper
public interface ArtistMapper {
    //  查询所有歌手信息
    @Select("SELECT * FROM artists")
    List<Artists> findAll();
    //  id查找
    @Select("SELECT * FROM artists WHERE artist_id = #{id}")
    List<Artists> findById(int id);
    //  添加歌手
    @Insert("INSERT INTO artists (artist_name, biography, nationality, official_website, image_url) VALUES (#{artist_name}, #{biography}, #{nationality}, #{official_website}, #{image_url})")
    @Options(useGeneratedKeys = true,keyProperty = "artist_id")
    int insert(Artists artist);
    //  删除歌手
    @Delete("DELETE FROM artists WHERE artist_id = #{id}")
    int deleteById(int id);
    //  更新歌手信息
    @Update("UPDATE artists SET artist_name = #{artist_name}, biography = #{biography}, nationality = #{nationality}, official_website = #{official_website}, image_url = #{image_url} WHERE artist_id = #{artist_id}")
    int update(Artists artists);

}
