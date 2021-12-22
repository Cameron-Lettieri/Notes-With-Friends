package com.example.noteswithfriends.Activities;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.noteswithfriends.Notes.IFolder;
import com.example.noteswithfriends.Notes.Note;
import com.example.noteswithfriends.Notes.NoteFolder;
import com.example.noteswithfriends.Notes.TextItem;
import com.example.noteswithfriends.Volley.FolderVolley;
import com.example.noteswithfriends.Volley.NoteVolley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class HomeScreenTest {

    @Test
    public void displayFolders() throws JSONException {
        Note note = new Note();
        TextItem textItem = new TextItem();
        note.setID(1);
        note.setNoteContents(textItem);
        note.setNoteName("note1");

        System.out.println(note.toJsonObject().toString());
//        NoteFolder folder = new NoteFolder();
//        JSONArray folders = folder.toJSONArray();
//
//        Note note1 = new Note();
//        JSONObject note = note1.toJsonObject();
//
//
//        FolderVolley fVolley = mock(FolderVolley.class);
//        when(fVolley.getFolders()).thenReturn(folders);
//
//        HomeScreen.loadFolders(fVolley);

//        String documentName;
//        String contents;
//        IFolder folder = new NoteFolder();
//        NoteVolley nVolley;
//        String[][] noteTestArray = new String[0][0];
//
//        //adds normal note
//
//        Note noteObject = new Note(1, noteTestArray, "note1");
//
//        nVolley = mock(NoteVolley.class);
//        when(nVolley.getNote()).thenReturn(noteObject);
//
//        folder.addNoteToFolder(nVolley);
//        int[] noteNames = folder.getNoteIds();
//
//        int[] expectedArray = {1, 0, 0, 0, 0};
//
//        assertArrayEquals(noteNames, expectedArray);
//
//        //shouldn't add same note to the same folder
//
//        folder.addNoteToFolder(nVolley);
//        int[] noteNames2 = folder.getNoteIds();
//
//        int[] expectedArray2 = {1, 0, 0, 0, 0};
//
//        assertArrayEquals(noteNames2, expectedArray2);
//
//        //removes note from folder
//
//        folder.removeNoteFromFolder(nVolley);
//
//        noteNames2 = folder.getNoteIds();
//
//        int[] expectedArray3 = {0, 0, 0, 0, 0};
//
//        assertArrayEquals(noteNames2, expectedArray3);
//
//        //fill the folder
//
//        noteObject = new Note(2, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.addNoteToFolder(nVolley);
//        noteObject = new Note(3, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.addNoteToFolder(nVolley);
//        noteObject = new Note(4, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.addNoteToFolder(nVolley);
//        noteObject = new Note(5, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.addNoteToFolder(nVolley);
//        noteObject = new Note(6, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.addNoteToFolder(nVolley);
//
//        int[] expectedArray4 = {2, 3, 4, 5, 6};;
//
//        assertArrayEquals(noteNames2, expectedArray4);
//
//        //tries to remove object that isn't there
//
//        noteObject = new Note(1, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.removeNoteFromFolder(nVolley);
//
//        int[] expectedArray5 = {2, 3, 4, 5, 6};;
//
//        assertArrayEquals(noteNames2, expectedArray5);
//
//        //removes every note from folder
//
//        noteObject = new Note(2, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.removeNoteFromFolder(nVolley);
//        noteObject = new Note(3, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.removeNoteFromFolder(nVolley);
//        noteObject = new Note(4, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.removeNoteFromFolder(nVolley);
//        noteObject = new Note(5, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.removeNoteFromFolder(nVolley);
//        noteObject = new Note(6, noteTestArray, "note1");
//        when(nVolley.getNote()).thenReturn(noteObject);
//        folder.removeNoteFromFolder(nVolley);
//
//        int[] expectedArray6 = {0, 0, 0, 0, 0};;
//
//        assertArrayEquals(noteNames2, expectedArray6);
    }
}