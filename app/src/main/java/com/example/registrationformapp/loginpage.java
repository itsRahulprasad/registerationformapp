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

    Button login_var1;
    EditText regEmail1;
    EditText regPass1;
//    DatabaseHelper databaseHelper ;

    //-- databases instance
    DatabaseHelper myDb;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

// -------button fetching ad storing them in varaible
        login_var1 = findViewById(R.id.loginBtn_loginpage);
        regEmail1 = findViewById(R.id.email_loginpage);
        regPass1 = findViewById(R.id.pass_loginpage);

        //-----taking database, variable
        myDb = new DatabaseHelper(this);

        login_var1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_id = regEmail1.getText().toString();
                String password = regPass1.getText().toString();

                if(email_id.equals(" ")|| password.equals(" "))
                    Toast.makeText(loginpage.this, " please enter all the details ",Toast.LENGTH_SHORT).show();
                else {
                    boolean checkuserpass = myDb.checkusernamepassword(email_id, password);
                    if (checkuserpass == true) {
                        Toast.makeText(loginpage.this, " login successfully ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),loginhome.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(loginpage.this, " invalid credential ", Toast.LENGTH_SHORT).show();
                    }

//                Intent intent = new Intent(loginpage.this, loginhome.class);
//                    startActivity(intent);
                }
            }
        });


        }
    }


