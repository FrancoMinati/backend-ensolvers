package com.franco.demo.mapper;

import com.franco.demo.domain.Category;
import com.franco.demo.domain.Note;
import com.franco.demo.dtos.CategoryDto;
import com.franco.demo.dtos.NoteDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {
    CategoryDto toDTO(Category source);
    Category toEntity(CategoryDto source);
    List<CategoryDto> toDTOsList(List<Category> source);
    List<Category> toEntitiesList(List<CategoryDto> source);
}
