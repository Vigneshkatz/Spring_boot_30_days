package com.katziio.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.katziio.blog.entity.Post;
import com.katziio.blog.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<PostDetailedDTO> posts = new ArrayList<>();

    public UserDTO(User user)
    {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password=user.getPassword();
        this.name=user.getName();
        for(Post post : user.getPosts())
        {
            posts.add(new PostDetailedDTO(post));
        }
    }
}
