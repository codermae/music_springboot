package org.example.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int user_id;
    private String username;
    private String password_hash;
    private String privilege;
    private Date regist_date;
    private Date update_date;
    public String getPassword() {
        return password_hash;
    }

    public void setPassword(String password) {
        this.password_hash = password;
    }

}
