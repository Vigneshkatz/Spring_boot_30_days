package com.katziio.blog.controller;


import com.katziio.blog.entity.Post;
import com.katziio.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/addPost")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        boolean isPostAdded = postService.addPost(post);

        if (isPostAdded) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
