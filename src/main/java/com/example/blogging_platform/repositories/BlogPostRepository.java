package com.example.blogging_platform.repositories;

import com.example.blogging_platform.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogPostRepository extends JpaRepository<Post, Long> {

    @Override
    Post save(Post post);

    @Override
    Optional<Post> findById(Long aLong);

    @Override
    List<Post> findAll();

    @Query(value = "SELECT * FROM posts p WHERE " +
            "p.title LIKE %:searchTerm% OR " +
            "p.content LIKE %:searchTerm% OR " +
            "p.category LIKE %:searchTerm%",
            nativeQuery = true)
    List<Post> searchAllFields(@Param("searchTerm") String searchTerm);

    @Override
    void deleteById(Long aLong);
}
