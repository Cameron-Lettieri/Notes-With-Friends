package com.example.noteswithfriends.Notes;

import com.example.noteswithfriends.Activities.LoginScreen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TableNote implements ITableNote{

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

    public void TableNote(){

    }

    public void TableNote(String[] startingContents){

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
            noteJsonObject.put("noteType", "TABLE");
            noteJsonObject.put("contents", contents);
            noteJsonObject.put("user", LoginScreen.user.getID());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return noteJsonObject;
    }

    @Override
    public JSONObject toJsonObjectNewNote() {
        JSONArray temp = new JSONArray();
        JSONObject noteJsonObject = new JSONObject();
        temp.put(contents.toJSONObject());
        try {
            noteJsonObject.put("noteType", "TABLE");
            noteJsonObject.put("contents", temp);
            noteJsonObject.put("name", noteName);
            //noteJsonObject.put("user", 1);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return noteJsonObject;
    }

    @Override
    public int getNoteID() {
        return noteId;
    }

    @Override
    public TextItem getNoteContents() {
        return null;
    }

    @Override
    public void setNoteContents(TextItem contents) {

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

    @Override
    public String getNoteType() {
        return "TABLE";
    }

}
