package com.example.structureTestV2.NoteTest;

public class DefaultNoteTestV2 
{
	private NoteInterfaceTestV2 note;
	
	public DefaultNoteTestV2(NoteInterfaceTestV2 note)
	{
		this.note=note;
		note.editContentSize(1, 1);
	}
	
	public void editContents(String edit)
	{
		note.editContents(edit, 0, 0);
	}
	
	public String getContents()
	{
		return note.getContentsInLocation(0, 0);
	}
	
	public int getID()
	{
		return note.getID();
	}
	public String getUser()
	{
		return note.getUser();
	}
	public String getType()
	{
		return note.getType();
	}
}
