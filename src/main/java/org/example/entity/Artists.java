package org.example.entity;

import lombok.Data;

@Data
public class Artists {
    private int artist_id;
    private String artist_name;
    private String biography;
    private String nationality;
    private String official_website;
    private String image_url;
}
