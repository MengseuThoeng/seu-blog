package com.reki.seu_blog.features.blog;


import com.reki.seu_blog.base.BasedResponse;
import com.reki.seu_blog.features.blog.dto.BlogCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/create")
    public BasedResponse<?> createBlog(@Valid @RequestBody BlogCreateRequest request){
        return blogService.createBlog(request);
    }

}
