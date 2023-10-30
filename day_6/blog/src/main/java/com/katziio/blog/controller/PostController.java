package com.katziio.blog.controller;

import com.katziio.blog.dto.PostDTO;
import com.katziio.blog.entity.Post;
import com.katziio.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/blogApi")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Post> addPost(
            @PathVariable Long userId,
            @RequestBody Post post) {
        boolean isPostAdded = postService.addPost(userId, post);
        if (isPostAdded) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{postId}")
    public PostDTO getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("/{userId}/posts")
    public List<PostDTO> getPostByUserId(@PathVariable Long userId) {
        return postService.getPostByUserId(userId);
    }

    @DeleteMapping("/posts/{postId}")
    public PostDTO deletePostById(@PathVariable Long postId) {
        return postService.deletePostById(postId);
    }

    @GetMapping("/posts/sortBy/{sortKey}")
    public List<PostDTO> sortPostBySortKey(@PathVariable String sortKey)
    {
        return this.postService.getPostsBySortKey(sortKey);
    }
    @GetMapping("/posts/filterBy/{filterKey}")
    public List<PostDTO> filterPostBySortKey(@PathVariable String filterKey, @RequestParam String value)
    {
        return this.postService.filterPostBy(filterKey,value);
    }

    @GetMapping("/post/getAuthors")
    public Set<String> getAuthorNames()
    {
        return this.postService.getAuthorNameList();
    }

    @GetMapping("/post/getDates")
    public Set<Date> getDates()
    {
        return this.postService.getDateList();
    }

    @GetMapping("/post/getTags")
    public Set<String> getTags()
    {
        return this.postService.getTagNameList();
    }
}
