package com.coin_app.controller;

import com.coin_app.entity.Comment;
import com.coin_app.entity.Post;
import com.coin_app.service.CommentService;
import com.coin_app.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@Slf4j
public class CommentController {

    private CommentService commentService;
    private PostService postService;
    @PostMapping("/create-comment/{id}")
    public String createComment(@RequestParam(required = true) String title,
                                @RequestParam(required = true) String textDescription,
                                @RequestParam String username,
                                @RequestParam String email,
                                @PathVariable(value = "id") int postId,
                                Model model) {
        Comment comment = commentService.save(title, textDescription, username, email, postId);

        model.addAttribute("comment", comment);

        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);

        return "post_detail";
    }
}
