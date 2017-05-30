package com.example.bungbau.bungbaufc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


public class main_activity extends AppCompatActivity {
    @Override
    protected  void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = (Button) findViewById(R.id.button_register);

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(main_activity.this,register_activity.class));
            }


        });
    }
    public void Nextregister (View view) {

    }

}
