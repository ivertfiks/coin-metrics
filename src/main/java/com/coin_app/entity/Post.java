package com.coin_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Post(String title, String text, String image, User user) {
        this.title = title;
        this.text = text;
        this.image = image;
        this.user = user;
    }

    private String title;
    
    @Lob
    @Column(columnDefinition = "TEXT")
    private String text;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;

    public String getFormattedCreationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd MMMM yyyy");
        return creationDate.format(formatter);
    }
}
