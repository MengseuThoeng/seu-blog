package com.reki.seu_blog.features.blog;


import com.reki.seu_blog.base.BasedResponse;
import com.reki.seu_blog.features.blog.dto.BlogCreateRequest;
import com.reki.seu_blog.features.blog.dto.BlogResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public BasedResponse<?> createBlog(@Valid @RequestBody BlogCreateRequest request){
        return blogService.createBlog(request);
    }

    @GetMapping("/{slug}")
    public BlogResponse getBlogBySlug(@PathVariable String slug){
        return blogService.getBlogBySlug(slug);
    }

    @GetMapping
    public Page<BlogResponse> getAllBlog(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return blogService.getAllBlog(page, size);
    }


}
