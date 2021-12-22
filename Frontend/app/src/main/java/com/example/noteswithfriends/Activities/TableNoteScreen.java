package com.example.noteswithfriends.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.noteswithfriends.Notes.INote;
import com.example.noteswithfriends.Notes.ITableNote;
import com.example.noteswithfriends.Notes.TableNote;
import com.example.noteswithfriends.R;
import com.example.noteswithfriends.Volley.NoteVolley;
import com.example.noteswithfriends.Volley.UserVolley;

public class TableNoteScreen extends AppCompatActivity {

    /**
     * Current documents name
     */
    String documentName;
    /**
     * Current String contents stored in the Note
     */
    String contents;
    /**
     * Current TableNote object
     */
    ITableNote note;
    /**
     * current Note Volley used to retrieve Note from server
     */
    NoteVolley nVolley;

    /**
     *Controls what is shown on the classes creation.  Also controls what actions are taken when buttons are pressed.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_screen);
        note = new TableNote();
        nVolley = new NoteVolley();
        Button newFolder = (Button) findViewById(R.id.SaveButton);
        newFolder.setOnClickListener(this::SaveDocument);
        Intent intent = getIntent();
        documentName = intent.getStringExtra(CreateNote.documentNameString);
        TextView userName = (TextView) findViewById(R.id.noteNameText);
        userName.setText(documentName);
        quit();
    }

    /**
     * When exit button is pressed, will return to previous screen.
     */
    private void quit() {
        Button logoutButton = findViewById(R.id.exitButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * Saves changes to document by updating document name and document contents.
     * @param view
     */
    public void SaveDocument(View view){
        INote note = new TableNote();
        TextView noteName = (TextView) findViewById(R.id.noteNameText);
        note.setNoteName(noteName.getText().toString());
        TextView noteContents = (TextView) findViewById(R.id.DocumentTextBox);
        System.out.println(noteContents.getText().toString());
        //note.setNoteContents(noteContents.getText().toString());
        NoteVolley testVolley = new NoteVolley();
        testVolley.putNote(note, TableNoteScreen.this);
        UserVolley userVolley = new UserVolley();
        System.out.println("Table Note added");
    }
}