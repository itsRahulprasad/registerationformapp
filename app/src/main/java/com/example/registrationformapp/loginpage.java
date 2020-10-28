package com.example.registrationformapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


//checking github
public class loginpage extends AppCompatActivity {

    Button login_var;
    EditText regEmail;
    EditText regPass;
    DatabaseHelper databaseHelper ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);


        login_var = findViewById(R.id.loginBtn_loginpage);
        regEmail = findViewById(R.id.email_loginpage);
        regPass = findViewById(R.id.pass_loginpage);

        login_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpage.this, loginhome.class);
                    startActivity(intent);
            }
        });


    }
    }


