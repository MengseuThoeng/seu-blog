package com.reki.seu_blog.features.blog;

import com.reki.seu_blog.base.BasedResponse;
import com.reki.seu_blog.domain.Blog;
import com.reki.seu_blog.features.blog.dto.BlogCreateRequest;
import com.reki.seu_blog.features.blog.dto.BlogResponse;
import org.springframework.data.domain.Page;

public interface BlogService {

    BasedResponse<?> createBlog(BlogCreateRequest request);

    BlogResponse getBlogBySlug(String slug);

    Page<BlogResponse> getAllBlog( int page, int size);

}
