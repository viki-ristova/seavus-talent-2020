package com.seavus.talent.NotesWithoutDatabase.api;

import com.seavus.talent.NotesWithoutDatabase.model.Note;
import com.seavus.talent.NotesWithoutDatabase.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {
    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    public static class CreateNoteRequest{
        public String title;
        public String content;
    }

    @PostMapping("/api/notes")
    public Note createNote(@RequestBody CreateNoteRequest request){
        return noteService.createNote(request.title,request.content);
    }

    @GetMapping("/api/notes/{id}")
    public Note findNote(@PathVariable Long id){
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    @GetMapping("/api/notes")
    public List<Note> findNotes(){
        return noteService.findNotes();
    }

    @DeleteMapping("/api/notes/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }

    @PutMapping("/api/notes/{id}")
    public Optional<Note> updateNote(@RequestBody Note note, @PathVariable Long id){
        return noteService.updateNote(id, note);

    }
}
