package com.example.bungbau.bungbaufc;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class register_activity extends main_activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }
    public void Backregister (View view) {
        Button btn_back = (Button) findViewById(R.id.button_Confirm);

        EditText username = (EditText) findViewById(R.id.edit_username_login);
        EditText password = (EditText) findViewById(R.id.edit_password_login);
        EditText email    = (EditText) findViewById(R.id.edit_email_login);







        Intent intent = new Intent(register_activity.this,main_activity.class);

        startActivity(intent);


    }


}
