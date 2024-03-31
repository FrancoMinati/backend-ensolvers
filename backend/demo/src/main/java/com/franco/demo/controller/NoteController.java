package com.franco.demo.controller;


import com.franco.demo.domain.Note;
import com.franco.demo.dtos.NoteDto;
import com.franco.demo.services.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(path = "api/v1/notas")
public class NoteController extends BaseControllerImpl<Note, NoteDto, NoteServiceImpl>{

    @Autowired
    public NoteController(NoteServiceImpl noteServiceImpl){
        super(noteServiceImpl);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<?> changeStatus(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.changeStatus(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<?> changeStatus(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.obtenerNotasPorCategoria(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }

}
