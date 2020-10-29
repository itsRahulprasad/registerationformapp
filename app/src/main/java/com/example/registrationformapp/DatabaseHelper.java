package com.example.registrationformapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//------------ CREATING DATABASE REGISTER.DB
public class DatabaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    //------- declaring all databses related field in var -------
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

    //------- creating table with its field -----
    //========== data for main activity and main.xml ==========
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, USER_NAME TEXT, EMAIL_ID TEXT , PHONE_NO LONG , PASSWORD TEXT , CNF_PASSWORD TEXT)");

    }

    //---------- checking table is already present or not----------
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    //------- inserting data in table through fieldvalues by user ---------
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
//====== data for main activity ends here ==============




  //--------- displaying data in login homepage------
    //========== data for login home starts here ===========
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+"register_table",null);
        return res;

    }
    //========== data for login home ends here ===========


    // ========= updating database start here ---------------
    public boolean updateData(String id, String name, String user_name, String email_id, String phone_no, String password, String cnf_password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,user_name);
        contentValues.put(COL_4,email_id);
        contentValues.put(COL_5,phone_no);
        contentValues.put(COL_6,password);
        contentValues.put(COL_7,cnf_password);
        db.update(TABLE_NAME,contentValues, "id=?",new  String[] { id } );
        return true;
    }
    // ========= updating database ends here ---------------


    // ========= deleting database starts here ---------------
    public  Integer deleteData (String id ){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[] {id} );

    }


    // ========= deleting database ends here ---------------

//===== login checking=====
    public Boolean checkuserexist (String email_id , String phone_no){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + "register_table" + " where email_id = ? and phone_no = ? ", new String[]{ email_id,phone_no });
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
//
    public Boolean checkusernamepassword(String email_id, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + "register_table" + " where email_id = ? and password = ? ", new String[] {email_id,password });
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }



}
