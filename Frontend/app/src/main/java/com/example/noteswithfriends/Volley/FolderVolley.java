package com.example.noteswithfriends.Volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.noteswithfriends.Notes.IFolder;
import com.example.noteswithfriends.Notes.INote;
import com.example.noteswithfriends.Notes.Note;
import com.example.noteswithfriends.Notes.NoteFolder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class FolderVolley {

    String url = "http://coms-309-064.cs.iastate.edu:8080/folders";

    public void putFolder(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject folder = new JSONObject();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, folder, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("Folder added.");
                //TODO Update screens
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);
    }

    public void putFolderContents(Context context){

    }

    public JSONArray getFolders(){
        return new JSONArray();
    }

    public INote getNotes(){
        return new Note();
    }
}
