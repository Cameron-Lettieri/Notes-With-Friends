package com.example.noteswithfriends.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.noteswithfriends.R;
import com.example.noteswithfriends.Users.IUser;
import com.example.noteswithfriends.Volley.UserVolley;

import org.json.*;

public class LoginScreen extends AppCompatActivity {

    String userUsername;
    String userPassword;
    /**
     * String representing the User's name
     */
    String userName;
    /**
     * UserVolley used to obtain current User
     */
    public static UserVolley userV;
    /**
     * String used to pass intent onto next screen
     */
    public static String userNameMessage;
    /**
     * String used to pass intent onto next screen
     */
    public static String userId;

    public static IUser user;

    /**
     *Controls what is shown on the classes creation.  Also controls what actions are taken when buttons are pressed.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        userV = new UserVolley();
        userV.getUsers(LoginScreen.this);
        super.onCreate(savedInstanceState);
        setContentView(com.example.noteswithfriends.R.layout.activity_main);
        Button next = (Button) findViewById(com.example.noteswithfriends.R.id.CreateAccount);
        next.setOnClickListener(this::onClick);
        Button login = (Button) findViewById(com.example.noteswithfriends.R.id.Login);
        login.setOnClickListener(this::onClickLogin);
        Button refresh = (Button) findViewById(R.id.refreshButton2);
        refresh.setOnClickListener(this::refresh);
    }

    /**
     * When create account button is pressed, advances to CreateAccount page.
     * @param view
     */
    public void onClick(View view){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    public void refresh(View view){
        userV.getUsers(LoginScreen.this);
    }

    /**
     * Checks username and password and if there is a matching account, advances to HomeScreen page.
     * @param view
     */
    public void onClickLogin(View view) {
        EditText tempUsername = (EditText) findViewById(com.example.noteswithfriends.R.id.UsernameTextBox);
        try {
            userV.getUserFromEmail(tempUsername.getText().toString(), LoginScreen.this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(userV.getUser() != null){
            user = userV.getUser();
            EditText enteredPassword = (EditText) findViewById(com.example.noteswithfriends.R.id.PasswordTextBox);
            //System.out.println(user.getPassword());
            userName = user.getName();
            if(enteredPassword.getText().toString().equals(user.getPassword())){
                Intent intent = new Intent(this, HomeScreen.class);
                intent.putExtra(userNameMessage, userName);
                //user = userTemp;
                userV.GetNotesFromUser(user.getID(), this);
                HomeScreen.user = userV.getUser();
                startActivity(intent);
            }
        }
    }


}
