package com.example.noteswithfriends.Notes;

import org.json.JSONObject;

public interface IChecklistNote extends INote {
    public TextItem getContents();
    public void setContents(TextItem newContents);
}
