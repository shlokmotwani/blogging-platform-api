package com.example.blogging_platform.controllers;

import com.example.blogging_platform.dtos.PostCreateDTO;
import com.example.blogging_platform.dtos.PostPatchDTO;
import com.example.blogging_platform.dtos.PostResponseDTO;
import com.example.blogging_platform.dtos.PostUpdateDTO;
import com.example.blogging_platform.exceptions.PostNotFoundException;
import com.example.blogging_platform.models.Post;
import com.example.blogging_platform.services.BlogPostService;
import com.example.blogging_platform.utilities.PostMapper;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponseDTO createPost(@RequestBody PostCreateDTO postCreateDTO) throws BadRequestException {
        // DTO -> Entity
        Post postEntity = PostMapper.toEntity(postCreateDTO);
        // Entity -> gets saved in the DB
        Post savedPost = blogPostService.createPost(postEntity);

        return PostMapper.toResponseDTO(savedPost);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDTO getPostById(@PathVariable("id") Long id) throws PostNotFoundException {
        Post postEntity = blogPostService.getPostById(id);
        return PostMapper.toResponseDTO(postEntity);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PostResponseDTO> getAllPosts(){
        List<Post> posts = blogPostService.getAllPosts();
        return PostMapper.toListOfPostResponseDTO(posts);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDTO updatePost(@PathVariable("id") Long id, @RequestBody PostUpdateDTO postUpdateDTO) throws PostNotFoundException {
        Post savedPost =  blogPostService.updatePost(id, postUpdateDTO);
        return PostMapper.toResponseDTO(savedPost);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDTO patchPost(@PathVariable("id") Long id, @RequestBody PostPatchDTO postPatchDTO) throws PostNotFoundException {
        Post savedPost =  blogPostService.patchPost(id, postPatchDTO);
        return PostMapper.toResponseDTO(savedPost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") Long id) throws PostNotFoundException {
        blogPostService.deletePost(id);
    }
}
