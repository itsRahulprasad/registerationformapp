package com.example.registrationformapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updatepage extends AppCompatActivity {

    //----- storing variable ------
    DatabaseHelper myDb;
    Button updateBtn;
    EditText update_id;

    EditText regName;
    EditText regUsername;
    EditText regEmail;
    EditText regPhone;
    EditText regPass;
    EditText regConfpass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepage);

        //--- taking var to store id value
        updateBtn=findViewById(R.id.updateBtn_updatepage);
        update_id= findViewById(R.id.id_updatepage);

        regName = findViewById(R.id.name_id);
        regUsername = findViewById(R.id.username_id);
        regEmail = findViewById(R.id.email_id);
        regPhone = findViewById(R.id.phone_id);
        regPass = findViewById(R.id.pass_id);
        regConfpass = findViewById(R.id.confpass_id);


        //-----taking database in variable
        myDb = new DatabaseHelper(this);

        // calling updatedata()
        updateData();


    }


    public void updateData(){
        updateBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData (
                                update_id.getText().toString(),
                                regName.getText().toString(),
                                regUsername.getText().toString(),
                                regEmail.getText().toString(),
                                regPhone.getText().toString(),
                                regPass.getText().toString(),
                                regConfpass.getText().toString()
                                );

                        if (isUpdate == true){

                                Toast.makeText(updatepage.this, "data is updated", Toast.LENGTH_LONG).show();
                            }
                       else {
                                Toast.makeText(updatepage.this, "data not updated", Toast.LENGTH_LONG).show();
                            }

                    }
                }

        );
    }
}