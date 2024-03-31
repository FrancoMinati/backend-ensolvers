package com.franco.demo.mapper;

import com.franco.demo.domain.Note;
import com.franco.demo.dtos.NoteDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper extends BaseMapper<Note, NoteDto> {
    NoteDto toDTO(Note source);
    Note toEntity(NoteDto source);
    List<NoteDto> toDTOsList(List<Note> source);
    List<Note> toEntitiesList(List<NoteDto> source);
}
