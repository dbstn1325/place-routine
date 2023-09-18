package com.pr.common.fixtures;

import com.pr.category.domain.Category;
import com.pr.category.dto.request.CategoryCreateRequest;

import java.time.LocalDateTime;

public class CategoryFixtures {

    public static final String 자격증_공부_카테고리 = "자격증 공부";
    public static final CategoryCreateRequest 자격증_공부_카테고리_생성_요청 = new CategoryCreateRequest(자격증_공부_카테고리);

    public static final String 잘못된_카테고리 = "20글자 이상 플레이스 루틴 카테고리";
    public static final CategoryCreateRequest 잘못된_카테고리_생성_요청 = new CategoryCreateRequest(잘못된_카테고리);

    public static final Long 테스트_카테고리_아이디 = 1L;


    public static Category 테스트_카테고리() { return new Category(자격증_공부_카테고리);
    }
}
