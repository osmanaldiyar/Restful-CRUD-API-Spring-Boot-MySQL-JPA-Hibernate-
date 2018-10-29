package com.oaapps.easy_notes_crud.controller;

import com.oaapps.easy_notes_crud.exception.ResourceNotFoundException;
import com.oaapps.easy_notes_crud.model.Note;
import com.oaapps.easy_notes_crud.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note){
        return noteRepository.save(note);
    }

    @GetMapping("notes/{id}")
    public Note getNote(@PathVariable(value = "id") Long noteId){
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note","id",noteId));
    }

    @PutMapping("notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails){

        Note note = noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note","id",noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);

        return updatedNote;
    }

    @DeleteMapping("notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId){

        Note note  = noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note","id",noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();

    }
}
