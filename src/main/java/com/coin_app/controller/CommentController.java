package com.coin_app.controller;

import com.coin_app.entity.Comment;
import com.coin_app.entity.Post;
import com.coin_app.service.CommentService;
import com.coin_app.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@Slf4j
public class CommentController {

    private CommentService commentService;
    private PostService postService;
    @PostMapping("/create-comment")
    public String createComment(@RequestParam(required = true) String title,
                                @RequestParam(required = true) String textDescription,
                                @RequestParam String username,
                                @RequestParam String email,
                                @RequestParam int postId,
                                Model model) {
        // Сохранение комментария
        Comment comment = commentService.save(title, textDescription, username, email, postId);

        // Передача комментария в модель
        model.addAttribute("comment", comment);

        // Передаем весь пост в модель для отображения
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);

        // Возвращаем текущую страницу (обновляем)
        return "post_detail";
    }
}
