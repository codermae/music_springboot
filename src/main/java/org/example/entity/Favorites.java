package org.example.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Favorites {
    private int id;
    private int user_id;
    private int song_id;
    private Date added_date;
}
