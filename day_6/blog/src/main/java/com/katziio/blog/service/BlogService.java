package com.katziio.blog.service;

import com.katziio.blog.dto.CommentDTO;
import com.katziio.blog.dto.PostDTO;
import com.katziio.blog.dto.PostDetailedDTO;
import com.katziio.blog.repository.CommentRepository;
import com.katziio.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    public PostDetailedDTO getPostDetail(Long postId) {
        PostDTO post = this.postRepository.findPostById(postId);
        List<CommentDTO> comments = this.commentRepository.findCommentByPostId(postId);
        return new PostDetailedDTO(post, comments);
    }
}
