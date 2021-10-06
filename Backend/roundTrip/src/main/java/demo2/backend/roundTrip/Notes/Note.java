package demo2.backend.roundTrip.Notes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import demo2.backend.roundTrip.Users.*;


@Entity
public class Note 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private final NoteType noteType;
	
	 @ManyToOne
	 @JoinColumn(name = "user_id")
	 @JsonIgnore
	   private User user;

	 public Note(NoteType noteType)
	 {
		 this.noteType = noteType;
	 }
	 public Note()
	 {
		 noteType = NoteType.DEFALUT;
	 }
	 public NoteType getNoteType()
	 {
		 return this.noteType;
	 }
	 public int getID()
	 {
		 return this.id;
	 }
	 public void setID(int id)
	 {
		 this.id = id;
	 }
	 public User getUser()
	 {
	     return user;
	 }

	 public void setUser(User user)
	 {
	    this.user = user;
	 }		
}

