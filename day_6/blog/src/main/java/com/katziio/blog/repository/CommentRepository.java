package com.katziio.blog.repository;

import com.katziio.blog.dto.CommentDTO;
import com.katziio.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT new com.katziio.blog.dto.CommentDTO(c.commenterName, c.content) FROM Post p JOIN p.comments c WHERE p.id = :postId")
    List<CommentDTO> findCommentByPostId(@Param("postId") Long postId);

}
