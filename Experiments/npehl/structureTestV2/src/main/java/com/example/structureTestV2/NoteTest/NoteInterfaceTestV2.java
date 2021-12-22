package com.example.structureTestV2.NoteTest;

public interface NoteInterfaceTestV2
{
	public String getUser();
	
	public void setUser(String s);
	
	public int getID();
	
	public void editContents(String newEdit, int col, int row);
	
	public String[][] getFullContents();
	
	public String getContentsInLocation(int col, int row);
	
	public void editContentSize(int col, int rows);
	
	public String getType();

}
