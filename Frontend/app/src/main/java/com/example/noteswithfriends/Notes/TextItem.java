package com.example.noteswithfriends.Notes;

import org.json.JSONException;
import org.json.JSONObject;

public class TextItem {

    int id;

    boolean checked;

    String contentString;

    public TextItem(){

    }

    public JSONObject toJSONObject(){
        JSONObject textItem = new JSONObject();
        try {
            textItem.put("id", id);
            textItem.put("checked", checked);
            textItem.put("contentString", contentString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return textItem;
    }

    public void setId(int ID){
        id = ID;
    }

    public void setChecked(boolean check){
        checked = check;
    }

    public void setContentString(String content){
        contentString = content;
    }

    public int getId(){
        return id;
    }

    public boolean getChecked(){
        return checked;
    }

    public String getContentString(){
        return contentString;
    }
}
