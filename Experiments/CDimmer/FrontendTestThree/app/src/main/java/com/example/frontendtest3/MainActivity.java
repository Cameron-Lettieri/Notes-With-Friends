package com.example.frontendtest3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.maintext);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://reqres.in/api/users?page=2";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println("OnResponse method activated.");
                        try {
                            System.out.println("What I want: " + response.getString("total"));
                            textView.setText(response.getString("total"));
                        } catch (JSONException e) {
                            System.out.println("Error occured.");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Error occured.");

                    }
                });

        requestQueue.add(jsonObjectRequest);

    }

}