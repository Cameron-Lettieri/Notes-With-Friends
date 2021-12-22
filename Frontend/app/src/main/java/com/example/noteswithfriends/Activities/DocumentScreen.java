package com.example.noteswithfriends.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.noteswithfriends.Notes.INote;
import com.example.noteswithfriends.Notes.Note;
import com.example.noteswithfriends.Notes.TextItem;
import com.example.noteswithfriends.R;
import com.example.noteswithfriends.Volley.NoteVolley;
import com.example.noteswithfriends.Volley.UserVolley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;

public class DocumentScreen extends AppCompatActivity {

    /**
     * Current documents name
     */
    String documentName;
    /**
     * Current String contents stored in the Note
     */
    String contents;
    /**
     * Current Note object
     */
    INote note;
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
        note = new Note();

        if(HomeScreen.user.getNotes2().size() > 0){
            note = HomeScreen.user.getNotes2().get(noteID);
        }

        nVolley = new NoteVolley();
        nVolley.getNotes(this);
        nVolley.getContents(this);
        Button newFolder = (Button) findViewById(R.id.SaveButton);
        newFolder.setOnClickListener(this::SaveDocument);
        TextView noteName = (TextView) findViewById(R.id.noteNameText);
        EditText noteContents = (EditText)findViewById(R.id.DocumentTextBox);

        quit();

        noteID = -1;
        if(HomeScreen.currentNote != null){
            try {
                System.out.println("HERE:" + HomeScreen.currentNote.toString());
                JSONArray contents = (JSONArray) HomeScreen.currentNote.get("contents");
                JSONObject textItem = (JSONObject) contents.get(0);
                noteContents.setText(textItem.getString("contentString"));
                noteName.setText((String)HomeScreen.currentNote.get("name"));
                noteID = (int)HomeScreen.currentNote.get("id");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }else{
//            JSONObject contentArrayTemp = note.getNoteContents().toJSONObject();
//            try {
//                noteContents.setText((String)contentArrayTemp.get("contentString"));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            noteName.setText(documentName);
        }


//        noteID = intent.getIntExtra("noteID", -1);



//        if(noteID != -1) {
//            editText.setText(HomeScreen.notes.get(noteID).getNoteContents());
//        } else
//        {
//            INote note = new Note();
//            HomeScreen.notes.add(note);              // as initially, the note is empty
//            HomeScreen.contents.add("");
//            HomeScreen.docNames.add("Untitled Doc");
//            noteID = HomeScreen.notes.size() - 1;
//            HomeScreen.arrayAdapter.notifyDataSetChanged();
//        }

//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after)
//            {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count)
//            {
//                HomeScreen.contents.set(noteID, String.valueOf(s));
//                HomeScreen.arrayAdapter.notifyDataSetChanged();
//                HomeScreen.linkNoteContents();
//
//                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.tanay.thunderbird.deathnote", Context.MODE_PRIVATE);
//                HashSet<String> set = new HashSet<>(HomeScreen.contents);
//                sharedPreferences.edit().putStringSet("notes", set).apply();
//            }
//
//            @Override
//            public void afterTextChanged(Editable s)
//            {
//
//            }
//        });
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
        INote note = new Note();
        TextView noteName = (TextView) findViewById(R.id.noteNameText);
        note.setNoteName(noteName.getText().toString());
        TextView noteContents = (TextView) findViewById(R.id.DocumentTextBox);
        System.out.println(noteContents.getText().toString());
        TextItem currentNoteContents = new TextItem();
        currentNoteContents.setContentString(noteContents.getText().toString());
        note.setNoteContents(currentNoteContents);
        NoteVolley testVolley = new NoteVolley();
        int contentId = 2;
        if(noteID == -1){
            testVolley.putNoteNew(note, DocumentScreen.this);
            JSONArray noteArray = nVolley.getNoteArray();
            try {
                noteID = (int)noteArray.getJSONObject(noteArray.length()-1).get("id")+1;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            try {
//                JSONObject note1 = nVolley.getNoteArray().getJSONObject(noteID);
//                JSONArray contentsArray = (JSONArray) note1.get("contents");
//                JSONObject content = (JSONObject) contentsArray.get(0);
//                contentId = (int) content.get("id") - 1;
                JSONArray contentArray = (JSONArray) HomeScreen.currentNote.get("contents");
                JSONObject content1 = (JSONObject) contentArray.get(0);
                contentId = (int) content1.get("id");
                System.out.println("CONTENT: " + content1.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            note.setID(noteID);
            TextItem textItem = new TextItem();
            textItem.setId(contentId);
            textItem.setContentString(noteContents.getText().toString());
            textItem.setChecked(true);
            note.setNoteContents(textItem);
            System.out.println("TO STRING:" + note.toJsonObject().toString());
            System.out.println(HomeScreen.currentNote.toString());
            testVolley.putNote(note, DocumentScreen.this);


            //testVolley.updateContents(textItem, this);
        }
        UserVolley userVolley = new UserVolley();
        System.out.println("ASSOCIATIONS: " + LoginScreen.user.getID() + " " + noteID);
        userVolley.AssignNote(noteID, LoginScreen.user.getID(), this);
        System.out.println("Document Saved");
        HomeScreen.currentNote = note.toJsonObject();
    }

}