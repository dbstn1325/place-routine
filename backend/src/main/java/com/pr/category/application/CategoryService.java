package com.pr.category.application;

import com.pr.category.domain.Category;
import com.pr.category.domain.CategoryRepository;
import com.pr.category.dto.request.CategoryCreateRequest;
import com.pr.category.dto.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponse save(CategoryCreateRequest request) {
        Category category = request.toEntity();
        categoryRepository.validateExistsById(request.getName());

        Category savedCategory = categoryRepository.save(category);
        return new CategoryResponse(savedCategory);
    }

}
