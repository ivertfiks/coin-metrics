package com.coin_app.service;

import com.coin_app.controller.PostController;
import com.coin_app.controller.UserController;
import com.coin_app.entity.Comment;
import com.coin_app.entity.Post;
import com.coin_app.entity.User;
import com.coin_app.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

    private CommentRepository commentRepository;
    private UserController userController;
    private PostService postService;

    public Comment save(String title, String text, String username, String email, int postId){
        User user = userController.createUser(username, email);
        Post post = postService.getPostById(postId);
        return commentRepository.save(new Comment(title, text, user, post));
    }

}
