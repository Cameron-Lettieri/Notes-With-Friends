package com.example.noteswithfriends.MVPTrial;

import com.example.noteswithfriends.Users.IUser;

import org.json.JSONObject;

/**
   This is an interface for the presenter of the activity, which generally calls the model.
 */
public interface IPresenter {
    /**
    Method for adding user.
    @param url: url for sending the JSON request.
    @param user: A user in the form of an JSON Object to be added to the database.
     */
    public void addUser(String url, JSONObject user);
    /**
    Method for going through all existing users and checkibng if the new user would create a duplicate.
    @param url: url for sending the JSON request.
    @param user: User with the given parameters that is used to check for duplicates.
     */
    public void checkDuplicate(String url, IUser user);
}
