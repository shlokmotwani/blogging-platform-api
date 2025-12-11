package com.example.blogging_platform.services;

import com.example.blogging_platform.dtos.PostPatchDTO;
import com.example.blogging_platform.dtos.PostUpdateDTO;
import com.example.blogging_platform.exceptions.PostNotFoundException;
import com.example.blogging_platform.models.Post;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface PostService {
    Post createPost(Post post) throws BadRequestException;
    Post getPostById(Long id) throws PostNotFoundException;
    List<Post> getAllPosts();
    Post updatePost(Long id, PostUpdateDTO postUpdateDTO) throws PostNotFoundException;
    Post patchPost(Long id, PostPatchDTO postPatchDTO) throws PostNotFoundException;
    void deletePost(Long id) throws PostNotFoundException;
}
