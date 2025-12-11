package com.example.blogging_platform.dtos;
import com.example.blogging_platform.models.Tag;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.NonNull;

import java.util.List;

@Getter
@Setter
public class PostCreateDTO {
    @NonNull
    private String title;

    @NonNull
    private String content;

    private String category;
    private List<Tag> tags;
}
