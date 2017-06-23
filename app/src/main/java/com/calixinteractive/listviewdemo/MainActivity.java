package com.calixinteractive.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.calixinteractive.listviewdemo.adapter.UserAdapter;
import com.calixinteractive.listviewdemo.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = fillUsersList();

        //Create Adapter
        final UserAdapter adapter = new UserAdapter(getBaseContext(), users);

        // Fill List
        final ListView userList = (ListView) findViewById(R.id.listViewUsers);
        userList.setAdapter(adapter);

        //setOnItemClickListener
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> av, View view, int i, long l)
            {
                User user = (User) adapter.getItem(i);

                System.out.println("Array Pos. ....: " + i);
                System.out.println("User ID .......: " + String.valueOf(user.getId()));
                System.out.println("User Name .....: " + user.getName() );
                System.out.println("User Email ....: " + user.getEmail() );

                Toast.makeText(MainActivity.this,  user.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public ArrayList<User> fillUsersList()
    {
        ArrayList<User> array = new ArrayList<User>();

        User usr1 = new User(1, "Jon Snow"           , "jon@mail.com");
        User usr2 = new User(4, "Tyrion Lannister"   , "tyrion@mail.com");
        User usr3 = new User(2, "Cersei Lannister"   , "cersei@mail.com");
        User usr4 = new User(9, "Daenerys Targaryen" , "daenerys@mail.com");

        array.add(usr2);
        array.add(usr1);
        array.add(usr4);
        array.add(usr3);

        return array;
    }
}
