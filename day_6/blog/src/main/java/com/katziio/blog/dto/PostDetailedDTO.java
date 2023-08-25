package com.katziio.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.katziio.blog.entity.Comment;
import com.katziio.blog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
@ToString
public class PostDetailedDTO {
    private PostDTO postDTO;
    private List<CommentDTO> commentDTO= new ArrayList<>();

    public PostDetailedDTO(Post post) {
        for(Comment comment:post.getComments())
        {
            this.commentDTO.add(new CommentDTO(comment));
        }
        this.postDTO = new PostDTO(post);
    }

}
