package com.example.noteswithfriends.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.noteswithfriends.Notes.ChecklistNote;
import com.example.noteswithfriends.Notes.IChecklistNote;
import com.example.noteswithfriends.Notes.INote;
import com.example.noteswithfriends.Notes.Note;
import com.example.noteswithfriends.R;
import com.example.noteswithfriends.Volley.NoteVolley;
import com.example.noteswithfriends.Volley.UserVolley;

import org.json.JSONArray;
import org.json.JSONException;

public class ChecklistNoteScreen extends AppCompatActivity {

    /**
     * Current documents name
     */
    String documentName;
    /**
     * Current String contents stored in the Note
     */
    boolean[] contents;
    /**
     * Current Checklist Note object
     */
    IChecklistNote note;
    /**
     * current Note Volley used to retrieve Note from server
     */
    NoteVolley nVolley;

    int noteID;

    /**
     *Controls what is shown on the classes creation.  Also controls what actions are taken when buttons are pressed.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_screen);
        Intent intent = getIntent();
        documentName = intent.getStringExtra(documentName);
        System.out.println(LoginScreen.user.getID());
        note = new ChecklistNote();

//        if(HomeScreen.user.getNotes2().size() > 0){
//            note = HomeScreen.user.getNotes2().get(noteID);
//        }

        nVolley = new NoteVolley();
        nVolley.getNotes(this);
        Button newFolder = (Button) findViewById(R.id.SaveButton);
        newFolder.setOnClickListener(this::SaveDocument);
        TextView noteName = (TextView) findViewById(R.id.noteNameText);
        EditText noteContents = (EditText)findViewById(R.id.DocumentTextBox);

        quit();

        noteID = -1;
        if(HomeScreen.currentNote != null){
            try {
                noteContents.setText((String)HomeScreen.currentNote.get("contents"));
                noteName.setText((String)HomeScreen.currentNote.get("name"));
                noteID = (int)HomeScreen.currentNote.get("id");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }else{
//            noteContents.setText(note.getNoteContents());
            noteName.setText(documentName);
        }
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_document_screen);
//        note = new ChecklistNote();
//        nVolley = new NoteVolley();
//        Button newFolder = (Button) findViewById(R.id.SaveButton);
//        newFolder.setOnClickListener(this::SaveDocument);
//        Intent intent = getIntent();
//        documentName = intent.getStringExtra(CreateNote.documentNameString);
//        TextView userName = (TextView) findViewById(R.id.noteNameText);
//        userName.setText(documentName);
//        quit();
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
        IChecklistNote note = new ChecklistNote();
        TextView noteName = (TextView) findViewById(R.id.noteNameText);
        note.setNoteName(noteName.getText().toString());
        TextView noteContents = (TextView) findViewById(R.id.DocumentTextBox);
        System.out.println(noteContents.getText().toString());
        //note.setNoteContents(noteContents.getText().toString());
        NoteVolley testVolley = new NoteVolley();
        if(noteID == -1){
            testVolley.putNoteNew(note, this);
            JSONArray noteArray = nVolley.getNoteArray();
            try {
                noteID = (int)noteArray.getJSONObject(noteArray.length()-1).get("id") + 1;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            note.setID(noteID);
            testVolley.putNote(note, this);
        }
        UserVolley userVolley = new UserVolley();
        userVolley.AssignNote(noteID, LoginScreen.user.getID(), this);
        System.out.println("Document Saved");
    }
//        INote note = new ChecklistNote();
//        TextView noteName = (TextView) findViewById(R.id.noteNameText);
//        note.setNoteName(noteName.getText().toString());
//        TextView noteContents = (TextView) findViewById(R.id.DocumentTextBox);
//        System.out.println(noteContents.getText().toString());
//        note.setNoteContents(noteContents.getText().toString());
//        NoteVolley testVolley = new NoteVolley();
//        testVolley.putNote(note, ChecklistNoteScreen.this);
//        UserVolley userVolley = new UserVolley();
//        System.out.println("Checklist note added");

}