package com.franco.demo.repositories;

import com.franco.demo.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category,Long> {
}
