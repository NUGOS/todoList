package ua.goit.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.todolist.model.Note;
import ua.goit.todolist.service.NoteService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/list")
    public String listNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "listNotes";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "editNote";
    }

    @PostMapping("/edit")
    public String saveNote(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }


    @PostMapping("/delete")
    public String deleteNote(@RequestParam long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/add")
    public String addNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "addNote";
    }

    @PostMapping("/add")
    public String addNoteSubmit(@ModelAttribute Note note) {
        noteService.save(note);
        return "redirect:/note/list";
    }
}
