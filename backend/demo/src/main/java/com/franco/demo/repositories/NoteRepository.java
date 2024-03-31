package com.franco.demo.repositories;


import com.franco.demo.domain.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends BaseRepository<Note, Long> {

    @Query(value =  "SELECT n FROM Note n WHERE n.category.name = :filtro")
    public List<Note> obtenerNotasPorCategoria(@Param("filtro") String filtro);
}
