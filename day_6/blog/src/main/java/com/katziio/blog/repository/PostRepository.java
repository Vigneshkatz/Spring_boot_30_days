package com.katziio.blog.repository;

import com.katziio.blog.dto.PostDTO;
import com.katziio.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT new com.katziio.blog.dto.PostDTO(p.id, p.title, p.excerpt, p.content, p.author, p.published_at, p.is_published, p.created_at, p.updated_at) FROM Post p WHERE p.id = :postId")
    PostDTO findPostById(@Param("postId") Long postId);
}
