package com.subhash.devApp.repository;

import com.subhash.devApp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Optional<List<Blog>> findByOwnerName(String username);
}