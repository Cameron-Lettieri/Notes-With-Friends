package com.example.noteswithfriends.Notes;

import com.example.noteswithfriends.Volley.NoteVolley;

import org.json.JSONArray;

/**
 * Interface for modeling a folder
 */
public interface IFolder {
    /**
     * Gets the list of notes that is within the folder
     * @return All notes located within a folder.
     */
    public int[] getNoteIds();

    /**
     * Method used to get a note from a location in folder
     * @param location: Index of the note within the folder
     * @return Note that is ate the index of location.
     */
    public INote getNote(int location);

    /**
     * Method used to add a note to a user's folder.
     * @param notevolley: The volley that is used to create the add calls.
     */
//    public void addNoteToFolder(NoteVolley notevolley);

    /**
     * Method used to remove a note from a user's folder
     * @param notevolley: The volley that is used to create the deletion calls.
     */
//    public void removeNoteFromFolder(NoteVolley notevolley);
}
