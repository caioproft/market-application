package com.pocs.MarketProject.controller;

import com.pocs.MarketProject.domain.model.Category;
import com.pocs.MarketProject.domain.request.CategoryCreateRequest;
import com.pocs.MarketProject.domain.request.CategoryUpdateRequest;
import com.pocs.MarketProject.domain.response.CategoryResponse;
import com.pocs.MarketProject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryResponse>> findAll(){
        List<CategoryResponse> categoryResponseList = categoryService.findAll();
        return new ResponseEntity<>(categoryResponseList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoryResponse> findOne(@PathVariable Long id){
        CategoryResponse response = categoryService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCategory(@RequestBody CategoryCreateRequest categoryCreateRequest){
        categoryService.create(categoryCreateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping( path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateRequest categoryUpdateRequest
    ){
        categoryService.update(id, categoryUpdateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
