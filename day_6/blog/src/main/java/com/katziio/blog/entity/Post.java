package com.katziio.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String excerpt;
    private String content;
    private String author;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date published_at;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date is_published;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updated_at;
    @OneToMany(targetEntity = Comment.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_post_id", referencedColumnName = "id")
    private List<Comment> comments;

    @OneToMany(targetEntity =Tag.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_post_tag_id", referencedColumnName = "id")
    private List<Tag> tags;
}
