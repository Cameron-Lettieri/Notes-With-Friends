package com.example.noteswithfriends;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.isNull;
import static org.mockito.Mockito.when;

import android.content.Context;

import com.example.noteswithfriends.Users.IUser;
import com.example.noteswithfriends.Volley.UserVolley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;


@RunWith(MockitoJUnitRunner.class)
public class TestUserVolley {

    @Mock
    private Context context;

    @Mock
    private IUser user;

    @Mock
    private UserVolley uV;

    @Test
    public void test() {
        Assert.assertEquals(uV.getUser(), null);
        Assert.assertEquals(uV.getObject(), null);
        Assert.assertEquals(uV.getNotes(), null);


//        JSONObject test = new JSONObject();
//        try {
//            test.put("id", 2);
//            test.put("name", "CDTest");
//            test.put("email", "CDTest");
//            test.put("password", "password");
//            test.put("notes", new JSONArray());
//            test.put("folders", new JSONArray());
//            when(uV.getObject()).thenAnswer((Answer<?>) test);
//        } catch (Exception e) {
//            System.out.println("Next test is failed.");
//        }


    }

}
