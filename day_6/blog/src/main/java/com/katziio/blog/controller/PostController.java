package com.katziio.blog.controller;


import com.katziio.blog.entity.Comment;
import com.katziio.blog.entity.Post;
import com.katziio.blog.service.CommentService;
import com.katziio.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/blogApi")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/addPost")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        boolean isPostAdded = postService.addPost(post);

        if (isPostAdded) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/getPosts")
    public List<Post> getPosts() {
       return this.postService.getAllPosts();
    }


}
