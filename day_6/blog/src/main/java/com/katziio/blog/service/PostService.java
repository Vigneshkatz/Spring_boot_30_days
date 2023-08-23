package com.katziio.blog.service;

import com.katziio.blog.entity.Post;
import com.katziio.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public boolean addPost(Post post) {
        postRepository.save(post);
        return true;
    }
}
