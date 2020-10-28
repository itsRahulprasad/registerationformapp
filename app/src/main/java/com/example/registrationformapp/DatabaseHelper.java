package com.example.registrationformapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// CREATING DATABASE REGISTER.DB
public class DatabaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public static final String Database_name = "register.db";
    public static final String TABLE_NAME = "register_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "USER_NAME";
    public static final String COL_4 = "EMAIL_ID";
    public static final String COL_5 = "PHONE_NO";
    public static final String COL_6 = "PASSWORD";
    public static final String COL_7 = "CNF_PASSWORD";

    public DatabaseHelper (Context context) {
        super(context, Database_name, null , 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, USER_NAME TEXT, EMAIL_ID TEXT , PHONE_NO LONG , PASSWORD TEXT , CNF_PASSWORD TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String user_name, String email_id, String phone_no, String password, String cnf_password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,user_name);
        contentValues.put(COL_4,email_id);
        contentValues.put(COL_5,phone_no);
        contentValues.put(COL_6,password);
        contentValues.put(COL_7,cnf_password);
       long result = db.insert(TABLE_NAME,null,contentValues);
       if (result == -1){
           return false;
       }
    else
        return true;
    }

}
