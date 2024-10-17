package com.coin_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    private String username;

    private String email;

    @OneToMany
    @JoinColumn(name = "posts_id")
    private List<Post> posts;

    @OneToMany
    @JoinColumn(name = "comments_id")
    private List<Comment> comments;
}
