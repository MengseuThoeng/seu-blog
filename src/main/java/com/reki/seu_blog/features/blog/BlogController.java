package com.reki.seu_blog.features.blog;


import com.reki.seu_blog.base.BasedResponse;
import com.reki.seu_blog.features.blog.dto.BlogCreateRequest;
import com.reki.seu_blog.features.blog.dto.BlogResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public BasedResponse<?> createBlog(@Valid @RequestBody BlogCreateRequest request){
        return blogService.createBlog(request);
    }


    @PreAuthorize("permitAll()")
    @GetMapping("/{slug}")
    public BlogResponse getBlogBySlug(@PathVariable String slug){
//        System.out.println("JWT: " + jwt.getId());
        return blogService.getBlogBySlug(slug);
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public Page<BlogResponse> getAllBlog(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return blogService.getAllBlog(page, size);
    }


}
