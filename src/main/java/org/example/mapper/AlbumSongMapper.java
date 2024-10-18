package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.example.entity.AlbumSongInfo;

import java.util.List;

@Mapper
public interface AlbumSongMapper {
    @Select("SELECT a.album_id, a.album_name, GROUP_CONCAT(CONCAT('(', s.song_id, ', \"', s.song_name, '\", \"', s.performer, '\", ', s.duration, ', \"', s.file_path, '\")') SEPARATOR ', ') AS songs_info_str FROM songs s JOIN albums a ON s.album_id = a.album_id GROUP BY a.album_id, a.album_name")
    @Results({
            @Result(property = "album_id", column = "album_id"),
            @Result(property = "album_name", column = "album_name"),
            @Result(property = "songs_info_str", column = "songs_info_str")
    })
    List<AlbumSongInfo> getAlbumSongInfo();
}
