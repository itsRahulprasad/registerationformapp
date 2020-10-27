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


        login_var = findViewById(R.id.login2);
        regEmail = findViewById(R.id.t1);
        regPass = findViewById(R.id.t2);

        login_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                boolean isExist = databaseHelper.checkUserExist( regEmail.getText().toString(),  regPass.getText().toString());


                Intent intent = new Intent(loginpage.this, loginhome.class);
////                    intent.putExtra("username",  regEmail.getText().toString());
                    startActivity(intent);
//                if(isExist){
//                    Intent intent = new Intent(loginpage.this, loginhome.class);
////                    intent.putExtra("username",  regEmail.getText().toString());
//                    startActivity(intent);
//                } else {
//                    regPass.setText(null);
//                    Toast.makeText(loginpage.this, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show();
//                }
            }
        });


    }
    }


