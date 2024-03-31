package com.franco.demo.services;

import com.franco.demo.domain.Category;
import com.franco.demo.dtos.CategoryDto;
import com.franco.demo.mapper.BaseMapper;
import com.franco.demo.mapper.CategoryMapper;
import com.franco.demo.repositories.BaseRepository;
import com.franco.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryDto, Long> implements CategoryService {
    private final CategoryMapper mapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(BaseRepository<Category, Long> baseRepository,
                               BaseMapper<Category, CategoryDto> baseMapper,
                               CategoryRepository categoryRepository,
                               CategoryMapper noteMapper) {
        super(baseRepository, baseMapper);
        this.mapper = noteMapper;
        this.categoryRepository = categoryRepository;
    }

}
