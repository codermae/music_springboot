package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class AlbumSongInfo {
    private Integer album_id;
    private String album_name;
    private String songs_info_str; // 用于存储从数据库返回的字符串
    private List<SongInfo> songs_info; // 用于存储转换后的列表

    // 构造函数
    public AlbumSongInfo(Integer album_id, String album_name, String songs_info_str) {
        this.album_id = album_id;
        this.album_name = album_name;
        this.setSongsInfoStr(songs_info_str); // 调用 setSongsInfoStr 方法
    }

    // Getters and Setters

    public Integer getAlbumId() {
        return album_id;
    }

    @JsonIgnore
    public void setAlbumId(Integer album_id) {
        this.album_id = album_id;
    }

    public String getAlbumName() {
        return album_name;
    }

    @JsonIgnore
    public void setAlbumName(String album_name) {
        this.album_name = album_name;
    }

    public String getSongsInfoStr() {
        return songs_info_str;
    }

    @JsonIgnore
    public void setSongsInfoStr(String songs_info_str) {
        this.songs_info_str = songs_info_str;
        this.songs_info = parseSongsInfo(songs_info_str);
    }

    public List<SongInfo> getSongsInfo() {
        return songs_info;
    }

    @JsonIgnore
    public void setSongsInfo(List<SongInfo> songs_info) {
        this.songs_info = songs_info;
    }

    // Helper method to convert songs_info_str to List<SongInfo>
    private List<SongInfo> parseSongsInfo(String songs_info_str) {
        if (songs_info_str == null || songs_info_str.isEmpty()) {
            System.out.println("Warning: Empty songs_info_str");
            return List.of();
        }

        // 使用正则表达式匹配每条歌曲信息
        Pattern pattern = Pattern.compile("\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(songs_info_str);

        return matcher.results()
                .map(matchResult -> matchResult.group(1).trim()) // 提取括号内的内容并去除首尾空格
                .map(song -> {
                    System.out.println("Parsing song info: " + song); // 添加日志输出
                    String[] parts = song.split("\\s*,\\s*");

                    // 打印分割后的结果
                    for (String part : parts) {
                        System.out.println(part.trim());
                    }

                    if (parts.length < 5) {
                        System.out.println("Warning: Incomplete song info: " + song);
                        return null; // 返回 null 表示这条记录无效
                    }

                    SongInfo songInfo = new SongInfo();
                    try {
                        songInfo.setSong_id(Integer.parseInt(parts[0].trim()));
                        songInfo.setSong_name(parts[1].trim().replaceAll("^\"|\"$", "").replaceAll("\\\\", ""));
                        songInfo.setPerformer(parts[2].trim().replaceAll("^\"|\"$", "").replaceAll("\\\\", ""));
                        songInfo.setDuration(parts[3].trim());
                        songInfo.setFile_path(parts[4].trim().replaceAll("^\"|\"$", "").replaceAll("\\\\", ""));
                        System.out.println(songInfo);
                    } catch (NumberFormatException e) {
                        System.out.println("Warning: Invalid number format in song info: " + song);
                        return null; // 返回 null 表示这条记录无效
                    }
                    return songInfo;
                })
                .filter(songInfo -> songInfo != null) // 过滤掉无效的记录
                .collect(Collectors.toList());
    }
}
