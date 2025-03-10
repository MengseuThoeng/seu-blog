package com.reki.seu_blog.features.blog;

import com.reki.seu_blog.base.BasedResponse;
import com.reki.seu_blog.domain.Blog;
import com.reki.seu_blog.features.blog.dto.BlogCreateRequest;

public interface BlogService {

    BasedResponse<?> createBlog(BlogCreateRequest request);



}
