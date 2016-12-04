package com.example.swangya.ubs;

/**
 * Created by Swangya on 12/2/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import static android.R.attr.id;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Register.db";
    private static final String TABLE_NAME = "register_table";
    private static final String USER_NUM = "USERNUM";
    private static final String FIRST_NAME = "FIRSTNAME";
    private static final String LAST_NAME = "LASTNAME";
    private static final String ID = "ID";
    private static final String DOB = "DOB";
    private static final String PASSWORD = "PASSWORD";
    private static final String RETYPEPASSWORD = "RETYPEPASSWORD";
    private static final String TYPE = "TYPE";
    private static final String SECURITY_QUESTION1 = "QUESTIONI";
    private static final String SECURITY_QUESTION2 = "QUESTIONII";
    private static final String SECURITY_QUESTION3 = "QUESTIONIII";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +  TABLE_NAME + " (USERNUM INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, ID TEXT, DOB TEXT, PASSWORD TEXT, RETYPEPASSWORD TEXT, TYPE TEXT, QUESTIONI TEXT, QUESTIONII TEXT, QUESTIONIII TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String firstname, String lastname, String Id, String dob, String password, String repassword, String type, String q1, String q2, String q3)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(FIRST_NAME, firstname);
        contentValues.put(LAST_NAME, lastname);
        contentValues.put(ID, Id);
        contentValues.put(DOB, dob);
        contentValues.put(PASSWORD, password);
        contentValues.put(RETYPEPASSWORD, repassword);
        contentValues.put(TYPE, type);
        contentValues.put(SECURITY_QUESTION1, q1);
        contentValues.put(SECURITY_QUESTION2, q2);
        contentValues.put(SECURITY_QUESTION3, q3);
        long result= db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;

    }
    public Cursor getData()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME, null);
        return res;
    }

}
