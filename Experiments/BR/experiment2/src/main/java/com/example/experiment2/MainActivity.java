package com.example.experiment2;

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

    public void onPress(View view){
        Intent intent = new Intent(this, ImageScreen.class);
        startActivity(intent);
    }

    public void onPress2(View view){
        Intent intent = new Intent(this, ImageScreen2.class);
        startActivity(intent);
    }
}