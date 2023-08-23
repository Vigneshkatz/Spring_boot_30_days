package com.katziio.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Data
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String excerpt;
    private String content;
    private String author;
    private Date published_at;
    private Date is_published;
    private Date created_at;
    private Date updated_at;
}
