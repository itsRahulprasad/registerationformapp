package com.example.registrationformapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // -----------------main activity started here--------------------------------

    // deifine edittext, button etc in variable
    Button login_var;
    Button reg_var;
    EditText regName;
    EditText regUsername;
    EditText regEmail;
    EditText regPhone;
    EditText regPass;
    EditText regConfpass;

//-- databases instance
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // -------button fetching ad storing them in varaible
        login_var = findViewById(R.id.loginBtn);
        reg_var = findViewById(R.id.regBtn);

        //------------finding finding id and storing them in varaible
        regName = findViewById(R.id.name_id);
        regUsername = findViewById(R.id.username_id);
        regEmail = findViewById(R.id.email_id);
        regPhone = findViewById(R.id.phone_id);
        regPass = findViewById(R.id.pass_id);
        regConfpass = findViewById(R.id.confpass_id);


        //-----taking database, variable
        myDb = new DatabaseHelper(this);



    //---------redirecting login button click to login page {.'. here onclick button event = setOnClickListener}
        login_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), loginpage.class));
            }
        });

    }


    //------helper class to add or insert data in database
    public void  AddData(){
                   boolean isInserted = myDb.insertData(
                               regName.getText().toString(),
                               regUsername.getText().toString(),
                               regEmail.getText().toString(),
                               regPhone.getText().toString(),
                               regPass.getText().toString(),
                               regConfpass.getText().toString()
                               );

                   if (isInserted == true) {
                       Toast.makeText(MainActivity.this, "data inserted", Toast.LENGTH_LONG).show();
                   }
                       else {
                       Toast.makeText(MainActivity.this, "data not inserted", Toast.LENGTH_LONG).show();
                   }

    }

    //-----------checking all validation is success or not by submitvalidate() function
    private boolean submitvalidate(){

        //--------- get all the id values in String
        String name = regName.getText().toString();
        String username = regUsername.getText().toString();
        String email = regEmail.getText().toString();
        String phone = regPhone.getText().toString();
        String password = regPass.getText().toString();
        String confpass = regConfpass.getText().toString();

        //---------- checking if validation is done successfully or not , if yes submit or register or if not data not inserted
        if(!validateName() | !validateUsername() | !validateEmail() | !validatePhone() | !validatePassword() | !validateConfpass())
        {
            return false;
        }
        return true;
    }

    //-------------------registerUser function for regiter button and it was defined in register button as onclick registerUser
    //-----------------checking whether register button validates or not
    public void registerUser (View view){
        submitvalidate();
        if (!submitvalidate()){
            Toast.makeText(this, "sibmission fail", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "register success", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), loginpage.class));
            AddData();

        }
    }


//---------------------- validation for name
private Boolean validateName(){
    String val = regName.getText().toString();

    if(val.isEmpty()){
        regName.setError("field cannot be empty");
        return false;
    }
    else {
        regName.setError(null);
        return true;
    }

}

    //----------------- validation for username
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
            return true;
        }
    }



    //------------------------- validation for email
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


    // --------------------------validation for phone
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

    //------------------------------ validation for password
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

    // ------------------ validation for confirm password
    private Boolean validateConfpass(){
        String val = regPass.getText().toString();
        String val1= regConfpass.getText().toString();

        if(val.equals(val1)){
            regConfpass.setError(null);
            return true;
        }
        else {
            regConfpass.setError("password did not matched");
            return false;
        }

    }



//main activity ends here----------------------------------------------------
}