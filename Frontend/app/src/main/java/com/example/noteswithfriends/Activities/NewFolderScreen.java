package com.example.noteswithfriends.Activities;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.noteswithfriends.R;


public class NewFolderScreen extends AppCompatActivity {

    /**
     *Controls what is shown on the classes creation.  Also controls what actions are taken when buttons are pressed.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_folder_screen);
        Button createFolder = (Button) findViewById(R.id.CreateFolderButton);
        createFolder.setOnClickListener(this::onClickCreateFolder);
    }

    /**
     * creates new NoteFolder object and adds it to a User.
     * @param view
     */
    public void onClickCreateFolder(View view){

    }

}