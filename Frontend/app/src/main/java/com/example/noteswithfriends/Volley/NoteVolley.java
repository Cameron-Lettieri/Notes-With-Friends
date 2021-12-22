package com.example.noteswithfriends.Volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.noteswithfriends.Notes.INote;
import com.example.noteswithfriends.Notes.Note;
import com.example.noteswithfriends.Notes.TextItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Volley class used for volley requests related to notes/
 */
public class NoteVolley {

    String url = "http://coms-309-064.cs.iastate.edu:8080/notes";
    JSONArray noteArray;
    INote currentNote;
    JSONArray contents;

    /**
     * Method used for adding a new note to the database.
     * @param note: Note to be added.
     * @param context: Context used to create request queue.
     */
    public void putNote(INote note, Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        System.out.println(note.toJsonObject());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, note.toJsonObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("Note added.");
                //TODO Update screens
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);
    }

    public void putNoteNew(INote note, Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        System.out.println("watch: " + note.toJsonObjectNewNote());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, note.toJsonObjectNewNote(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("Note added.");
                //TODO Update screens
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);
    }

    public void putNoteById(int userId, INote note, Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        System.out.println(note.toJsonObject());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url + "/" + userId, note.toJsonObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("Note added to user.");
                //TODO Update screens
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);
    }

    /**
     * Method used to get all existing notes in the database.
     * @param context: Context to create request queue.
     */
    public void getNotes(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("Got notes.");
                noteArray = response;
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonArrayRequest);
    }

    /**
     * Returns a single note that was received from a volley request.
     * @return Note received from volley request.
     */
    public INote getNote(){

        return currentNote;
    }

    /**
     * Method used to update a note
     * @param note: Note to update
     * @param context: Context to create request queue.
     */
    public void updateNote(INote note, Context context){
        int noteId = note.getNoteID();
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url + "/" + noteId, note.toJsonObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("Note contents updated.");
                //TODO Update screens
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);
        System.out.println("Note Contents Updated");
    }

    /**
     * Returns a JSONArray of note objects recieved from a volley request
     * @return JSONArray received through request
     */
    public JSONArray getNoteArray(){
        return noteArray;
    }

    public void updateContents(TextItem textItem, Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject content = textItem.toJSONObject();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://coms-309-064.cs.iastate.edu:8080/item", content, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("TextItem updated.");
                //TODO Update screens
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);
    }

    public void getContents(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://coms-309-064.cs.iastate.edu:8080/items", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("Got contents.");
                contents = response;
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonArrayRequest);
    }

    public JSONArray getContentsArray(){
        return contents;
    }
}
