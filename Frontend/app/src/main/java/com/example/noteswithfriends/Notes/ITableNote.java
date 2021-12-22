package com.example.noteswithfriends.Notes;

public interface ITableNote extends INote{
    public TextItem getContents();
    public void setContents(TextItem newContents);
}
