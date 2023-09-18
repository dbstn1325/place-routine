package com.pr.category.dto.request;

import com.pr.category.domain.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class CategoryCreateRequest {

    @NotBlank(message = "공백일 수는 없습니다.")
    private String name;


    public Category toEntity() {
        return new Category(this.name);
    }
}
