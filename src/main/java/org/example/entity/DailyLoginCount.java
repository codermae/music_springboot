package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.util.Date;

@Data
public class DailyLoginCount {
//    private int id;
    private String date;
    private int count;

//    @JsonIgnore
    public String getDate() {
        return date;
    }

}

