package com.example.blogging_platform.services;

import com.example.blogging_platform.dtos.PostCreateDTO;
import com.example.blogging_platform.dtos.PostPatchDTO;
import com.example.blogging_platform.dtos.PostResponseDTO;
import com.example.blogging_platform.dtos.PostUpdateDTO;
import com.example.blogging_platform.exceptions.PostNotFoundException;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface PostService {
    PostResponseDTO createPost(PostCreateDTO postCreateDTO) throws BadRequestException;
    PostResponseDTO getPostById(Long id) throws PostNotFoundException;
    List<PostResponseDTO> getAllPosts();
    PostResponseDTO updatePost(Long id, PostUpdateDTO postUpdateDTO) throws PostNotFoundException, BadRequestException;
    PostResponseDTO patchPost(Long id, PostPatchDTO postPatchDTO) throws PostNotFoundException;
    void deletePost(Long id) throws PostNotFoundException;
}
