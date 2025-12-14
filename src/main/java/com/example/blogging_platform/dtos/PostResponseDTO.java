package com.example.blogging_platform.dtos;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponseDTO extends PostBaseDTO{
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
