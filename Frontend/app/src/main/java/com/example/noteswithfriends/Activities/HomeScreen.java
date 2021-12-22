package com.example.noteswithfriends.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.TextView;

import com.example.noteswithfriends.Notes.ChecklistNote;
import com.example.noteswithfriends.Notes.INote;
import com.example.noteswithfriends.Notes.NoteFolder;
import com.example.noteswithfriends.Notes.TableNote;
import com.example.noteswithfriends.Notes.TextItem;
import com.example.noteswithfriends.R;
import com.example.noteswithfriends.Users.IUser;
import com.example.noteswithfriends.Volley.FolderVolley;
import com.example.noteswithfriends.Volley.NoteVolley;
import com.example.noteswithfriends.Volley.UserVolley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    /**
     * Id of current user
     */
    int userId;
    /**
     * Id of current note
     */
    int noteId;
    /**
     * current User object
     */
    static IUser user;
    /**
     * current UserVolley used to retrieve user from server
     */
    UserVolley userVolley;
    /**
     * String representing the name of the current user
     */
    String userNameMessage;
    /**
     * Current note used by the User
     */
    INote userNote;
    /**
     * NoteVolley used to retrieve current note from the server
     */
    NoteVolley noteVolley;
    /**
     * current users ID
     */
    static String userID;

    public int userNumber = 1;

    JSONArray notesArray;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;

    private Button chat;

    public static JSONObject currentNote;

    // FOR MENU
    static ArrayList<INote> notes = new ArrayList<>();
    static ArrayList<String> contents = new ArrayList<>();
    static ArrayList<String> docNames = new ArrayList<>();
    static ArrayAdapter<String> arrayAdapter;

    private void setNotes() {
        notes.addAll(user.getNotes2());
    }

//    private void startLink() {
//        setNotes();
//        linkContents();
//        linkDocNames();
//    }

//    static void linkContents(){
//        for(int i = 0; i < notes.size(); i++) {
//            contents.set(i, notes.get(i).getNoteContents());
//        }
//    }

    static void linkDocNames(){
        for(int i = 0; i < notes.size(); i++) {
            docNames.set(i, notes.get(i).getNoteName());
        }
    }

