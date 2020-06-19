package com.pocs.MarketProject.service;

import com.pocs.MarketProject.domain.model.Category;
import com.pocs.MarketProject.domain.request.CategoryCreateRequest;
import com.pocs.MarketProject.domain.request.CategoryUpdateRequest;
import com.pocs.MarketProject.domain.response.CategoryResponse;
import com.pocs.MarketProject.exceptions.CategoryExistsException;
import com.pocs.MarketProject.exceptions.CategoryNotFound;
import com.pocs.MarketProject.mapper.CategoryMapper;
import com.pocs.MarketProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public List<CategoryResponse> findAll() {

        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryResponse> categoryResponseList = new ArrayList<>();

        for(Category category : categoryList){
            categoryResponseList.add(categoryMapper.categoryToCategoryResponse(category));
        }

        return categoryResponseList;
    }

    public void create(CategoryCreateRequest categoryCreateRequest) {
        if(categoryRepository.existsByName(categoryCreateRequest.getName())){
            throw new CategoryExistsException("Categoria já cadastrada");
        }

        Category category = categoryMapper.categoryRequestToCategory(categoryCreateRequest);
        categoryRepository.save(category);
    }

    public CategoryResponse findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFound("Categoria não encontrada"));
        CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);

        return categoryResponse;
    }

    public void update(Long id, CategoryUpdateRequest categoryUpdateRequest) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFound("Categoria não encontrada"));
        categoryMapper.categoryUpateRequestToCategory(category, categoryUpdateRequest);
    }
}
