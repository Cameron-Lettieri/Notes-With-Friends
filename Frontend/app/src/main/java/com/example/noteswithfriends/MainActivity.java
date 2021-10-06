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

public class MainActivity extends AppCompatActivity {

    String userUsername;
    String userPassword;
    String userName;
    public static String userNameMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = (Button) findViewById(R.id.CreateAccount);
        next.setOnClickListener(this::onClick);
        Button login = (Button) findViewById(R.id.Login);
        login.setOnClickListener(this::onClickLogin);
        //TextView testVariable = findViewById(R.id.Postman);
        //testVariable.setText(userPassword);
    }

    public void onClick(View view){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    public void onClickLogin(View view){
        EditText tempUsername = (EditText) findViewById(R.id.UsernameTextBox);
        userUsername = tempUsername.getText().toString();
        CheckPasswords(userUsername);
        EditText enteredPassword = (EditText) findViewById(R.id.PasswordTextBox);
        GetName(userUsername);
        sendGetRequest();
        if(enteredPassword.getText().toString().equals(userPassword)){
            Intent intent = new Intent(this, HomeScreen.class);
            intent.putExtra(userNameMessage, userName);
            startActivity(intent);
        }
    }

    private void CheckPasswords(String username){

//        CheckPasswords("hi");
        createNewAcount();

    }

    private void createNewAcount() {
        Button createAcc = findViewById(R.id.CreateAccount);
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateAccount.class));
            }
        });
    }


    private void sendGetRequest(){
        TextView testVariable = findViewById(R.id.Postman);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://fb3d6f71-3525-460a-824f-546264c15453.mock.pstmn.io/test/";
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray stats = response.getJSONArray(userUsername);
                    JSONObject userInfo = stats.getJSONObject(0);
                    userPassword = userInfo.getString("password");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                testVariable.setText("Error");
            }
        });
        queue.add(stringRequest);
    }

    private void GetName(String username){
        TextView testVariable = findViewById(R.id.Postman);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        //String url = "coms-309-064.cs.iastate.edu/users";
        String url = "https://fb3d6f71-3525-460a-824f-546264c15453.mock.pstmn.io/test/";

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray stats = response.getJSONArray(username);
                    JSONObject userInfo = stats.getJSONObject(0);
                    userName = userInfo.getString("name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                testVariable.setText("Error");
            }
        });
        queue.add(stringRequest);
    }


}