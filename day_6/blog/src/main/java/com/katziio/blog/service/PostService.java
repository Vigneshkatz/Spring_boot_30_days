package com.katziio.blog.service;

import com.katziio.blog.entity.Comment;
import com.katziio.blog.entity.Post;
import com.katziio.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    private boolean isSamplePost = true;

    public boolean addPost(Post post) {

        postRepository.save(post);
        return true;
    }

    public List<Post> getAllPosts() {
        boolean isPostAdded = true;
        if(isSamplePost) {
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
        this.isSamplePost=false;
        if (isPostAdded) {
            return this.postRepository.findAll();
        } else {
            return null;
        }
    }

    public Post findPostById(Long postId) {
        return this.postRepository.findById(postId).orElseThrow(NoSuchElementException::new);
    }

    public void savePost(Post post) {
        this.postRepository.save(post);
    }


}
