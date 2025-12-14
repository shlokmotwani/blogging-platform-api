package com.example.blogging_platform.controllers;

import com.example.blogging_platform.dtos.PostCreateDTO;
import com.example.blogging_platform.dtos.PostPatchDTO;
import com.example.blogging_platform.dtos.PostResponseDTO;
import com.example.blogging_platform.dtos.PostUpdateDTO;
import com.example.blogging_platform.exceptions.PostNotFoundException;
import com.example.blogging_platform.services.BlogPostService;
import org.apache.coyote.BadRequestException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        return blogPostService.createPost(postCreateDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDTO getPostById(@PathVariable("id") Long id) throws PostNotFoundException {
        return blogPostService.getPostById(id);
    }

//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public List<PostResponseDTO> getAllPosts(){
//        return blogPostService.getAllPosts();
//    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PostResponseDTO> getFilteredPosts(@RequestParam(value = "searchTerm", required = false) String searchTerm){
        if(searchTerm == null || searchTerm.isBlank()){
            return blogPostService.getAllPosts();
        }
        return blogPostService.getFilteredPosts(searchTerm);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDTO updatePost(@PathVariable("id") Long id, @RequestBody PostUpdateDTO postUpdateDTO) throws PostNotFoundException, BadRequestException {
        return blogPostService.updatePost(id, postUpdateDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDTO patchPost(@PathVariable("id") Long id, @RequestBody PostPatchDTO postPatchDTO) throws PostNotFoundException {
        return blogPostService.patchPost(id, postPatchDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") Long id) throws PostNotFoundException {
        blogPostService.deletePost(id);
    }
}
