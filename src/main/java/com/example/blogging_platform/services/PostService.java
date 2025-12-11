package com.example.blogging_platform.services;

import com.example.blogging_platform.dtos.PostPatchDTO;
import com.example.blogging_platform.exceptions.PostNotFoundException;
import com.example.blogging_platform.models.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post getPostById(Long id) throws PostNotFoundException;
    List<Post> getAllPosts();
    Post updatePost(Long id, Post post);
    Post patchPost(Long id, PostPatchDTO postPatchDTO) throws PostNotFoundException;
    void deletePost(Long id);
}
