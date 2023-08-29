package com.example.blogwithsecurity.Controllers;

import com.example.blogwithsecurity.Models.Blog;
import com.example.blogwithsecurity.Models.User;
import com.example.blogwithsecurity.Services.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/blogs")
public class BlogController {

    private final BlogService blogService;


    @GetMapping("/get")
    public ResponseEntity<?> getAllBlogs() {

        return ResponseEntity.ok(blogService.getBlogs());
    }


    @GetMapping("/get-mine")
    public ResponseEntity<?> getMyBlogs(@AuthenticationPrincipal User user) {

        return ResponseEntity.ok(blogService.getUserBlogs(user.getId()));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBlog(@AuthenticationPrincipal User user, @RequestBody @Valid Blog blog) {

        blogService.addBlog(blog, user.getId());
        return ResponseEntity.ok("Blog added !");
    }

    @PutMapping("/update/{blogId}")
    public ResponseEntity<?> updateBlog(@AuthenticationPrincipal User user, @PathVariable Integer blogId, @RequestBody @Valid Blog blogUpdate) {

        blogService.editBlog(user.getId(), blogId, blogUpdate);
        return ResponseEntity.ok("Blog updated !");
    }

    @DeleteMapping("/delete/{blogId}")
    public ResponseEntity<?> deleteBlog(@AuthenticationPrincipal User user, @PathVariable Integer blogId) {

        blogService.deleteBlog(user.getId(), blogId);
        return ResponseEntity.ok("Blog deleted !");
    }
}
