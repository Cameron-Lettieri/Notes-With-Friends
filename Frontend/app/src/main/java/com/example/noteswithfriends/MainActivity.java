package com.example.noteswithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        CheckPasswords("hi");
        createNewAcount();

    }

    private void createNewAcount() {
        Button createAcc = findViewById(R.id.CreateAccount);
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateAccount.class));
            }
        });
    }


    private void sendGetRequest(){
        TextView testVariable = findViewById(R.id.Postman);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://fb3d6f71-3525-460a-824f-546264c15453.mock.pstmn.io/test/";
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                testVariable.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                testVariable.setText("Error");
            }
        });
        queue.add(stringRequest);
    }

    private void CheckPasswords(String username){
        TextView testVariable = findViewById(R.id.Postman);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://fb3d6f71-3525-460a-824f-546264c15453.mock.pstmn.io/test/";
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                    testVariable.setText(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                testVariable.setText("Error");
            }
        });
        queue.add(stringRequest);
    }


}