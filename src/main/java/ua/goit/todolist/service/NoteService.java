package ua.goit.todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.todolist.model.Note;
import ua.goit.todolist.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public void save(Note note) {
        noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        Note existingNote = getById(note.getId());
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        noteRepository.save(existingNote);

    }

    public Note getById(long id) {
        return noteRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with given ID not found"));
    }
}
