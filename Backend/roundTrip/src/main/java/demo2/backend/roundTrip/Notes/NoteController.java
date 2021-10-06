package demo2.backend.roundTrip.Notes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class NoteController 
{
	@Autowired
    NoteRepository noteRepository;
    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";

    @GetMapping(path = "/note")
    List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    @GetMapping(path = "/note/{id}")
    Note getNoteById( @PathVariable int id){
        return noteRepository.findById(id);
    }

    @PostMapping(path = "/note")
    String createNote(Note note){
        if (note == null)
            return failure;
        noteRepository.save(note);
        return success;
    }

    @PutMapping("/note/{id}")
    Note updateNote(@PathVariable int id, @RequestBody Note request){
        Note note = noteRepository.findById(id);
        if(note == null)
            return null;
        noteRepository.save(request);
        return noteRepository.findById(id);
    } 
 }

