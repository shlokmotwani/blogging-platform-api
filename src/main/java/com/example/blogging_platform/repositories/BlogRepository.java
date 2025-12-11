package com.example.blogging_platform.repositories;

import com.example.blogging_platform.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Post, Long> {

    @Override
    public Post save(Post post);

    @Override
    public Optional<Post> findById(Long aLong);

    @Override
    public List<Post> findAll();

    @Override
    void deleteById(Long aLong);
}
