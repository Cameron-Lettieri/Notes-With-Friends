package com.example.experiments309;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.messageName);

        TextView text = findViewById(R.id.textView2);
        text.setText(message);
    }
}