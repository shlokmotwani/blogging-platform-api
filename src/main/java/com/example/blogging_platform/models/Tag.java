package com.example.blogging_platform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tag {
    @Id
    private Long id;
    private String tag;
}
