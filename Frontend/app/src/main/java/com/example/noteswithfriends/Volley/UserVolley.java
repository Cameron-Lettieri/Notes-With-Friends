package com.example.noteswithfriends.Volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.noteswithfriends.Activities.LoginScreen;
import com.example.noteswithfriends.Users.IUser;
import com.example.noteswithfriends.Users.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class used for making volley calls related to users.
 */
public class UserVolley {

    /**
     *
     */
    String url = "http://coms-309-064.cs.iastate.edu:8080/users";

    /**
     *
     */
    JSONObject userObject = null;

    /**
     *
     */
    JSONArray userArray = null;

    /**
     *
     */
    int arrayNumber;

    /**
     *
     */
    IUser user;

    JSONArray noteArray = null;

    int[] noteIds;

    /**
     * Basic constructor
     */
    public UserVolley(){

    }

    /**
     * Method used for adding a new user to the database
     * @param user: user to be added.
     * @param context Context used for creating the request queue.
     */
    public void putUser(IUser user, Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, user.toJsonObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("User added.");
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);
    }

    /**
     * Method used to request all users in the database.
     * @param context Context used for creating the request queue.
     */
    public void getUsers(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("Got users.");
                userArray = response;
                System.out.println(userArray);
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonArrayRequest);
    }

    /**
     * Gets user from database by email.
     * @param email Email to search for in users.
     * @param context Context used for creating the request queue.
     * @throws JSONException JSONException occurs.
     */
    public void getUserFromEmail(String email, Context context) throws JSONException {
        for(int i = 0; i < userArray.length(); i++){
            JSONObject userTest = userArray.getJSONObject(i);
            if(userTest.get("email").toString().equals(email)) {
                arrayNumber = i;
                userObject = userTest;
                user = new User(userObject);
                System.out.println("Search Worked");
                System.out.println(userObject.toString());
            }
        }
        if(arrayNumber == -1){
            arrayNumber = 0;
        }
    }

    /**
     *  Gets a user by name form the database.
     * @param name Email to search for in users.
     * @param context Context used for creating the request queue.
     * @throws JSONException JSONException occurs.
     */
    public void getUserFromName(String name, Context context) throws JSONException {
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("Got users.");
                userArray = response;
                for(int i = 0; i < userArray.length(); i++){
                    JSONObject userTest = null;
                    try {
                        userTest = userArray.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        if(userTest.get("name").toString().equals(name)) {
                            arrayNumber = i;
                            userObject = userTest;
                            user = new User(userObject);
                            System.out.println("Search Worked");
                            System.out.println(userObject.toString());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if(arrayNumber == -1){
                    arrayNumber = 0;
                }
                System.out.println(userArray);
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonArrayRequest);

    }

    /**
     *  Used to find a user by ID value.
     * @param id Id used to search for in users.
     * @param context Context used for creating the request queue.
     * @throws JSONException JSONException occurs.
     */
    public void getUserFromID(int id, Context context) throws JSONException {
        String idS = "" + id;
        for(int i = 0; i < userArray.length(); i++){
            JSONObject userTest = userArray.getJSONObject(i);
            if(userTest.get("id").toString().equals(idS)) {
                arrayNumber = i;
                userObject = userTest;
                user = new User(userObject);
                System.out.println("Search Worked");
                System.out.println(userObject.toString());
            }
        }
        if(arrayNumber == -1){
            arrayNumber = 0;
        }
    }

    /**
     * Return a received JSON Object
     * @return json object from a volley request
     */
    public JSONObject getObject(){
        return userObject;
    }

    /**
     * return user that was received from a volley request
     * @return user received from request.
     */
    public IUser getUser(){
        return user;
    }

    /**
     * Method used to add a new note to a user.
     * @param noteID Note to be added to a users.
     * @param userID User to have the note added to.
     * @param context Context used for creating the request volley.
     */
    public void AssignNote(int noteID, int userID, Context context){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url2 = "http://coms-309-064.cs.iastate.edu:8080/users/" + userID + "/notes/" + noteID;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url2, LoginScreen.user.toJsonObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("Note added to user.");
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);
    }

    public void GetNotesFromUser(int userId, Context context){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url2 = "http://coms-309-064.cs.iastate.edu:8080/notes/user/" + userId;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("Got Notes from User.");
                noteArray = response;
                System.out.println("notes: " + noteArray);
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonArrayRequest);
    }

    public JSONArray getNotes(){
        System.out.println("test 2:" + noteArray);
        return noteArray;
    }

    public JSONArray getUserArray(){
        return userArray;
    }
}
