package com.example.registrationformapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginhome extends AppCompatActivity {
    //-----------mainactivity starts here---------

    Button displayBtn;
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginhome);

        //--- taking var to store id value
        displayBtn= findViewById(R.id.loginBtn_loginpage);


    }



//------------------main activity ends here-----------------------
}