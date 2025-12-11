package com.example.blogging_platform.services;

import com.example.blogging_platform.exceptions.PostNotFoundException;
import com.example.blogging_platform.models.Post;

public interface PostService {
    Post createPost(Post post);
    Post getPostById(Long id) throws PostNotFoundException;
    Post getAllPosts();
    Post updatePost(Long id, Post post);
    Post patchPost(Long id, Post post);
    Post deletePost(Long id);
}
