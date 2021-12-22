package com.example.noteswithfriends.Notes;

import com.example.noteswithfriends.Activities.LoginScreen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Note implements INote{

    /**
     * Current Note's id represented as an int
     */
    int noteID;
    /**
     * Current Note's name represented as a String
     */
    String noteName;
    /**
     * Current Note's contents represented as a String
     */
    TextItem noteContents;

    /**
     * Creates Note with default contents and name.
     */
    public Note(){

        noteName = "Default Note";
    }

    /**
     * Creates a Note with the given id, contents and name.
     * @param id
     * @param NoteName
     */
    public Note(int id, String NoteName) {
        noteName = NoteName;
        noteID = id;
    }

    /**
     * Creates a Note out of the given JSONObject.
     * @param noteObject
     */
    public Note(JSONObject noteObject){
        //TODO
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject noteJsonObject = new JSONObject();
        JSONObject content = noteContents.toJSONObject();
        JSONArray contents = new JSONArray();
        contents.put(content);


        try {
            noteJsonObject.put("noteType", "DEFAULT");
            noteJsonObject.put("contents", contents);
            noteJsonObject.put("name", noteName);
            //noteJsonObject.put("user", 1);
            noteJsonObject.put("id", noteID);
            noteJsonObject.put("xdim", 0);
            noteJsonObject.put("ydim", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return noteJsonObject;
    }

    @Override
    public JSONObject toJsonObjectNewNote() {
        JSONArray temp = new JSONArray();
        temp.put(noteContents.toJSONObject());
        JSONObject noteJsonObject = new JSONObject();
        try {
            noteJsonObject.put("noteType", "DEFAULT");
            noteJsonObject.put("contents", temp);
            noteJsonObject.put("name", noteName);
            //noteJsonObject.put("user", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return noteJsonObject;
    }

    public int getNoteID(){
        return noteID;
    }

    public TextItem getNoteContents(){
        return noteContents;
    }

    public void setNoteContents(TextItem contents){
        noteContents = contents;
    }

    public String getNoteName(){
        return noteName;
    }

    public void setNoteName(String name){
        noteName = name;
    }

    public void setID(int ID){
        noteID = ID;
    }

    public String getNoteType(){
        return "DEFAULT";
    }
}
