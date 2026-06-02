package com.example.studyBuddy.service;

import com.example.studyBuddy.entity.Note;
import com.example.studyBuddy.entity.User;
import com.example.studyBuddy.repository.NoteRepository;
import com.example.studyBuddy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    private final UserRepository userRepository;

    public Note create(Note note, String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        note.setUser(user);

        return noteRepository.save(note);
    }

    public List<Note> getAll(String email) {
        return noteRepository.findByUserEmailOrderByIdDesc(email);
    }

    @Transactional
    public void delete(Long id, String email) {
        noteRepository.deleteByIdAndUserEmail(id, email);
    }
}

