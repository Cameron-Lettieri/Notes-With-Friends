package com.example.structureTestV2.NoteTest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class NoteTestV2 implements NoteInterfaceTestV2
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String user; // This is a place holder for the user class
	private String[][] contents;
	private String type;
	
	
	public NoteTestV2(String type, String user, int cols, int rows)//user and type will be a class and a enum respctivly.
	{
		this.type = type;
		this.user=user;
		contents = new String[cols][rows];
	}
	public String getUser() {
		
		return user;
	}


	public void setUser(String s) 
	{
		user =s;
	}


	public int getID()
	{
		return id;
	}
	
	public String getType()
	{
		return type;
	}


	public void editContents(String newEdit, int col, int row)
	{
		contents[col][row] = newEdit;
	}

	public String[][] getFullContents()
	{
	
		return contents;
	}
	
	public String getContentsInLocation(int col, int row)
	{
		return contents[col][row];
	}
	@Override
	public void editContentSize(int col, int rows) 
	{
		String[][] temp = new String[col][rows];
		for(int i=0; i<contents.length;i++)
		{
			for(int j=0; j<contents[0].length;j++)
			{
				temp[i][j]=contents[i][j];
			}
		}
		contents = temp;
	}

}
