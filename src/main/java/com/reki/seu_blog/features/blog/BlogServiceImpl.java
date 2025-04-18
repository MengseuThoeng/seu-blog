package com.reki.seu_blog.features.blog;

import com.reki.seu_blog.base.BasedResponse;
import com.reki.seu_blog.domain.Blog;
import com.reki.seu_blog.domain.Category;
import com.reki.seu_blog.features.blog.dto.BlogCreateRequest;
import com.reki.seu_blog.features.blog.dto.BlogResponse;
import com.reki.seu_blog.features.category.CategoryRepository;
import com.reki.seu_blog.mapper.BlogMapper;
import com.reki.seu_blog.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    private final BlogMapper blogMapper;

    private final CategoryRepository categoryRepository;

    public Set<Category> mapCategories(Set<String> categoryNames) {
        return categoryNames.stream()
                .map(name -> {
                    // Find category by name, throw exception if not found
                    return categoryRepository.findByName(name)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with name '" + name + "' does not exist"));
                })
                .collect(Collectors.toSet());
    }

    @Override
    public BasedResponse<?> createBlog(BlogCreateRequest request) {

        Set<Category> categories = mapCategories(request.categories());

        Blog blog = blogMapper.fromBlogCreateRequest(request);

        // Generate slug from title
        String slug = SlugUtil.createSlug(request.title());

        // Ensure slug is unique
        String uniqueSlug = SlugUtil.ensureUniqueSlug(slug,
                blogRepository::existsBySlug);

        blog.setSlug(uniqueSlug);
        blog.setCategories(categories);

        blogRepository.save(blog);

        return BasedResponse.builder()
                .code(HttpStatus.CREATED.value())
                .payload("Created blog successfully!")
                .build();
    }

    @Override
    public BlogResponse getBlogBySlug(String slug) {
        Blog blog = blogRepository.findBySlug(slug).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog with name '" + slug + "' does not exist")
        );
        return blogMapper.toBlogResponse(blog);
    }

    @Override
    public Page<BlogResponse> getAllBlog(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Blog> blogs = blogRepository.findAll(pageRequest);

        return blogs.map(blogMapper::toBlogResponse);
    }
}
