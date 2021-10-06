package com.example.noteswithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        TextView userName = (TextView) findViewById(R.id.usersName);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.userNameMessage);
        userName.setText("Welcome " + message + "!");
    }
}