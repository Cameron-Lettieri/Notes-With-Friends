package com.example.noteswithfriends.Notes;

import com.example.noteswithfriends.Activities.LoginScreen;
import com.example.noteswithfriends.Volley.NoteVolley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ChecklistNote implements IChecklistNote{

    /**
     * String array representing the contents of the table note
     */
    TextItem contents;

    /**
     * String representing the name of the note
     */
    String noteName;

    /**
     * Int representing the id of the note
     */
    int noteId;

    public void ChecklistNote(){
        ;
    }


    @Override
    public TextItem getContents() {
        return contents;
    }

    @Override
    public void setContents(TextItem newContents) {
        contents = newContents;
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject noteJsonObject = new JSONObject();
        try {
            noteJsonObject.put("noteType", "CHECK");
            noteJsonObject.put("contents", contents);
            noteJsonObject.put("name", noteName);
            //noteJsonObject.put("user", LoginScreen.user.getID());
            noteJsonObject.put("id", noteId);
            //noteJsonObject.put("user", 1);
            noteJsonObject.put("xdim", 0);
            noteJsonObject.put("ydim", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return noteJsonObject;
    }

    @Override
    public JSONObject toJsonObjectNewNote() {
        //List<TextItem> contents = new List<TextItem>();
        JSONArray temp = new JSONArray();
        JSONObject noteJsonObject = new JSONObject();
        temp.put(contents.toJSONObject());
        try {
            noteJsonObject.put("noteType", "CHECK");
            noteJsonObject.put("contents", temp);
            noteJsonObject.put("name", noteName);
            //noteJsonObject.put("user", 1);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return noteJsonObject;
    }

    public void checkFromVolley(NoteVolley nVolley){
        INote note = nVolley.getNote();
        if(note.getNoteType() == "CHECK"){
            contents = note.getNoteContents();
            noteName = note.getNoteName();
            noteId = note.getNoteID();
        }
    }

    @Override
    public int getNoteID() {
        return noteId;
    }

    @Override
    public TextItem getNoteContents() {
        return contents;
    }

    @Override
    public void setNoteContents(TextItem contents) {
        this.contents = contents;
    }

    @Override
    public void setNoteName(String name) {
        noteName = name;
    }

    @Override
    public String getNoteName() {
        return noteName;
    }

    public void setID(int ID){
        noteId = ID;
    }

    public String getNoteType(){
        return "CHECK";
    }
}
