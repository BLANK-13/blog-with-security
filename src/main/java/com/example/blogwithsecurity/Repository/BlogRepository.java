package com.example.blogwithsecurity.Repository;

import com.example.blogwithsecurity.Models.Blog;
import com.example.blogwithsecurity.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Blog findBlogById(Integer id);

    List<Blog> findAllByUser(User user);
}
