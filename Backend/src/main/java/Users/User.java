package Users;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;


import Notes.Note.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    
    @Column(nullable = false, length = 60)
    private String password;
    
    @OneToMany
    private List<Note> noteList;


    public User(String name, String email, String password) 
    {
        this.name = name;
        this.email = email;
        this.password = password;
        noteList = new ArrayList<Note>();
    }

    public User() 
    {
    	noteList = new ArrayList<Note>();
    }

    //  Getters and Setters for each field

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword()
    {
    	return this.password;
    }
    public void changePassword(String password)
    {
    	this.password= password;
    }
    public List<Note> getNotes()
    {
    	return this.noteList;
    }
    public void setNotes(List<Note> noteList) {
        this.noteList = noteList;
    }

    public void addNote(Note note){
        this.noteList.add(note);
    }

}
