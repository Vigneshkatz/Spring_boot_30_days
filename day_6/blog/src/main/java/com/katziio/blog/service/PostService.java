package com.katziio.blog.service;

import com.katziio.blog.dto.PostDTO;
import com.katziio.blog.entity.Comment;
import com.katziio.blog.entity.Post;
import com.katziio.blog.entity.User;
import com.katziio.blog.repository.CommentRepository;
import com.katziio.blog.repository.PostRepository;
import com.katziio.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    public boolean addPost(Long userId, Post post) {
        Optional<User> userOptional = this.userRepository.findById(userId);
        if (userOptional.isPresent()) {
            userOptional.get().getPosts().add(post);
            this.userRepository.save(userOptional.get());
            return true;
        }
        return false;
    }

    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    public PostDTO getPostById(Long postId) {
        return this.postRepository.findPostById(postId);
    }

    public PostDTO deletePostById(Long postId) {
        PostDTO postDTO = this.postRepository.findPostById(postId);
        this.postRepository.deleteById(postId);
        Optional<Post> optionalPost = this.postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            List<Comment> comments = post.getComments();
            this.commentRepository.deleteAll(comments);

            this.postRepository.deleteById(postId);
        }
        return postDTO;
    }

    public List<PostDTO> getPostByUserId(Long userId) {
        return this.postRepository.getPostByUserId(userId);
    }

    public List<PostDTO> getPostsBySortKey(String sortKey) {
        return this.postRepository.sortPostByKey(sortKey);
    }
}
