package com.example.noteswithfriends.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;


import com.example.noteswithfriends.Notes.ChecklistNote;
import com.example.noteswithfriends.Notes.INote;
import com.example.noteswithfriends.Notes.Note;
import com.example.noteswithfriends.R;
import com.example.noteswithfriends.Volley.NoteVolley;


public class CreateNote extends AppCompatActivity {

    /**
     * String name of the intent passed to the next activity.
     */
    public static String documentNameString;
    /**
     * String representing the current Notes name.
     */
    String documentName;

    String userID;

    /**
     *Controls what is shown on the classes creation.  Also controls what actions are taken when buttons are pressed.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        userID = intent.getStringExtra(HomeScreen.userID);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_note);

        cancelCreation();
        Button newNote = (Button) findViewById(R.id.DefaultButton);
        newNote.setOnClickListener(this::createDefaultNote);

        Button newChecklist = (Button) findViewById(R.id.ChecklistButton);
        newChecklist.setOnClickListener(this::createChecklistNote);

        Button newTableNote = (Button) findViewById(R.id.TableButton);
        newTableNote.setOnClickListener(this::createTableNote);

        HomeScreen.currentNote = null;
    }

    /**
     * retrieves the documents name and advances to the DocumentScreen.
     * @param view
     */
    private void createDefaultNote(View view){
        EditText docName = (EditText) findViewById(R.id.newDocName);
        documentName = docName.getText().toString();

        INote newNote = new Note();
        newNote.setNoteName(documentName);

//        HomeScreen.notes.add(newNote);
//        HomeScreen.contents.add("");
//        HomeScreen.docNames.add(documentName);
//        HomeScreen.arrayAdapter.notifyDataSetChanged();
//        HomeScreen.user.createNote(newNote);

        Intent intent = new Intent(this, DocumentScreen.class);
        intent.putExtra(documentNameString, documentName);
        startActivity(intent);
    }

    /**
     * retrieves the documents name and advances to the ChecklistNoteScreen.
     * @param view
     */
    private void createChecklistNote(View view){
        EditText docName = (EditText) findViewById(R.id.newDocName);
        documentName = docName.getText().toString();
        Intent intent = new Intent(this, ChecklistNoteScreen.class);
        intent.putExtra(documentNameString, documentName);
        startActivity(intent);
    }

    /**
     * retrieves the documents name and advances to the TableNoteScreen.
     * @param view
     */
    private void createTableNote(View view){
        EditText docName = (EditText) findViewById(R.id.newDocName);
        documentName = docName.getText().toString();
        Intent intent = new Intent(this, TableNoteScreen.class);
        intent.putExtra(documentNameString, documentName);
        startActivity(intent);
    }

    /**
     * returns to the previous page when cancel button is clicked.
     */
    private void cancelCreation() {
        ImageButton backBtn = findViewById(R.id.cancelNoteButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void CreateChecklistNote(ChecklistNote checkNote){
        NoteVolley noteVolley = new NoteVolley();
        noteVolley.putNote(checkNote, this);
    }


}
