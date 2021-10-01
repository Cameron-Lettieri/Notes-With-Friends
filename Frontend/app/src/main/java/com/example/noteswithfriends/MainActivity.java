package com.example.noteswithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckPasswords("hi");
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