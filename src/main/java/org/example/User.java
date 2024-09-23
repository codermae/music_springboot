package org.example;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String Username;
    private String Password;
    private String Privileges;
    private Date Create_time;
    private Date Update_time;
}
