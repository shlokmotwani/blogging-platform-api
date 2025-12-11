package com.example.blogging_platform.services;

import com.example.blogging_platform.models.Post;

public interface PostService {
    public Post createPost(Post post);
    public Post getPost(Long id);
    public Post getAllPosts();
    public Post updatePost(Long id, Post post);
    public Post patchPost(Long id, Post post);
    public Post deletePost(Long id);
}
