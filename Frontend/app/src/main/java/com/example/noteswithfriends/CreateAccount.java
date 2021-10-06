package com.example.noteswithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;

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

        RequestQueue requestQueue = new RequestQueue();



        createNewUser();
        cancelCreation();

    }

    private void createNewUser() {
        create = findViewById(R.id.createAccount);
        addUser();
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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

    private void addUser(){
        EditText nameText = findViewById(R.id.editTextTextPersonName);
        EditText emailText = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordText = findViewById(R.id.editTextTextPassword);
        //TODO
        JSONObject newUser = new JSONObject();
        try {
            newUser.put("name", nameText.getText());
            newUser.put("email", nameText.getText());
            newUser.put("password", nameText.getText());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    };
}