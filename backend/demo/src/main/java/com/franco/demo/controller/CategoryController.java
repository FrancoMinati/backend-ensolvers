package com.franco.demo.controller;

import com.franco.demo.domain.Category;
import com.franco.demo.dtos.CategoryDto;
import com.franco.demo.services.CategoryServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "api/v1/category")
public class CategoryController extends BaseControllerImpl<Category, CategoryDto, CategoryServiceImpl> {
    public CategoryController(CategoryServiceImpl service) {
        super(service);
    }
}
