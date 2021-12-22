package com.example.noteswithfriends.Users;

import com.example.noteswithfriends.Notes.INote;
import com.example.noteswithfriends.Notes.Note;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public interface IUser {
    /**
     * Returns current User object as a JSONObject.
     * @return User as JSONObject
     */
    JSONObject toJsonObject();

    /**
     * Returns password of current User as a String.
     * @return Password as a String
     */
    String getPassword();

    /**
     * Returns email of current User as a String.
     * @return Email as a String
     */
    String getEmail();

    /**
     * Returns name of current User as a String.
     * @return Name as a String
     */
    String getName();

    /**
     * Returns id of current user.
     * @return Id as an int
     */
    int getID();

    /**
     * Returns all Notes contained in a User as an ArrayList.
     * @return Notes associated with User as an ArrayList
     */
    JSONArray getNotes();

    void setNotes(JSONArray notesArray);

    ArrayList<INote> getNotes2();

    void createNote(INote note);
}
