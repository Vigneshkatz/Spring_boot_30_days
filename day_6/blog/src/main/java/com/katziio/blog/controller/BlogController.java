package com.katziio.blog.controller;

import com.katziio.blog.dto.CommentDTO;
import com.katziio.blog.dto.PostDetailedDTO;
import com.katziio.blog.entity.Comment;
import com.katziio.blog.entity.Post;
import com.katziio.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogApi")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/postsDetail/{postId}")
    public PostDetailedDTO getPostDetail(@PathVariable Long postId) {
        return blogService.getPostDetail(postId);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public CommentDTO updateComment(
            @PathVariable Long postId,
            @PathVariable Long commentId,
            @RequestBody Comment comment) {
        return blogService.updateComment(postId, comment, commentId);
    }

    @PutMapping("/posts/{postId}")
    public PostDetailedDTO updatePostById(
            @PathVariable Long postId,
            @RequestBody Post post) {
        return blogService.updatePostByID(postId, post);
    }
}