//    static void linkNoteContents(){
//        for(int i = 0; i < notes.size(); i++) {
//            notes.get(i).setNoteContents(contents.get(i));
//        }
//    }

    static void linkNoteNames(){
        for(int i = 0; i < notes.size(); i++) {
            notes.get(i).setNoteName(docNames.get(i));
        }
    }

    /**
     *Controls what is shown on the classes creation.  Also controls what actions are taken when buttons are pressed.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        TextView userName = (TextView) findViewById(R.id.usersName);
        Intent intent = getIntent();
        userNameMessage = intent.getStringExtra(LoginScreen.userNameMessage);
        noteVolley = new NoteVolley();
        noteVolley.getNotes(HomeScreen.this);

//        noteVolley.updateContents(this);

        userVolley = new UserVolley();
        userVolley.GetNotesFromUser(LoginScreen.user.getID(), this);


        //chat = findViewById(R.id.chat);

        
        Context context = this;
        chat = (Button) findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatIntent = new Intent(context, WebsocketOutline.class);
                startActivity(chatIntent);
            }
        });
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);

        createUser();
        userName.setText("Welcome " + userNameMessage + "!");
        Button newDocument = (Button) findViewById(R.id.newDocumentButton);
        newDocument.setOnClickListener(this::onClickCreateDocument);
        Button newFolder = (Button) findViewById(R.id.newFolderButton);
        newFolder.setOnClickListener(this::onClickCreateFolder);
        Button refreshButton = (Button) findViewById(R.id.refreshButton2);
        refreshButton.setOnClickListener(this::refresh);
        logout();

            button1.setOnClickListener(this::button1Pressed);
            button2.setOnClickListener(this::button2Pressed);
            button3.setOnClickListener(this::button3Pressed);
            button4.setOnClickListener(this::button4Pressed);
            button5.setOnClickListener(this::button5Pressed);
            button6.setOnClickListener(this::button6Pressed);
            button7.setOnClickListener(this::button7Pressed);

        Button testButton = (Button) findViewById(R.id.testButton);
        testButton.setOnClickListener(this::testButton);

//        startLink();
//        ListView listView = (ListView)findViewById(R.id.listView);
//        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.tanay.thunderbird.deathnote", Context.MODE_PRIVATE);
//        HashSet<String> set = (HashSet<String>)sharedPreferences.getStringSet("contents", null);
//
//        if(set == null) {
////            notes.add(new Note());
////            contents.add("");
////            docNames.add("Untitled Doc");
//        } else {
//            contents = new ArrayList<>(set);         // to bring all the already stored data in the set to the notes ArrayList
//        }
//
//        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, docNames);
//        listView.setAdapter(arrayAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//            {
//                Intent intent = new Intent(getApplicationContext(), DocumentScreen.class);
//                intent.putExtra("noteID", position);
//                startActivity(intent);
//            }
//        });
//
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id)
//            {
//                new AlertDialog.Builder(HomeScreen.this)                   // we can't use getApplicationContext() here as we want the activity to be the context, not the application
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .setTitle("Delete?")
//                        .setMessage("Are you sure you want to delete this note?")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which)                        // to remove the selected note once "Yes" is pressed
//                            {
//                                notes.remove(position);
//                                contents.remove(position);
//                                docNames.remove(position);
//                                arrayAdapter.notifyDataSetChanged();
//
//                                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.tanay.thunderbird.deathnote", Context.MODE_PRIVATE);
//                                HashSet<String> set = new HashSet<>(contents);
//                                sharedPreferences.edit().putStringSet("notes", set).apply();
//                            }
//                        })
//
//                        .setNegativeButton("No", null)
//                        .show();
//
//                return true;               // this was initially false but we change it to true as if false, the method assumes that we want to do a short click after the long click as well
//            }
//        });
    }

    private void testButton(View view) {
        NoteVolley nVolley = new NoteVolley();
        ChecklistNote checkNote = new ChecklistNote();
        TextItem textItem = new TextItem();
        textItem.setChecked(true);
        textItem.setContentString("test contents");
        checkNote.setNoteName("test checklist note");
        checkNote.setContents(textItem);
        TableNote tableNote = new TableNote();
        tableNote.setNoteName("test table note");
        tableNote.setContents(textItem);
        System.out.println(checkNote.toJsonObjectNewNote());
        nVolley.putNoteNew(checkNote, this);
        nVolley.putNoteNew(tableNote, this);
        FolderVolley fVolley = new FolderVolley();
        fVolley.putFolder(this);
    }

    private void refresh(View view){
        userVolley.GetNotesFromUser(LoginScreen.user.getID(), this);
        LoginScreen.user.setNotes(LoginScreen.userV.getNotes());
        notesArray = userVolley.getNotes();
        System.out.println("NOTICE " + notesArray);
        for(int i = 1; i <= notesArray.length(); i++){
            JSONObject note;
            try {
                note = notesArray.getJSONObject(i - 1);
                if(i == 1){
                    button1.setText("" + note.get("name"));
                }
                if(i == 2){
                    button2.setText("" + note.get("name"));
                }
                if(i == 3){
                    button3.setText("" + note.get("name"));
                }
                if(i == 4){
                    button4.setText("" + note.get("name"));
                }
                if(i == 5){
                    button5.setText("" + note.get("name"));
                }
                if(i == 6){
                    button6.setText("" + note.get("name"));
                }
                if(i == 7){
                    button7.setText("" + note.get("name"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void button1Pressed(View view) {
        if(button1.getText() != "") {
            Intent intent = new Intent(this, DocumentScreen.class);
            try {
                currentNote = notesArray.getJSONObject(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            startActivity(intent);
        }
    }

    private void button2Pressed(View view) {
        if(button2.getText() != "") {
            Intent intent = new Intent(this, DocumentScreen.class);
            try {
                currentNote = notesArray.getJSONObject(1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            startActivity(intent);
        }
    }

    private void button3Pressed(View view) {
        if(button3.getText() != "") {
            Intent intent = new Intent(this, DocumentScreen.class);
            try {
                currentNote = notesArray.getJSONObject(2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            startActivity(intent);
        }
    }

    private void button4Pressed(View view) {
        if(button4.getText() != "") {
            Intent intent = new Intent(this, DocumentScreen.class);
            try {
                currentNote = notesArray.getJSONObject(3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            startActivity(intent);
        }
    }

    private void button5Pressed(View view) {
        if(button5.getText() != "") {
            Intent intent = new Intent(this, DocumentScreen.class);
            try {
                currentNote = notesArray.getJSONObject(4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            startActivity(intent);
        }
    }

    private void button6Pressed(View view) {
        if(button6.getText() != "") {
            Intent intent = new Intent(this, DocumentScreen.class);
            try {
                currentNote = notesArray.getJSONObject(5);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            startActivity(intent);
        }
    }

    private void button7Pressed(View view) {
        if(button7.getText() != "") {
            Intent intent = new Intent(this, DocumentScreen.class);
            try {
                currentNote = notesArray.getJSONObject(6);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            startActivity(intent);
        }
    }

    /**
     * When logout button is pressed, will return to login screen.
     */
    private void logout() {
        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * retrieves User with given name from the server.
     */
    public void createUser(){
        try {
            userVolley.getUserFromName(userNameMessage, HomeScreen.this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * when create document button is pressed, will advance to document creation screen.
     * @param view
     */
    public void onClickCreateDocument(View view){
//        createUser();
//        System.out.println(user);
//        userNote = new Note();
//        noteVolley = new NoteVolley();
//        noteVolley.putNote(userNote, HomeScreen.this);
//        userId = user.getID();
//        noteId = userNote.getNoteID();
        //userVolley.AssignNote(1, userId, HomeScreen.this);
        Intent intent = new Intent(this, CreateNote.class);
        //intent.putExtra(Note, userNote.getNoteID());
        user = userVolley.getUser();
        userID = "" + user.getID();
        intent.putExtra(userID, user.getID());
        startActivity(intent);
    }

    /**
     * when create folder button is pressed will have NewFolderScreen appear in a popup window.
     * @param view
     */
    public void onClickCreateFolder(View view){

        System.out.println(noteVolley.getNoteArray());
        //createUser();
//        String folderName = "";
//        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        PopupWindow pw = new PopupWindow(inflater.inflate(R.layout.activity_new_folder_screen, null, false),1000,1000, true);
//        pw.showAtLocation(this.findViewById(R.id.layoutTemplate), Gravity.CENTER, 0, 0);
//        IFolder homeScreenFolder = new NoteFolder();
    }

    public static void loadFolders(FolderVolley volley){
        FolderVolley fvolley = volley;
        JSONArray folders = fvolley.getFolders();
        JSONObject folder = null;
        try {
            folder = (JSONObject) folders.get(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int k = 0; k < folders.length(); k++){
            try {
                System.out.println(folder.get("name"));
                JSONArray contentsOfFolder = (JSONArray) folder.get("notes");
                System.out.println(contentsOfFolder);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * returns all Folders contained within a given User.
     * @return
     */
    public NoteFolder displayFolders(){
        NoteFolder folder = new NoteFolder();
        return folder;
    }

}