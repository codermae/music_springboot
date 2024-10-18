package org.example.mapper;
import org.apache.ibatis.annotations.*;
import org.example.entity.Songs;
import org.example.entity.resultSongDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface SongsMapper {
    //===============================================================================
    //已测试：findByKeyword、initSongs
    //===============================================================================
    //  歌曲查询：歌曲名、作者模糊查询
//    @Select("SELECT * FROM songs WHERE song_name LIKE CONCAT('%',#{keyword},'%') OR performer LIKE CONCAT('%',#{keyword},'%')")
    @Select("SELECT \n" +
            "    s.song_id,\n" +
            "    s.song_name,\n" +
            "    s.file_path,\n" +
            "    s.duration,\n " +
            "    a.album_name,\n" +
            "    ar.artist_name\n" +
            "FROM \n" +
            "    songs s\n" +
            "JOIN \n" +
            "    albums a ON s.album_id = a.album_id\n" +
            "JOIN \n" +
            "    artists ar ON s.artist_id = ar.artist_id\n" +
            "WHERE \n" +
            "    s.song_name LIKE CONCAT('%',#{keyword},'%') OR s.performer LIKE CONCAT('%',#{keyword},'%')")
    List<resultSongDTO> findByKeyword(String keyword);
    //  默认展示
    @Select("SELECT \n" +
            "    s.song_id,\n" +
            "    s.song_name,\n" +
            "    s.file_path,\n" +
            "    s.duration,\n" +
            "    a.album_name,\n" +
            "    ar.artist_name\n" +
            "FROM \n" +
            "    songs s\n" +
            "JOIN \n" +
            "    albums a ON s.album_id = a.album_id\n" +
            "JOIN \n" +
            "    artists ar ON s.artist_id = ar.artist_id\n" +
            "ORDER BY \n" +
            "    RAND()\n" +
            "LIMIT 5")
    List<resultSongDTO> initSongs();

    @Select("SELECT * FROM songs")
    List<Songs> allSongs();

    @Select("SELECT COUNT(*) FROM songs")
    int countSongs();

    @Select("SELECT genre, COUNT(*) AS numberOfSongs\n" +
            "FROM songs\n" +
            "WHERE genre IS NOT NULL\n" +
            "GROUP BY genre\n" +
            "ORDER BY numberOfSongs DESC;")
    List<Map<String,Object>> genreSong();

    @Insert("INSERT INTO songs (song_name, performer, artist_id, album_id, duration, file_path, publish_date, views, downloads,genre) VALUES (#{song_name}, #{performer}, #{artist_id}, #{album_id}, #{duration}, #{file_path}, #{publish_date}, #{views}, #{downloads},#{genre})")
    @Options(useGeneratedKeys = true,keyProperty = "song_id")
    int insert(Songs song);

    @Delete("DELETE FROM songs WHERE song_id = #{id}")
    int deleteById(int id);

    @Update("UPDATE songs SET song_name = #{song_name}, performer = #{performer}, artist_id = #{artist_id}, album_id = #{album_id}, duration = #{duration}, file_path = #{file_path}, publish_date = #{publish_date}, views = #{views}, downloads = #{downloads}, genre = #{genre} WHERE song_id = #{song_id}")
    int update(Songs song);

}
