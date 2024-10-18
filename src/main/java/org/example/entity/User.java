package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int user_id;
    private String username;
    private String password_hash;
    private String privilege;
    private String mobile;
    private Date regist_date;
    private Date update_date;

    @JsonIgnore
    public int getId() {return user_id;}

    @JsonIgnore
    public void setId(int id) {
        this.user_id = id;
    }

    @JsonIgnore
    public String getPassword() {
        return password_hash;
    }

//    @JsonIgnore
    public String getPrivilege() {
        return privilege;
    }

//    public void setPassword(String password) {
//        this.password_hash = password;
//    }
}
