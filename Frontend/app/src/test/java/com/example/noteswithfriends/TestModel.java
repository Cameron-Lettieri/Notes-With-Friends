package com.example.noteswithfriends;

import android.content.Context;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.noteswithfriends.MVPTrial.IView;
import com.example.noteswithfriends.MVPTrial.IVolleyListener;
import com.example.noteswithfriends.MVPTrial.Model;
import com.example.noteswithfriends.MVPTrial.Presenter;
import com.example.noteswithfriends.Users.IUser;


@RunWith(MockitoJUnitRunner.class)
public class TestModel {

    @Mock
    private Context context;

    @Mock
    private IView view;

    @Mock
    private Model model;

    @Mock
    private JSONObject object;

    @Mock
    private IVolleyListener volleyListener;

    @Mock
    private IUser user;

    @Test
    public void test() {

        String url = "http://coms-309-064.cs.iastate.edu:8080/users";

        Presenter presenter = new Presenter(view);
        presenter.setModel(model);

        presenter.checkDuplicate(url, user);
        presenter.addUser(url, object);

        verify(model, times(1)).findDuplicateUser(url, user, presenter);
        verify(model, times(1)).addNewUser(url, object, presenter);
    }

}
