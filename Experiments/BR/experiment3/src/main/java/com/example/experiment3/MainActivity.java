package com.example.experiment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void whenPressed(View view){
        Intent pressed = new Intent(this, checkInfo.class);
        EditText editTextUsername = (EditText) findViewById(R.id.Username);
        String username = editTextUsername.getText().toString();
        EditText editTextPassword = (EditText) findViewById(R.id.Password);
        String password = editTextPassword.getText().toString();
        if(username.equals("123") && password.equals("123")){
            startActivity(pressed);
        }

    }

}