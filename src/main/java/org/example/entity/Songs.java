package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class Songs {
    private int song_id;
    private String song_name;
    private String performer;
    private int artist_id;
    private int album_id;
    private Time duration;
    private String file_path;
    private Date publish_date;
    private int views;
    private int downloads;
    private String genre;

    @JsonIgnore
    public void setId(int id) {
        this.song_id = id;
    }
}
