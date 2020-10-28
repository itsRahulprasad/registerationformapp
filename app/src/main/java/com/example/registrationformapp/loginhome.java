package com.example.registrationformapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginhome extends AppCompatActivity {
    //-----------mainactivity starts here---------

    //----- storing variable ------
    Button displayBtn;
    DatabaseHelper myDb;
    Button updateBtn;
    Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginhome);

        //--- taking var to store id value
        displayBtn= findViewById(R.id.displaybtn_loginhomepage);
        updateBtn=findViewById(R.id.updateBtn_loginhomepage);
        deleteBtn=findViewById(R.id.deleteBtn_loginhomepage);

        //-----taking database in variable
        myDb = new DatabaseHelper(this);

        //calling viewAll()
        viewAll();

        // -------updating button redirect ---------
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), updatepage.class));
            }
        });

        // -------updating button redirect ---------
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), deletepage.class));
            }
        });



    }


//------- displaying data in same page as alert box type---------
public void viewAll() {
        displayBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Cursor res = myDb.getAllData();
                       if(res.getCount() == 0) {
                           //show some message
                           showMessage("error", "nothing found");
                           return;
                       }

                       StringBuffer buffer = new StringBuffer();
                       while (res.moveToNext()) {
                           buffer.append("ID :"+ res.getString(0)+"\n");
                           buffer.append("NAME :"+ res.getString(1)+"\n");
                           buffer.append("USER_NAME :"+ res.getString(2)+"\n");
                           buffer.append("EMAIL_ID :"+ res.getString(3)+"\n");
                           buffer.append("PHONE_NO :"+ res.getString(4)+"\n");
                           buffer.append("PASSWORD :"+ res.getString(5)+"\n");
                           buffer.append("CNF_PASSWORD :"+ res.getString(6)+"\n\n");
                       }

                       //show all data
                        showMessage("Data", buffer.toString());
                    }
                }

        );
}

public void showMessage(String title, String Message){

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setCancelable(true);
    builder.setTitle(title);
    builder.setMessage(Message);
    builder.show();

    }
//------ display code ends here ------------


    //------ update code starts here -----------

//    public void UpdateData() {
//        updateBtn.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        boolean isUpdate = myDb.updateData()
//                    }
//                }
//        );
//    }




    //--------- update code emds here --------------







//------------------main activity ends here-----------------------
}