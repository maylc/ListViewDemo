package com.calixinteractive.listviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.calixinteractive.listviewdemo.R;
import com.calixinteractive.listviewdemo.model.User;

import java.util.ArrayList;


public class UserAdapter extends ArrayAdapter<User>
{

    private Context context;
    private ArrayList<User> users = null;



    public UserAdapter(@NonNull Context context, ArrayList<User> users)
    {
        super(context, 0, users);
        this.context  = context;
        this.users = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        /************************************/
        /** Get Data from current Position***/
        /************************************/

        User user = users.get(position);

        /************************************/
        /********** Check Context ***********/
        /************************************/

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_layout_user, parent, false);
        }

        /***********************/
        /**** Get Objects ******/
        /***********************/

        TextView txtUserName = (TextView) convertView.findViewById(R.id.lv_user_name);
        TextView txtUserID   = (TextView) convertView.findViewById(R.id.lv_user_id);

        /***********************/
        /**** Build the List ***/
        /***********************/

        txtUserName.setText(user.getName());
        txtUserID.setText(String.valueOf(user.getId()));

        /***********************/
        /***** Return **********/
        /***********************/

        return convertView;
    }

}
