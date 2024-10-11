package org.example.entity;

import lombok.Data;

@Data
public class FavoritsSongDTO {
    private String user_id;
    private int song_id;
    private String song_name;
    private String file_path;
    private String album_name;
    private String artist_name;
}
