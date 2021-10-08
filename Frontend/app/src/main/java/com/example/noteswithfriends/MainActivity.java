package com.example.noteswithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.*;

import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.*;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    String userUsername;
    String userPassword;
    String userName;
    int arrayNumber;
    boolean allowIn;
    public static String userNameMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayNumber = -1;
        allowIn = true;
        Button next = (Button) findViewById(R.id.CreateAccount);
        next.setOnClickListener(this::onClick);
        Button login = (Button) findViewById(R.id.Login);
        login.setOnClickListener(this::onClickLogin);
    }

    public void onClick(View view){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    public void onClickLogin(View view){
        EditText tempUsername = (EditText) findViewById(R.id.UsernameTextBox);
        userUsername = tempUsername.getText().toString();
        EditText enteredPassword = (EditText) findViewById(R.id.PasswordTextBox);
        GetName();
        getPassword();
        if(enteredPassword.getText().toString().equals(userPassword) && allowIn){
            Intent intent = new Intent(this, HomeScreen.class);
            intent.putExtra(userNameMessage, userName);
            startActivity(intent);
        }
    }


    private void getPassword(){
        TextView testVariable = findViewById(R.id.Postman);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://coms-309-064.cs.iastate.edu:8080/users";
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject userInfo = (JSONObject) response.get(arrayNumber);
                    userPassword = userInfo.get("password").toString();
                    System.out.println(userPassword);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }

    private void GetName(){
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://coms-309-064.cs.iastate.edu:8080/users";

        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for(int i = 0; i < response.length(); i++){
                        JSONObject userTest = (JSONObject) response.get(i);
                        if(userTest.get("email").toString().equals(userUsername)) {
                            System.out.println(userTest.get("email").toString());
                            System.out.println(userUsername.toString());
                            arrayNumber = i;
                        }
                    }
                    if(arrayNumber == -1){
                        arrayNumber = 0;
                        allowIn = false;
                    }
                    System.out.println(arrayNumber);
                    JSONObject userInfo = (JSONObject) response.get(arrayNumber);
                    userName = userInfo.get("name").toString();
                    System.out.println(userName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }

}