package com.pocs.MarketProject.mapper;

import com.pocs.MarketProject.domain.model.Category;
import com.pocs.MarketProject.domain.request.CategoryCreateRequest;
import com.pocs.MarketProject.domain.response.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponse categoryToCategoryResponse(Category category){

        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public Category categoryRequestToCategory(CategoryCreateRequest categoryCreateRequest) {

        Category category = new Category();
        category.setName(categoryCreateRequest.getName());

        return category;
    }
}
