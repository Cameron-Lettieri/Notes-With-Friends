package com.example.noteswithfriends.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

import com.example.noteswithfriends.MVPTrial.IPresenter;
import com.example.noteswithfriends.MVPTrial.IView;
import com.example.noteswithfriends.MVPTrial.Presenter;
import com.example.noteswithfriends.R;
import com.example.noteswithfriends.Users.User;

/**
 *
 */
public class CreateAccount extends AppCompatActivity implements IView {

    /**
     * Button that is used to start create account process
     */
    private Button create;

    /**
     * button that is used to cancel create account and go back tom log-in screen.
     */
    private ImageButton back;

    /**
     * used for a new user to enter their name.
     */
    private EditText nameText;

    /**
     * Used for a new user to enter an email.
     */
    private EditText emailText;

    /**
     * Used py a new user to enter the password they want.
     */
    private EditText passwordText;


    /**
     * Present that is used to update GUI and make calls to tell other objects to create volley requests.
     */
    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_account);

        create  = (Button) findViewById(R.id.createAccount);
        back = (ImageButton) findViewById(R.id.cancelButton);
        nameText= (EditText) findViewById(R.id.editTextTextPersonName);
        emailText = (EditText) findViewById(R.id.editTextTextEmailAddress);
        passwordText = (EditText) findViewById(R.id.editTextTextPassword);

        presenter = new Presenter(this, getApplicationContext());

        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                create.setEnabled(s.length() > 0);
            }
        });

        emailText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                create.setEnabled(s.length() > 0);
            }
        });

        passwordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                create.setEnabled(s.length() > 0);
            }
        });

        /**
         * Sets what happens when the button called back is clicked
         */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**
         * Sets what happens when the button called create is clicked.
         */
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL;
                URL = getResources().getString(R.string.UsersURL);

                if(emptyFields()) {
                    //TODO
                    System.out.println("Not all fields met.");
                } else {
                    User newUser = new User(nameText.getText().toString(), emailText.getText().toString(), passwordText.getText().toString());
                    presenter.checkDuplicate(URL, newUser);
                    finish();
                }
            }
        });


    }

    /**
     * Method returns whether a field is not filled or not.
     * @return True if any single field is left empty.
     */
    private boolean emptyFields() {
        return (nameText.getText().toString().matches("") || emailText.getText().toString().matches("") || passwordText.getText().toString().matches(""));
    }

    @Override
    public void setString(String s) {
        //TODO
    }
}
