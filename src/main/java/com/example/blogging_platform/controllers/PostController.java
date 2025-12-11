package com.example.blogging_platform.controllers;

import com.example.blogging_platform.dtos.PostCreateDTO;
import com.example.blogging_platform.dtos.PostResponseDTO;
import com.example.blogging_platform.exceptions.PostNotFoundException;
import com.example.blogging_platform.models.Post;
import com.example.blogging_platform.services.BlogPostService;
import com.example.blogging_platform.utilities.PostMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final BlogPostService blogPostService;

    public PostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @PostMapping()
    public PostResponseDTO createPost(@RequestBody PostCreateDTO postCreateDTO){
        // DTO -> Entity
        Post postEntity = PostMapper.toEntity(postCreateDTO);
        System.out.println(postEntity);
        // Entity -> gets saved in the DB
        Post savedPost = blogPostService.createPost(postEntity);
        System.out.println(savedPost);
        return PostMapper.toResponseDTO(savedPost);
    }

    @GetMapping("/{id}")
    public PostResponseDTO getPostById(@PathVariable("id") Long id) throws PostNotFoundException {
        Post postEntity = blogPostService.getPostById(id);
        return PostMapper.toResponseDTO(postEntity);
    }

    @GetMapping()
    public List<PostResponseDTO> getAllPosts(){
        List<Post> posts = blogPostService.getAllPosts();
        return PostMapper.toListOfPostResponseDTO(posts);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable("id") Long id, @RequestBody Post post){
        return null;
    }

    @PatchMapping("/{id}")
    public Post patchPost(@PathVariable("id") Long id, @RequestBody Post post){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id){
        return;
    }
}
