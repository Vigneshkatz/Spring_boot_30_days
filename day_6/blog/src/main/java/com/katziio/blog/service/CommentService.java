package com.katziio.blog.service;

import com.katziio.blog.entity.Comment;
import com.katziio.blog.entity.Post;
import com.katziio.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    public boolean addPost(Comment comment) {
        commentRepository.save(comment);
        return true;
    }
}
