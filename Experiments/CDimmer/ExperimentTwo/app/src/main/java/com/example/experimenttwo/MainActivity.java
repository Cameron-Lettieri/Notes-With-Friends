package com.example.experimenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.textView);
        Button left = findViewById(R.id.button2);
        Button right = findViewById(R.id.button);
        Button center = findViewById(R.id.button3);

        left.setOnClickListener(v -> txt.setGravity(Gravity.LEFT));

        right.setOnClickListener(v -> txt.setGravity(Gravity.RIGHT));

        center.setOnClickListener(v -> txt.setGravity(Gravity.CENTER));
    }

}