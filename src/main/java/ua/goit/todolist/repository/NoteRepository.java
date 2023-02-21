package ua.goit.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.todolist.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}