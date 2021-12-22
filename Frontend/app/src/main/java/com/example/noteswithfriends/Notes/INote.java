package com.example.noteswithfriends.Notes;

import org.json.JSONObject;

public interface INote {
    /**
     * Returns the given Note as a JSONObject.
     * @return Note as a JSONObject
     */
    JSONObject toJsonObject();

    /**
     * Returns an int representing the current Note's Id.
     * @return Note id as an int
     */
    int getNoteID();

    /**
     * Returns the current Notes contents in the form of a String.
     * @return Note contents as a String
     */
    TextItem getNoteContents();

    /**
     * Sets the contents of the current Note to the String given.
     * @param contents
     */
    void setNoteContents(TextItem contents);

    /**
     * Sets the name of the current Note to the String given.
     * @param name
     */
    void setNoteName(String name);

    /**
     * Returns the name of the current Note as a String.
     * @return Note name as a String
     */
    String getNoteName();

    void setID(int ID);

    String getNoteType();

    public JSONObject toJsonObjectNewNote();
}
