package com.example.blogging_platform.controllers;

import com.example.blogging_platform.models.Post;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    public Post createPost(@RequestBody Post post){
        return null;
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable("id") Long id){
        return null;
    }

    @GetMapping()
    public Post getAllPosts(){
        return null;
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
