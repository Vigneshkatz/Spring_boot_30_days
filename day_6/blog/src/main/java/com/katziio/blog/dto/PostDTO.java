package com.katziio.blog.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.katziio.blog.entity.Post;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@ToString
public class PostDTO {
    private Long id;
    private String title;
    private String excerpt;
    private String content;
    private String author;
    private Date published_at;
    private Date is_published;
    private Date created_at;
    private Date updated_at;

    public PostDTO(Long id, String title, String excerpt, String content, String author, Date published_at, Date is_published, Date created_at, Date updated_at) {
        this.id = id;
        this.title = title;
        this.excerpt = excerpt;
        this.content = content;
        this.author = author;
        this.published_at = published_at;
        this.is_published = is_published;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public PostDTO(Post post) {
        this.id=post.getId();
        this.title = post.getTitle();
        this.author=post.getAuthor();
        this.content=post.getContent();
        this.excerpt= post.getExcerpt();
        this.created_at=post.getCreated_at();
        this.updated_at=post.getUpdated_at();
        this.published_at=post.getPublished_at();
    }
}
