package com.katziio.blog.controller;

import com.katziio.blog.dto.CommentDTO;
import com.katziio.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogApi")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/{postId}/getComments")
    public List<CommentDTO> getComments(@PathVariable Long postId) {
        return this.commentService.getCommentByPostID(postId);
    }
}