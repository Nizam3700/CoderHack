package com.example.Hacker.Entity;





import java.util.List;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import javax.annotation.Generated;


@Document(collection="User")
@Data
public class User {

    @Id
    private String userId;
    private String username;
    private int score;
    private List<String> badges;

    public User() {
        this.score = 0;
        this.badges = new ArrayList<>();
    }






}
