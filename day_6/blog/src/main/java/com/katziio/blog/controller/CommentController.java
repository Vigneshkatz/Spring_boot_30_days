package com.katziio.blog.controller;

import com.katziio.blog.dto.CommentDTO;
import com.katziio.blog.entity.Comment;
import com.katziio.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogApi")
@CrossOrigin("*")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDTO> getCommentsForPost(@PathVariable Long postId) {
        return commentService.getCommentByPostID(postId);
    }

    @PostMapping("/posts/{postId}/comments")
    public CommentDTO addCommentToPost(
            @RequestBody Comment comment,
            @PathVariable Long postId) {
        return commentService.addComment(postId, comment);
    }

    @DeleteMapping("/comments/{commentId}")
    public CommentDTO deleteComment(@PathVariable Long commentId) {
        return commentService.deleteCommentById(commentId);
    }
}
