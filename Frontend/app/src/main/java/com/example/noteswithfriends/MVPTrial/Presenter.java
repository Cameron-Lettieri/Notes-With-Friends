package com.example.noteswithfriends.MVPTrial;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;
import com.example.noteswithfriends.Users.IUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
    Presenter is the main GUI that the user will interact with, updating and sending request to retrieve info for the user.
 */
public class Presenter implements IPresenter, IVolleyListener {

    /**
     * Interface that is used to update the GUI.
     */
    private IView view;

    /**
     * Model that is used to access and use volley calls.
     */
    private Model model;

    /**
    Constructor for creating a new presenter.
    @param view: Used for being able to update the view of what is being presented.
    @param context: Context used for creating the Request Queue for volley requests.
     */
    public Presenter(IView view, Context context) {
        this.view = view;
        this.model = new Model(context);
    }

    /**
    CONSTRUCTOR ONLY FOR TESTING
     */
    public Presenter(IView view) {
        this.view = view;
    }

    /**
    METHOD ONLY FOR TESTING
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
    Calls the model to undergo the adding new user process.
    @param url: Url that is sent for the volley request.
    @param user: User that is added into the database.
     */
    @Override
    public void addUser(String url, JSONObject user) {
        model.addNewUser(url, user, this);
    }

    /**
    Calls the model to undergo the check duplicates process.
    @param url: Url that is sent for the volley request.
    @param user: user that is sent to the request that is used for duplication checking.
     */
    @Override
    public void checkDuplicate(String url, IUser user) {
        model.findDuplicateUser(url, user, this);
    }

    /**
    Used to log a success message in the form of a string.
     @param s: String that is the success message.
     */
    @Override
    public void onSuccessAdd(String s) {
        Log.d("TAG", "SERVER RESPONSE: " + s);
        System.out.println(s);
    }

    /**
    *WIP*
    This is a method that is used to check the validity of a user creating a new account without having that account be a duplicate.
    * @param url: Url used for adding the user to the database if check passed.
    * @param object: the object in the form of a user passed from check duplicates. If null, means there is a duplicate, if not means able to be added to database.
     */
    @Override
    public void onSuccessCheckDuplicates(String url, JSONObject object) {
        if(object == null) {
            //THERE WAS A DUPE FOUND
        } else {
            addUser(url, object);
        }
    }

    /**
    Method used to log the error that occurred.
    @param error: Error that occurred during the Volley request.
     */
    @Override
    public void onError(VolleyError error) {
        try {
            String responseBody = new String(error.networkResponse.data, "utf-8");
            Log.d("TAG", responseBody);
        } catch (UnsupportedEncodingException e){
            Log.d("TAG",e.toString());
        }
    }

    /**
    Method used to log the error that occurred.
    @param error: Error that occurred during the use of JSON objects/arrays.
     */
    @Override
    public void onError(JSONException error) {
        String responseBody = error.getMessage();
        Log.d("TAG", responseBody);
    }
}
