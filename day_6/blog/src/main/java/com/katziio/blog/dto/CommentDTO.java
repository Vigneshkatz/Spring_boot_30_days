package com.katziio.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.katziio.blog.entity.Comment;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Calendar;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@ToString
public class CommentDTO {
    private Long id;
    private String name;
    private String comment;
    private Date createdAt;
    private Date updatedAt;
    private String email;

    public CommentDTO(String name, String comment, String email, Date createdAt, Date updatedAt) {
        this.name = name;
        this.comment = comment;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.email = email;
    }

    public CommentDTO(Comment comment) {
        this.name = comment.getName();
        this.comment = comment.getComment();
        this.updatedAt = comment.getUpdatedAt();
        this.createdAt = comment.getCreatedAt();
        this.email = comment.getEmail();
    }
}
