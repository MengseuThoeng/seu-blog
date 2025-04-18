package com.reki.seu_blog.mapper;

import com.reki.seu_blog.domain.Category;
import com.reki.seu_blog.features.category.dto.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toCategoryResponse(Category category);
}
