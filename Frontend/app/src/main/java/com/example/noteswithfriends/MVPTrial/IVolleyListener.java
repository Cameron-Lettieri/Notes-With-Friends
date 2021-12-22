package com.example.noteswithfriends.MVPTrial;

import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

/**
Interface that will be used to listen to Volley request, responds to both fails and successes.
 */
public interface IVolleyListener {
    /**
    Replies with a string conforming the success of the add task.
     */
    void onSuccessAdd(String result);
    /**
    Replies that the check for duplicates was good, meaning no duplicates, and will give the OK to start adding the user.
     @param url: url that is used to preform volley request.
     @param object: object that is used for adding a new user, assuming the check passed. If not, will handle actions for duplication of data.
     */
    void onSuccessCheckDuplicates(String url, JSONObject object);
    /**
    Contains errors that are given back in the form of VolleyErrors and will explain them (generally though stack printing).
     @param error: Error that is received.
     */
    void onError(VolleyError error);
    /**
    Contains errors that are given back in the form of JSONExceptions and will explain them (generally though stack printing).
     @param error: Error that is received.
     */
    void onError(JSONException error);
}
