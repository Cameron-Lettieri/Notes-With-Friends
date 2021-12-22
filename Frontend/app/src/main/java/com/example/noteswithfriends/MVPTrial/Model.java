package com.example.noteswithfriends.MVPTrial;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
Model generally does most of the work making the calls between front-end and back-end with the code to call volley requests for the create account activity.
 */
public class Model {

    /**
    A queue that is used to make volley requests.
     */
    private RequestQueue queue;

    private Context context;

    /**
    Constructor that creates a new model.
    @param context: used to create the request queue.
     */
    public Model(Context context) {
        queue = Volley.newRequestQueue(context);
        this.context = context;
    }

    /**
    JSON request for adding a new user in the database.
    @param url : Url that is used to send the volley request.
    @param user : User that is used to check for duplicates.
    @param volListener: Used to appropriately respond to successes and failures of the volley request.
     */
    public void addNewUser(String url, final JSONObject user, final IVolleyListener volListener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, user, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                volListener.onSuccessAdd("User added.");
                LoginScreen.userV.getUsers(context);
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volListener.onError(error);
            }
        });

        queue.add(jsonObjectRequest);
    }

    /**
    JSON request for finding a duplicate user in the database.
    @param url: Url that is used to send the volley request.
    @param user: User that is used to check for duplicates.
    @param volListener: Used to appropriately respond to successes and failures of the volley request.
     */
    public void findDuplicateUser(String url, final IUser user, final IVolleyListener volListener) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject duplicate = user.toJsonObject();

                try{
                    for(int i = 0; i < response.length(); i++) {
                        if (response.getJSONObject(i).getString("email").equals(user.getEmail())) {
                            duplicate = null;
                        }
                    }
                } catch(JSONException error) {
                    volListener.onError(error);
                }

                volListener.onSuccessCheckDuplicates(url, duplicate);
            } }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volListener.onError(error);
            }
        });

        queue.add(jsonArrayRequest);
    }
}
