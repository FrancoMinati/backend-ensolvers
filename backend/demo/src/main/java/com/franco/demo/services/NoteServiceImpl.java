package com.franco.demo.services;


import com.franco.demo.domain.Note;
import com.franco.demo.dtos.NoteDto;
import com.franco.demo.exceptions.ServicioException;
import com.franco.demo.mapper.BaseMapper;
import com.franco.demo.mapper.NoteMapper;
import com.franco.demo.repositories.BaseRepository;
import com.franco.demo.repositories.NoteRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
public class NoteServiceImpl extends BaseServiceImpl<Note, NoteDto, Long> implements NoteService {

    private final NoteMapper noteMapper;
    private final NoteRepository noteRepository;
    private final CategoryService categoryService;

    @Autowired
    public NoteServiceImpl(BaseRepository<Note, Long> baseRepository,
                           BaseMapper<Note, NoteDto> baseMapper,
                           NoteRepository noteRepository,
                           NoteMapper noteMapper, CategoryService categoryService) {
        super(baseRepository, baseMapper);
        this.noteMapper = noteMapper;
        this.noteRepository = noteRepository;
        this.categoryService = categoryService;
    }

    @Override
    @Transactional
    public NoteDto changeStatus(Long id) throws Exception {
        try {
            if (id == null) {
                throw new ServicioException("La entidad a modificar debe contener un Id.");
            }

            Optional<Note> entityOptional = baseRepository.findById(id);

            if (entityOptional.isEmpty()) {
                throw new ServicioException("No se encontro la entidad con el id dado.");
            } else {
                Note note = entityOptional.get();
                note.setActive(!note.isActive());
                Note entityUpdate = baseRepository.save(note);
                return baseMapper.toDTO(entityUpdate);
            }
        } catch (Exception e) {
            throw new ServicioException(e.getMessage());
        }
    }

    public List<NoteDto> obtenerNotasPorCategoria(String filtro) throws ServicioException {
        try {
            List<Note> notes = noteRepository.obtenerNotasPorCategoria(filtro);
            return baseMapper.toDTOsList(notes);
        } catch (Exception e) {
            throw new ServicioException(e.getMessage());
        }
    }

}
