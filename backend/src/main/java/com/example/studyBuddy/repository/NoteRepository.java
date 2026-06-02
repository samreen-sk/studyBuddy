
package com.example.studyBuddy.repository;

import com.example.studyBuddy.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository
        extends JpaRepository<Note, Long> {

    List<Note> findByUserEmailOrderByIdDesc(String email);

    void deleteByIdAndUserEmail(Long id, String email);
}

