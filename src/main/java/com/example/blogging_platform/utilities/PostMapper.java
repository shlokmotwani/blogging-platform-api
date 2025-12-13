package com.example.blogging_platform.utilities;

import com.example.blogging_platform.dtos.PostBaseDTO;
import com.example.blogging_platform.dtos.PostResponseDTO;
import com.example.blogging_platform.models.Post;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public <T extends PostBaseDTO> Post toEntity(T dto){
        Post entity = new Post();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setCategory(dto.getCategory());

        return entity;
    }

    public PostResponseDTO toResponseDTO(Post entity){
        PostResponseDTO dto = new PostResponseDTO();
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setCategory(entity.getCategory());

        return dto;
    }

    public List<PostResponseDTO> toListOfPostResponseDTO(List<Post> posts){
        return posts.stream().map(post -> toResponseDTO(post)).collect(Collectors.toList());
    }
}
