package com.pr.category.domain;

import com.pr.category.exception.ExistCategoryException;
import com.pr.category.exception.NoSuchCategoryException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(final String name);

    default void validateExistCategoryName(final String name) {
        if (existsByName(name)) {
            throw new ExistCategoryException();
        }
    }

    default Category getById(final Long id) {
        return findById(id)
                .orElseThrow(NoSuchCategoryException::new);
    }
}
