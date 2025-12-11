package com.example.blogging_platform.dtos;
import com.example.blogging_platform.models.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostResponseDTO {
    private String title;
    private String content;
    private String category;
    private List<Tag> tags;
}
