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

    @GetMapping("/postDetail/{postId}")
    public PostDetailedDTO getPostDetail(@PathVariable Long postId) {
        return this.blogService.getPostDetail(postId);
    }

    @PutMapping("/{postId}/Comment/{commentId}")
    public CommentDTO updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody Comment comment) {
        return this.blogService.updateComment(postId, comment, commentId);
    }

    @PutMapping("/post/{postId}")
    public PostDetailedDTO updatePostById(@PathVariable Long postId, @RequestBody Post post){
        return this.blogService.updatePostByID(postId,post);

    }
}
