package com.example.blogging_platform.utilities;

import com.example.blogging_platform.dtos.PostBaseDTO;
import com.example.blogging_platform.dtos.PostResponseDTO;
import com.example.blogging_platform.models.Post;
import com.example.blogging_platform.models.Tag;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {
    private TagMapper tagMapper;

    public PostMapper(TagMapper tagMapper){
        this.tagMapper = tagMapper;
    }

    public <T extends PostBaseDTO> Post toEntity(T dto){
        Post entity = new Post();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setCategory(dto.getCategory());

        List<String> tagNames = dto.getTagNames();
        List<Tag> tagList = tagMapper.toTagList(tagNames);
        entity.setTags(tagList);

        return entity;
    }

    public PostResponseDTO toResponseDTO(Post entity){
        PostResponseDTO dto = new PostResponseDTO();
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setCategory(entity.getCategory());

        List<String> tagNames = new ArrayList<>();
        List<Tag> tagList = entity.getTags();
        for(Tag tag: tagList){
            tagNames.add(tag.toString());
        }
        dto.setTagNames(tagNames);
        return dto;
    }

    public List<PostResponseDTO> toListOfPostResponseDTO(List<Post> posts){
        return posts.stream().map(post -> toResponseDTO(post)).collect(Collectors.toList());
    }
}
