package com.katziio.blog.service;

import com.katziio.blog.dto.PostDTO;
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
public class PostService {
    @Autowired
    private PostRepository postRepository;
    private boolean isSamplePost = true;

    @Autowired
    private CommentRepository commentRepository;

    public boolean addPost(Post post) {
        postRepository.save(post);
        return true;
    }

    public List<Post> getAllPosts() {
        boolean isPostAdded = true;
        if (isSamplePost) {
            Calendar calendar = Calendar.getInstance();

            Post post = new Post(
                    null,
                    "Sample Post Title",
                    "Excerpt of the sample post",
                    "Content of the sample post",
                    "John Doe",
                    calendar.getTime(),
                    calendar.getTime(),
                    calendar.getTime(),
                    calendar.getTime(),
                    null
            );
            isPostAdded = this.addPost(post);
        }
        this.isSamplePost = false;
        if (isPostAdded) {
            return this.postRepository.findAll();
        } else {
            return null;
        }
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
}
