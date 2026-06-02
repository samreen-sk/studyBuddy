package com.example.studyBuddy.controller;


import com.example.studyBuddy.entity.Note;
import com.example.studyBuddy.security.JwtService;
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

    private final JwtService jwtService;

    @PostMapping
    public Note create(
            @RequestBody Note note,
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        return noteService.create(note, getEmail(authorizationHeader));
    }

    @GetMapping
    public List<Note> getAll(
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        return noteService.getAll(getEmail(authorizationHeader));
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        noteService.delete(id, getEmail(authorizationHeader));
    }

    private String getEmail(String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        return jwtService.extractEmail(token);
    }
}

