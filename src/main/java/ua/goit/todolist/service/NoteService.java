package ua.goit.todolist.service;

import org.springframework.stereotype.Service;
import ua.goit.todolist.model.Note;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private List<Note> notes = new ArrayList<>();

    public List<Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
        note.setId(Math.round(Math.random() * 1000));
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        boolean removed = notes.removeIf(note -> note.getId() == id);
        if (!removed) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist");
        }
    }

    public void update(Note note) {
        Note existingNote = getById(note.getId());
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
    }

    public Note getById(long id) {
        return notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " does not exist"));
    }
}
