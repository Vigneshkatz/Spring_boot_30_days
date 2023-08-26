package com.katziio.blog.service;

import com.katziio.blog.dto.CommentDTO;
import com.katziio.blog.entity.Comment;
import com.katziio.blog.entity.Post;
import com.katziio.blog.repository.CommentRepository;
import com.katziio.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public List<CommentDTO> getCommentByPostID(Long postId) {
        return this.commentRepository.findCommentByPostId(postId);
    }

    public CommentDTO deleteCommentById(Long commentId) {
        Optional<Comment> optionalComment = this.commentRepository.findById(commentId);
        if(optionalComment.isPresent())
        {
            this.commentRepository.deleteById(commentId);
            return new CommentDTO(optionalComment.get());
        }
        return null;
    }

    public CommentDTO addComment(Long postId,Comment comment) {
        Optional<Post> post = this.postRepository.findById(postId);
        if(post.isPresent())
        {
            post.get().getComments().add(comment);
            this.postRepository.save(post.get());
            return new CommentDTO(comment);
        }
        return null;
    }
}
