package com.example.blogging_platform.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Tag(){}

    @JsonCreator
    public Tag(String name){
        this.name = name;
    }

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;

    @Override
    public String toString() {
        return this.name;
    }
}
