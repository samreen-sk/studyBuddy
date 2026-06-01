package com.example.studyBuddy.service;

import com.example.studyBuddy.entity.Note;
import com.example.studyBuddy.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note create(Note note) {
        return (Note) noteRepository.save(note);
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}

