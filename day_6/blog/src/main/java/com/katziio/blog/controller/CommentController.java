package com.katziio.blog.controller;

import com.katziio.blog.entity.Comment;
import com.katziio.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/getComments")
    public List<Comment> getComments(@PathVariable Long postId)
    {
        return this.commentService.getAllComments(postId);
    }
}
