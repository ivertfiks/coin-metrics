package com.coin_app.controller;

import com.coin_app.entity.Post;
import com.coin_app.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class PostController {

    private PostService postService;

    @GetMapping("/all-posts")
    public String getAllPostsData(Model model) {
        List<Post> posts = postService.getAllPosts();
        if (posts == null || posts.isEmpty()) {
            model.addAttribute("posts", new ArrayList<>()); // Пустой список вместо null
        } else {
            model.addAttribute("posts", posts);
        }
        return "posts";
    }

    @PostMapping("/create-post")
    public String createPost(@RequestParam(required = true) String title,
                             @RequestParam(required = true) String textDescription,
                             @RequestParam String username,
                             @RequestParam String email,
                             Model model){
        Post post = postService.create(title, textDescription, username, email);
        model.addAttribute("post", post);
        return "post_detail";
    }

    @GetMapping("/post-data/{id}")
    public String getPostById(@PathVariable(value = "id") int id,
                             Model model){
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post_detail";
    }
}
