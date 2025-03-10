package com.reki.seu_blog.mapper;

import com.reki.seu_blog.domain.Blog;
import com.reki.seu_blog.features.blog.dto.BlogCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    @Mapping(target = "categories", ignore = true)
    Blog fromBlogCreateRequest(BlogCreateRequest blogCreateRequest);


}
