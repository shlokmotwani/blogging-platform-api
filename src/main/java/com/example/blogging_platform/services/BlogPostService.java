package com.example.blogging_platform.services;

import com.example.blogging_platform.dtos.PostPatchDTO;
import com.example.blogging_platform.exceptions.PostNotFoundException;
import com.example.blogging_platform.models.Post;
import com.example.blogging_platform.repositories.BlogPostRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class BlogPostService implements PostService{
    private BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public Post createPost(Post post) {
        return blogPostRepository.save(post);
    }

    @Override
    public Post getPostById(Long id) throws PostNotFoundException {
        Optional<Post> postOptional =  blogPostRepository.findById(id);
        if(postOptional.isEmpty()){
            throw new PostNotFoundException(String.format("Post with id: %d does not exist.", id));
        }
        return postOptional.get();
    }

    @Override
    public List<Post> getAllPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public Post updatePost(Long id, Post post) {
        return blogPostRepository.save(post);
    }

    @Override
    public Post patchPost(Long id, PostPatchDTO postPatchDTO) throws PostNotFoundException {
        Optional<Post> postOptional = blogPostRepository.findById(id);
        if(postOptional.isEmpty()){
            throw new PostNotFoundException(String.format("Post with id: %d does not exist.", id));
        }
        Post postFromDB = postOptional.get();
        if(postPatchDTO.getTitle() != null){
            postFromDB.setTitle(postPatchDTO.getTitle());
        }
        if(postPatchDTO.getContent() != null){
            postFromDB.setContent(postPatchDTO.getContent());
        }
        if(postPatchDTO.getCategory() != null){
            postFromDB.setCategory(postPatchDTO.getCategory());
        }
        if(postPatchDTO.getTags() != null){
            postFromDB.setTags(postPatchDTO.getTags());
        }
        return blogPostRepository.save(postFromDB);
    }

    @Override
    public void deletePost(Long id) {
        blogPostRepository.deleteById(id);
    }
}
