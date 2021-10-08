package com.example.noteswithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateAccount extends AppCompatActivity {

    private Button create;
    private Button back;
    private EditText nameText;
    private EditText emailText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_account);

        //RequestQueue requestQueue = new RequestQueue();


        createNewUser();
        cancelCreation();
    }

    private void cancelCreation() {
        back = findViewById(R.id.cancelButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
                finish();
            }
        });
    }

    private void createNewUser() {
        create = findViewById(R.id.createAccount);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
    }

    private void addUser() {
        EditText nameText = findViewById(R.id.editTextTextPersonName);
        EditText emailText = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordText = findViewById(R.id.editTextTextPassword);
        //TODO
        String postUrl = "http://coms-309-064.cs.iastate.edu/users";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JSONObject postPassword = new JSONObject();
        JSONArray postDataArray = new JSONArray();
        JSONObject postName = new JSONObject();
        JSONObject postEmail = new JSONObject();
        JSONObject postData = new JSONObject();
        User user = new User("user", "email", "password");
        try {

            //postName.put("name", nameText.getText());
            //postPassword.put("password", passwordText.getText());
            //postDataArray.put(postPassword);
            //postDataArray.put(postName);
            //postEmail.put(emailText.getText(), postDataArray);
            //postData.put("name", nameText.getText());
            //postData.put("email", emailText.getText());
            //postData.put("password", passwordText.getText());
            postData.put("user", user);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("User added.");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Unsuccessful");
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);

    }

    ;


    private void addUser2(){
        nameText = findViewById(R.id.editTextTextPersonName);
        emailText = findViewById(R.id.editTextTextEmailAddress);
        passwordText = findViewById(R.id.editTextTextPassword);

        if (nameText.getText().toString().matches("") || emailText.getText().toString().matches("") || passwordText.getText().toString().matches(""))  {
            // TODO
            // HANDLES EMPTY PROMPTS
        } else {
            String postUrl = "http://coms-309-064.cs.iastate.edu/users";
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            JSONObject user = new JSONObject();
            try {
                user.put("name", nameText.getText().toString());
                user.put("email", emailText.getText().toString());
                user.put("password", passwordText.getText().toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, user, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    System.out.println(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            requestQueue.add(jsonObjectRequest);

            finish();
        }
    }
}

