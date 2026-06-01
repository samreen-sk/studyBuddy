
package com.example.studyBuddy.repository;

import com.example.studyBuddy.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository
        extends JpaRepository<Note, Long> {
}

