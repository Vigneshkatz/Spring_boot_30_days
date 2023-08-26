package com.katziio.blog.service;

import com.katziio.blog.dto.CommentDTO;
import com.katziio.blog.dto.PostDTO;
import com.katziio.blog.dto.PostDetailedDTO;
import com.katziio.blog.entity.Comment;
import com.katziio.blog.entity.Post;
import com.katziio.blog.repository.CommentRepository;
import com.katziio.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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

    public CommentDTO updateComment(Long postId, Comment comment, Long commentId) {
        Optional<Post> optionalPost = this.postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            for (Comment comments : post.getComments()) {
                if (comments.getId() == commentId) {
                    comments.setComment(comment.getComment());
                    comments.setUpdatedAt(Calendar.getInstance().getTime());
                }
            }
            this.postRepository.save(post);
        }
        Optional<Comment> optionalComment = this.commentRepository.findById((commentId));
        if (optionalComment.isPresent()) {
            return new CommentDTO((optionalComment.get()));
        }
        return null;
    }

    public PostDetailedDTO updatePostByID(Long postId, Post post) {
        Optional<Post> optionalPost = this.postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post dbPost = optionalPost.get();
            dbPost.setContent(post.getContent());
            dbPost.setExcerpt(post.getExcerpt());
            dbPost.setUpdated_at(post.getUpdated_at());
            this.postRepository.save(dbPost);
            System.out.println(dbPost.toString());
            return new PostDetailedDTO(dbPost);
        }
        return null;
    }
}
