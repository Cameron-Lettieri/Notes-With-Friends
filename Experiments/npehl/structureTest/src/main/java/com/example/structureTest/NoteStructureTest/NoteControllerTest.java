package com.example.structureTest.NoteStructureTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NoteControllerTest 
{
	@Autowired
    NoteRepositoryTest noteRepository;
    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";

    @GetMapping(path = "/note")
    List<NoteTest> getAllNotes(){
        return noteRepository.findAll();
    }

    @GetMapping(path = "/note/{id}")
    NoteTest getNoteById( @PathVariable int id){
        return noteRepository.findById(id);
    }

    @PostMapping(path = "/note")
    String createNote(NoteTest note){
        if (note == null)
            return failure;
        noteRepository.save(note);
        return success;
    }

    @PutMapping("/note/{id}")
    NoteTest updateNote(@PathVariable int id, @RequestBody NoteTest request){
        NoteTest note = noteRepository.findById(id);
        if(note == null)
            return null;
        noteRepository.save(request);
        return noteRepository.findById(id);
    } 
}
