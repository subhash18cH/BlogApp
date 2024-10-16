package com.subhash.devApp.service;

import com.subhash.devApp.dtos.BlogDto;
import com.subhash.devApp.model.Blog;
import com.subhash.devApp.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public List<Blog> findAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog createBlog(String username, BlogDto blogDto) {
        Blog blog=new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setOwnerName(username);
        blog.setPublishedDate(LocalDate.now());
        return blogRepository.save(blog);
    }

    public List<Blog> getBlog(String username) {
        List<Blog> blogs=blogRepository.findByOwnerName(username).orElseThrow(()-> new RuntimeException("Blog does not exist"));
        return blogs;
    }

    public Blog updateBlog(String username,String content, Integer blogId) {
        Blog blog=blogRepository.findById(blogId).orElseThrow(()-> new RuntimeException("Blog not exist"));
        blog.setContent(content);
        return blogRepository.save(blog);
    }

    public String deleteBlog(String username,Integer blogId) {
        Blog blog=blogRepository.findById(blogId).orElseThrow(()-> new RuntimeException("Blog not exist"));
        blogRepository.delete(blog);
        return "blog with id "+blogId+" id successfully deleted";
    }

    public Blog getBlogById(Integer blogId) {
        Blog blog=blogRepository.findById(blogId).orElseThrow(()-> new RuntimeException("Blog not found"));
        return blog;
    }
}
