package com.example.noteswithfriends.Notes;

import com.example.noteswithfriends.Volley.NoteVolley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NoteFolder implements IFolder{
    /**
     * Empty array representing the Notes current contents
     */
    int[] noteIds = new int[5];
    /**
     * Note representing the current Note
     */
    INote currentNote;

    /**
     * creates a NoteFolder with empty contents.
     */
    public NoteFolder(){

    }

    public INote getNote(int location){
        return currentNote;
    }

    public int[] getNoteIds(){
        return noteIds;
    }

    public void putNoteIntoFolder(){

    }

    public JSONArray toJSONArray(){
//     JSONArray folders = new JSONArray();
//        JSONObject folder = new JSONObject();
        JSONObject note = new JSONObject();
        try {
            note.put("name", "doc 1");
            note.put("contents", "test");
            note.put("noteType", "DEFAULT");
//            folder.put("name", "folder1");
//            folder.put("note", note);
//            folders.put(0, folder);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray folders = new JSONArray();
     return folders;
    }

//    public void removeNoteFromFolder(NoteVolley notevolley){
//        for(int i = 0; i < noteIds.length; i++){
//            if( noteIds[i] == notevolley.getNote().getNoteID()){
//                noteIds[i] = 0;
//            }
//        }
//    }

//    public void addNoteToFolder(NoteVolley notevolley){
//        JSONArray notes = notevolley.getNoteArray();
//        JSONObject note = new JSONObject();
//        boolean done = false;
//        for(int i = 0; i < noteIds.length; i++){
//            if(noteIds[i] == notevolley.getNote().getNoteID()){
//                done = true;
//            }
//            if( noteIds[i] == 0 && !done){
//                noteIds[i] = notevolley.getNote().getNoteID();
//                done = true;
//            }
//        }

//        for(int i = 0; i < notes.length(); i++){
//            System.out.println("started");
//            try {
//                System.out.println(notes.getJSONObject(i).get("id"));
//                if(notes.getJSONObject(i).get("id").equals(id)){
//                    System.out.println("note found");
//                    try {
//                        note = notes.getJSONObject(i);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            noteNames[1] = (String) note.get("name");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
}
