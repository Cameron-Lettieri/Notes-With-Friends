package com.example.noteswithfriends.Utility;

import android.widget.EditText;

/**
 * Basic util class for widget objects
 */
public class WigitUtil {

    /**
        Method used to test whether an edit text object is empty.
    */
    public boolean isEmpty(EditText text) {
        return text.getText().toString().matches("");
    }
}
