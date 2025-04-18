package com.reki.seu_blog.features.category;


import com.reki.seu_blog.domain.Blog;
import com.reki.seu_blog.domain.Category;
import com.reki.seu_blog.features.category.dto.CategoryResponse;
import com.reki.seu_blog.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public Page<CategoryResponse> getAllCategories(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Category> categories = categoryRepository.findAll(pageRequest);

        return categories.map(categoryMapper::toCategoryResponse);
    }
}
