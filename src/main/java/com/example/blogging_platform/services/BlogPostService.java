package com.example.blogging_platform.services;

import com.example.blogging_platform.exceptions.PostNotFoundException;
import com.example.blogging_platform.models.Post;
import com.example.blogging_platform.repositories.BlogRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Post getPostById(Long id) throws PostNotFoundException {
        Optional<Post> postOptional =  blogRepository.findById(id);
        if(postOptional == null){
            throw new PostNotFoundException(String.format("Post with id: %d does not exist."));
        }
        return postOptional.get();
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
