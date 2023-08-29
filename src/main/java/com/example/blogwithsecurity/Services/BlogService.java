package com.example.blogwithsecurity.Services;

import com.example.blogwithsecurity.ApiUtils.ApiException;
import com.example.blogwithsecurity.Models.Blog;
import com.example.blogwithsecurity.Models.User;
import com.example.blogwithsecurity.Repository.AuthRepository;
import com.example.blogwithsecurity.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final AuthRepository authRepository;


    public List<Blog> getBlogs() {

        return blogRepository.findAll();
    }

    public List<Blog> getUserBlogs(Integer userId) {

        User user = authRepository.findUserById(userId);

        return blogRepository.findAllByUser(user);
    }

    public void addBlog(Blog blog, Integer userId) {

        User user = authRepository.findUserById(userId);

        blog.setUser(user);
        blogRepository.save(blog);


    }

    public void editBlog(Integer userId, Integer blogId, Blog blogUpdate) throws ApiException {

        User user = authRepository.findUserById(userId);


        Blog blogInDb = blogRepository.findBlogById(blogId);


        if (blogInDb == null) throw new ApiException("Couldn't find a blog with this id");
        else if (blogInDb.getUser().getId() != user.getId())
            throw new ApiException("This blog does not belong to this user");

        blogInDb.setTitle(blogUpdate.getTitle());
        blogInDb.setBody(blogUpdate.getBody());
        blogRepository.save(blogInDb);
    }

    public void deleteBlog(Integer userId, Integer blogId) {

        User user = authRepository.findUserById(userId);

        Blog blogInDb = blogRepository.findBlogById(blogId);

        if (blogInDb == null) throw new ApiException("Couldn't find a blog with this id");
        else if (blogInDb.getUser().getId() != user.getId())
            throw new ApiException("This blog does not belong to this user");

        blogRepository.delete(blogInDb);
    }


}
