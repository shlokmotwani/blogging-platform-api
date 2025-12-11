package com.example.blogging_platform.utilities;

import com.example.blogging_platform.dtos.PostCreateDTO;
import com.example.blogging_platform.dtos.PostResponseDTO;
import com.example.blogging_platform.models.Post;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static Post toEntity(PostCreateDTO dto){
        Post entity = new Post();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setCategory(dto.getCategory());
        entity.setTags(dto.getTags());

        return entity;
    }

    public static PostResponseDTO toResponseDTO(Post entity){
        PostResponseDTO dto = new PostResponseDTO();
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setCategory(entity.getCategory());
        dto.setTags(entity.getTags());

        return dto;
    }

    public static List<PostResponseDTO> toListOfPostResponseDTO(List<Post> posts){
        return posts.stream().map(post -> toResponseDTO(post)).collect(Collectors.toList());
    }
}
