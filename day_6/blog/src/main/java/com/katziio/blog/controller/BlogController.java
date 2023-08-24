package com.katziio.blog.controller;

import com.katziio.blog.dto.PostDetailedDTO;
import com.katziio.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogApi")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/postDetail/{postId}")
    public PostDetailedDTO getPostDetail(@PathVariable Long postId) {
        return this.blogService.getPostDetail(postId);
    }
}
