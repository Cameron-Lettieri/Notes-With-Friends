package com.example.noteswithfriends.Activities;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.noteswithfriends.Notes.ChecklistNote;
import com.example.noteswithfriends.Notes.INote;
import com.example.noteswithfriends.Notes.Note;
import com.example.noteswithfriends.Notes.TextItem;
import com.example.noteswithfriends.Volley.FolderVolley;
import com.example.noteswithfriends.Volley.NoteVolley;

import net.bytebuddy.pool.TypePool;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;


public class CreateNoteTest {
        @Test
    public void test(){

        INote checkNote = new ChecklistNote();
        TextItem textItemCheck = new TextItem();
        textItemCheck.setContentString("test");
        textItemCheck.setChecked(true);
        checkNote.setNoteContents(textItemCheck);
        checkNote.setNoteName("checkNoteTest");

        NoteVolley nVolley = mock(NoteVolley.class);
        when(nVolley.getNote()).thenReturn(checkNote);

        ChecklistNote checkNote2 = new ChecklistNote();

        checkNote2.checkFromVolley(nVolley);

        assertEquals(checkNote2.getNoteContents(), checkNote.getNoteContents());

        assertEquals(checkNote2.getNoteName(), checkNote.getNoteName());

            INote dNote = new Note();
            dNote.setNoteContents(textItemCheck);
            dNote.setNoteName("checkNoteTest");

            when(nVolley.getNote()).thenReturn(dNote);

            ChecklistNote checkNote3 = new ChecklistNote();

            checkNote3.checkFromVolley(nVolley);

            assertNotEquals(checkNote3.getNoteName(), dNote.getNoteName());

    }
}