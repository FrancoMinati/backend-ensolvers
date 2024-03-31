package com.franco.demo.services;

import com.franco.demo.domain.Note;
import com.franco.demo.dtos.NoteDto;

public interface NoteService extends BaseService<Note, NoteDto, Long> {

    public NoteDto changeStatus(Long id) throws Exception;
}
