package com.example.structureTest.NoteStructureTest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NoteTest implements NoteInterfaceTest 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String user; // This is a place holder for the user class
	
	public NoteTest(String user)
	{
		this.user = user;
	}
	//DONT USE
	public NoteTest() {}
	public String getUser() 
	{
		return user;
	}

	public void setUser(String s) 
	{
		user = s;
	}

	public int getID() 
	{
		return id;
	}

}
