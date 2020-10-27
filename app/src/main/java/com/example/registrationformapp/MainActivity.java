package com.example.registrationformapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // deifine edittext, button etc in variable
    Button login_var;
    Button reg_var;
    EditText regName;
    EditText regUsername;
    EditText regEmail;
    EditText regPhone;
    EditText regPass;
    EditText regConfpass;

// databases instance
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // button fetching ad storing them in varaible
        login_var = findViewById(R.id.loginBtn);
        reg_var = findViewById(R.id.regBtn);

        //taking database, variable
        myDb = new DatabaseHelper(this);

        //finding finding id and storing them in varaible
        regName = findViewById(R.id.name_id);
        regUsername = findViewById(R.id.username_id);
        regEmail = findViewById(R.id.email_id);
        regPhone = findViewById(R.id.phone_id);
        regPass = findViewById(R.id.pass_id);
        regConfpass = findViewById(R.id.confpass_id);

        //call adddata fuction
//



    //redirecting login button click to login page {.'. here onclick button event = setOnClickListener}
        login_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), loginpage.class));
            }
        });

    }


    public void  AddData(){
       reg_var.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                   boolean isInserted = myDb.insertData(regName.getText().toString(),
                               regUsername.getText().toString(),
                               regEmail.getText().toString(),
                               regPhone.getText().toString(),
                               regPass.getText().toString(),
                               regConfpass.getText().toString()
                               );


                   if (isInserted = true)
                       Toast.makeText(MainActivity.this,"data inserted", Toast.LENGTH_LONG).show();
                       else
                           Toast.makeText(MainActivity.this,"data not inserted", Toast.LENGTH_LONG).show();

                   }
               }

       );


        };


    //registerUser function for regiter button and it was defined in register button as onclick registerUser
    //checking whether register button validates or not
public void registerUser (View view){
    submitvalidate();
    if (!submitvalidate()){
        Toast.makeText(this, "sibmission fail", Toast.LENGTH_SHORT).show();

    }else{
        Toast.makeText(this, "register success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), loginpage.class));
      AddData();

    }


    //------helper class to add or insert data in database

}

private boolean submitvalidate(){
    if(!validateName() | !validateUsername() | !validateEmail() | !validatePhone() | !validatePassword() | !validateConfpass())
    {
        return false;
    }

// get all the id values in String
    String name = regName.getText().toString();
    String username = regUsername.getText().toString();
    String email = regEmail.getText().toString();
    String phone = regPhone.getText().toString();
    String password = regPass.getText().toString();
    String confpass = regConfpass.getText().toString();

    return true;
}

// validation for name
private Boolean validateName(){
    String val = regName.getText().toString();

    if(val.isEmpty()){
        regName.setError("field cannot be empty");
        return false;
    }
    else {
        regName.setError(null);
//        regName.setErrorEnabled(false);
        return true;
    }

}

    // validation for username
    private Boolean validateUsername(){
        String val = regUsername.getText().toString();
        String noWhiteSpace = "^[a-z0-9_-]{3,15}$";

        if(val.isEmpty()){
            regUsername.setError("field cannot be empty");
            return false;
        }
        else if (val.length()>=15){
            regUsername.setError("username too long");
           return false;
        }
        else if (!val.matches(noWhiteSpace))
        {
            regUsername.setError("whitespace not allowed");
            return false;
        }
        else {
            regUsername.setError(null);
//            regName.setErrorEnabled(false);

            return true;
        }

    }



    // validation for email
    private Boolean validateEmail(){
        String val = regEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            regEmail.setError("field cannot be empty");
            return false;
        }else if(!val.matches(emailPattern)){
            regEmail.setError("invalid email address");
            return false;
        }
        else {
            regEmail.setError(null);
            return true;
        }

    }


    // validation for phone
    private Boolean validatePhone(){
        String val = regPhone.getText().toString();
        String valphone= "(0/91)?[7-9][0-9]{9}";

        if(val.isEmpty ()){
            regPhone.setError("field cannot be empty");
            return false;
        }else if (!val.matches(valphone)){
            regPhone.setError("plz write valid phone no. length");
            return false;
        }
        else {
            regPhone.setError(null);
            return true;
        }

    }

    // validation for password
    private Boolean validatePassword(){
        String val = regPass.getText().toString();
        String passwordVal= "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";


        if(val.isEmpty()){
            regPass.setError("field cannot be empty");
            return false;
        }else if (!val.matches(passwordVal)){
            regPass.setError("password is too weak");
            return false;
        }

        else {
            regPass.setError(null);
            return true;
        }

    }

    // validation for confirm password
    private Boolean validateConfpass(){
        String val = regPass.getText().toString();
        String val1= regConfpass.getText().toString();

        if(val.equals(val1)){
//            regConfpass.setError("password did not matched");
//            return false;
            regConfpass.setError(null);
            return true;
        }
        else {
//            regConfpass.setError(null);
//            return true;

            regConfpass.setError("password did not matched");
            return false;
        }

    }




}