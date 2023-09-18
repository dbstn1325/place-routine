package com.pr.category.dto.response;

import com.pr.category.domain.Category;
import lombok.Getter;

@Getter
public class CategoryResponse {
    private final Long id;
    private final String name;

    public CategoryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
