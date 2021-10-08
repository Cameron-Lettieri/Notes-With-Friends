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

        createNewUser();
        cancelCreation();
    }

    private void cancelCreation() {
        back = findViewById(R.id.cancelButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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


    private void addUser(){
        nameText = findViewById(R.id.editTextTextPersonName);
        emailText = findViewById(R.id.editTextTextEmailAddress);
        passwordText = findViewById(R.id.editTextTextPassword);

        if (nameText.getText().toString().matches("") || emailText.getText().toString().matches("") || passwordText.getText().toString().matches(""))  {
            // TODO
            // HANDLES EMPTY PROMPTS
        } else {
            String postUrl = "http://coms-309-064.cs.iastate.edu:8080/users";
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

