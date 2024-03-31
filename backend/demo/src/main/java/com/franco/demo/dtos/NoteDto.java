package com.franco.demo.dtos;

import com.franco.demo.domain.Category;
import lombok.Data;

@Data
public class NoteDto extends
        BaseDto {
    private String title;
    private String text;
    private CategoryDto category;
    private boolean active;
}
