package com.coin_app.service;

import com.coin_app.controller.UserController;
import com.coin_app.entity.Post;
import com.coin_app.entity.User;
import com.coin_app.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private UserController userController;
    private PostRepository postRepository;

    public Post create(String title, String textDescription, String username, String email){
        User user = userController.createUser(username, email);
        Post post = new Post(title, textDescription, user);
        return postRepository.save(post);
    }

    public void addComment(){
        Post post = new Post();
        // post.setComments();  нужно тут прикрепить созданный комментарий к посту
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPostById(int id){
        return postRepository.getPostById(id);
    }

}
