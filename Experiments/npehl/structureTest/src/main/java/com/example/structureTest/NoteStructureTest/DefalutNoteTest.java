package com.example.structureTest.NoteStructureTest;

public class DefalutNoteTest 
{
	private NoteInterfaceTest note;
	private String contents;
	
	public DefalutNoteTest(NoteInterfaceTest note)
	{
		this.note = note;
	}
	//DON'T USE
	public DefalutNoteTest() {}
	
	public void setNote(NoteTest note)
	{
		this.note = note;
	}
	public String getUser()
	{
		return note.getUser();
	}
	public void setUser(String s)
	{
		note.setUser(s);
	}
	public int getID()
	{
		return note.getID();
	}
	public void editContents(String edit)
	{
		contents = edit;
	}
	public String getContents()
	{
		return contents;
	}
}
