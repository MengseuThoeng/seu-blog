package com.reki.seu_blog.mapper;

import com.reki.seu_blog.domain.Blog;
import com.reki.seu_blog.domain.Category;
import com.reki.seu_blog.features.blog.dto.BlogCreateRequest;
import com.reki.seu_blog.features.blog.dto.BlogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    @Mapping(target = "categories", ignore = true)
    Blog fromBlogCreateRequest(BlogCreateRequest blogCreateRequest);


    @Mapping(target = "categories", source = "categories")
    BlogResponse toBlogResponse(Blog blog);

    default Set<String> map(Set<Category> categories) {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toSet());
    }
}
