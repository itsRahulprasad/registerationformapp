package com.example.registrationformapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deletepage extends AppCompatActivity {

    //----- storing variable ------
    EditText delete_id;
    DatabaseHelper myDb;
    Button deleteidBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletepage);


        //--- taking var to store id value
        deleteidBtn=findViewById(R.id.deleteidBtn_deletepage);
        delete_id= findViewById(R.id.id_deletepage);

        //-----taking database in variable
        myDb = new DatabaseHelper(this);

        //---calling function
        DeleteData();

    }

    public void DeleteData() {
        deleteidBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(delete_id.getText().toString());
                        if(deletedRows > 0){

                            Toast.makeText(deletepage.this, "data is deleted", Toast.LENGTH_LONG).show();
                        }
                       else {
                            Toast.makeText(deletepage.this, "data not deleted", Toast.LENGTH_LONG).show();
                        }
                    }
                }

        );

    }


}