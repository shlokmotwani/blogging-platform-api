package com.example.blogging_platform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "tags")
public class Tag {
    @Id
    private Long id;
    private String tag;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;
}
