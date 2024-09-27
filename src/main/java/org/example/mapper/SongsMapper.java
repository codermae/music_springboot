package org.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Songs;
import java.util.List;

@Mapper
public interface SongsMapper {
    //===============================================================================
    //已测试：findByKeyword、initSongs
    //===============================================================================
    //  歌曲查询：歌曲名、作者模糊查询
    @Select("SELECT * FROM songs WHERE song_name LIKE CONCAT('%',#{keyword},'%') OR performer LIKE CONCAT('%',#{keyword},'%')")
    List<Songs> findByKeyword(String keyword);
    //  默认展示
    @Select("SELECT * FROM (SELECT * FROM songs ORDER BY RAND() LIMIT 10) AS t ORDER BY RAND() LIMIT 5")
    List<Songs> initSongs();

}
