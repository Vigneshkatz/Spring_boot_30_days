package com.katziio.blog.service;

import com.katziio.blog.entity.Post;
import com.katziio.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

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
                    calendar.getTime()
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
}
