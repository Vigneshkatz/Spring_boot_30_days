package com.katziio.blog.service;

import com.katziio.blog.dto.CommentDTO;
import com.katziio.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDTO> getCommentByPostID(Long postId) {
        return this.commentRepository.findCommentByPostId(postId);
    }
}
