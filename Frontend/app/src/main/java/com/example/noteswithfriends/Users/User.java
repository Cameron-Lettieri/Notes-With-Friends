package com.example.noteswithfriends.Users;

import com.example.noteswithfriends.Notes.IFolder;
import com.example.noteswithfriends.Notes.INote;
import com.example.noteswithfriends.Notes.Note;
import com.example.noteswithfriends.Notes.NoteFolder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class User implements IUser{
    /**
     * String representing name of current User
     */
    String name;
    /**
     * String representing the email of the current User
     */
    String email;
    /**
     * String representing the password of the current User
     */
    String password;
    /**
     * id of current User represented as an int
     */
    int id;
    /**
     * All notes associated with a current User represented as an ArrayList
     */
    ArrayList<INote> notes;

    JSONArray notesJ;

    ArrayList<IFolder> folders;

    /**
     * Creates new User with given name, email and password.
     * @param name
     * @param email
     * @param password
     */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.notes = null;
    }

    /**
     * Creates new user out of given JSONObject.
     * @param object
     */
    public User(JSONObject object){
        try {
            id = object.getInt("id");
            name = object.getString("name");
            email = object.getString("email");
            password = object.getString("password");
            notes = new ArrayList<>();
            for (int i = 0; i < object.getJSONArray("notes").length(); i++) {
                notes.add(new Note(object.getJSONArray("notes").getJSONObject(i)));
            }
            folders = new ArrayList<>();

            //TODO
//            for (int i = 0; i < object.getJSONArray("folders").length(); i++) {
//                folders.add(new NoteFolder(object.getJSONArray("folders").getJSONObject(i)));
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject user = new JSONObject();
        try {
            user.put("name", name);
            user.put("email", email);
            user.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public int getID(){
        return id;
    }

    public ArrayList<INote> getNotes2(){
        return notes;
    }

    public JSONArray getNotes() { return notesJ; }

    public void setNotes(JSONArray notesArray){
        notesJ = notesArray;
    }

    public void createNote(INote note) {
        notes.add(note);
    }


}
