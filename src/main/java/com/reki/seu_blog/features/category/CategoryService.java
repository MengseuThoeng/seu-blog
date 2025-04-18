package com.reki.seu_blog.features.category;

import com.reki.seu_blog.features.category.dto.CategoryResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    Page<CategoryResponse> getAllCategories(int page, int size);
}
