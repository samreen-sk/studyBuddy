package com.example.studyBuddy.controller;


import com.example.studyBuddy.entity.Note;
import com.example.studyBuddy.service.NoteService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public Note create(
            @RequestBody Note note
    ) {
        return noteService.create(note);
    }

    @GetMapping
    public List<Note> getAll() {
        return noteService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        noteService.delete(id);
    }
}

