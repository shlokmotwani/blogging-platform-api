package com.example.blogging_platform.services;

import com.example.blogging_platform.models.Post;
import com.example.blogging_platform.repositories.BlogRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BlogPostService implements PostService{
    private BlogRepository blogRepository;

    public BlogPostService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Override
    public Post createPost(Post post) {
        return blogRepository.save(post);
    }

    @Override
    public Post getPost(Long id) {
        return null;
    }

    @Override
    public Post getAllPosts() {
        return null;
    }

    @Override
    public Post updatePost(Long id, Post post) {
        return null;
    }

    @Override
    public Post patchPost(Long id, Post post) {
        return null;
    }

    @Override
    public Post deletePost(Long id) {
        return null;
    }
}
