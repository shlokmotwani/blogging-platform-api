package com.example.blogging_platform.services;

import com.example.blogging_platform.dtos.PostCreateDTO;
import com.example.blogging_platform.dtos.PostPatchDTO;
import com.example.blogging_platform.dtos.PostResponseDTO;
import com.example.blogging_platform.dtos.PostUpdateDTO;
import com.example.blogging_platform.exceptions.PostNotFoundException;
import com.example.blogging_platform.models.Post;
import com.example.blogging_platform.models.Tag;
import com.example.blogging_platform.repositories.BlogPostRepository;
import com.example.blogging_platform.utilities.PostMapper;
import com.example.blogging_platform.utilities.TagMapper;
import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class BlogPostService implements PostService{
    private BlogPostRepository blogPostRepository;
    private PostMapper postMapper;
    private TagMapper tagMapper;

    public BlogPostService(BlogPostRepository blogPostRepository, PostMapper postMapper, TagMapper tagMapper){
        this.blogPostRepository = blogPostRepository;
        this.postMapper = postMapper;
        this.tagMapper = tagMapper;
    }

    @Override
    public PostResponseDTO createPost(PostCreateDTO postCreateDTO) throws BadRequestException {
        if(postCreateDTO.getTitle() == null || postCreateDTO.getContent() == null){
            throw new BadRequestException(String.format("Invalid input"));
        }
        // DTO -> Entity
        Post postEntity = postMapper.toEntity(postCreateDTO);

        // Entity -> gets saved in the DB
        Post savedPost = blogPostRepository.save(postEntity);

        return postMapper.toResponseDTO(savedPost);
    }

    @Override
    public PostResponseDTO getPostById(Long id) throws PostNotFoundException {
        Optional<Post> postOptional =  blogPostRepository.findById(id);
        if(postOptional.isEmpty()){
            throw new PostNotFoundException(String.format("Post with id: %d does not exist.", id));
        }
        return postMapper.toResponseDTO(postOptional.get());
    }

    @Override
    public List<PostResponseDTO> getAllPosts() {
        List<Post> posts = blogPostRepository.findAll();
        List<PostResponseDTO> postDTOList= new ArrayList<>();
        for(Post post: posts){
            postDTOList.add(postMapper.toResponseDTO(post));
        }
        return postDTOList;
    }

    @Override
    public PostResponseDTO updatePost(Long id, PostUpdateDTO postUpdateDTO) throws PostNotFoundException {
        Optional<Post> postOptional = blogPostRepository.findById(id);
        if(postOptional.isEmpty()){
            throw new PostNotFoundException(String.format("Post with id: %d does not exist.", id));
        }
        Post postFromDB = postOptional.get();
        postFromDB.setTitle(postUpdateDTO.getTitle());
        postFromDB.setContent(postUpdateDTO.getContent());
        postFromDB.setCategory(postUpdateDTO.getCategory());

        postFromDB.setTags(tagMapper.toTagList(postUpdateDTO.getTagNames()));

        return postMapper.toResponseDTO(blogPostRepository.save(postFromDB));
    }

    @Override
    public PostResponseDTO patchPost(Long id, PostPatchDTO postPatchDTO) throws PostNotFoundException {
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

        if(postPatchDTO.getTagNames() != null){
            postFromDB.setTags(tagMapper.toTagList(postPatchDTO.getTagNames()));
        }
        return postMapper.toResponseDTO(blogPostRepository.save(postFromDB));
    }

    public List<PostResponseDTO> getFilteredPosts(String searchTerm){
//        String searchPattern = "%" + searchTerm + "%";
//        System.out.println("DEBUG: Executing search with pattern: " + searchPattern);
        List<Post> posts = blogPostRepository.searchAllFields(searchTerm);
        List<PostResponseDTO> postDTOList= new ArrayList<>();
        for(Post post: posts){
            postDTOList.add(postMapper.toResponseDTO(post));
        }
        return postDTOList;
    }

    @Override
    public void deletePost(Long id) throws PostNotFoundException {
        Optional<Post> postOptional =  blogPostRepository.findById(id);
        if(postOptional.isEmpty()){
            throw new PostNotFoundException(String.format("Post with id: %d does not exist.", id));
        }
        blogPostRepository.deleteById(id);
    }
}
