package com.oaapps.easy_notes_crud.repository;

import com.oaapps.easy_notes_crud.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
