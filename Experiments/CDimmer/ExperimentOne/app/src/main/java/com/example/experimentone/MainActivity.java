package com.example.experimentone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView example = findViewById(R.id.textView);
        Button twelve = findViewById(R.id.button2);
        Button sixteen = findViewById(R.id.button);
        Button twenty = findViewById(R.id.button3);

        twelve.setOnClickListener(v -> example.setTextSize(12));

        sixteen.setOnClickListener(v -> example.setTextSize(16));

        twenty.setOnClickListener(v -> example.setTextSize(20));
    }


}