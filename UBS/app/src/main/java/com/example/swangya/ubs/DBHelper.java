package com.example.swangya.ubs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {

    public static Cursor userCursor;

    public static final String DATABASE_NAME = "ubsdb.db";


    public static final String CLUB_TABLE_NAME = "club_table";
    public static final String COL_11 = "CLUB_NAME";
    public static final String COL_12 = "ADMIN";
    public static final String COL_14 = "FUNCTION";


    private static DBHelper INSTANCE = null;
    private Context context;


    private ArrayList<Club> clubs = new ArrayList<Club>();


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;

    }

    public static DBHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE " + CLUB_TABLE_NAME + "(CID INTEGER PRIMARY KEY AUTOINCREMENT, CLUB_NAME TEXT, ADMIN TEXT, " +
                "FUNCTION TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + CLUB_TABLE_NAME);

        onCreate(db);
    }

    public boolean insertClubData(String cname,String admin,String func) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_11,cname);
        contentValues.put(COL_12,admin);
        contentValues.put(COL_14,func);

        Club club=new Club();
        club.setCname(cname);
        club.setAdmin(admin);
        club.setFunction(func);
        clubs.add(club);
        long result = db.insert(CLUB_TABLE_NAME, null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Integer deleteClubData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(CLUB_TABLE_NAME, "CID = ?",new String[] {id});
    }

    public Cursor getClubAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ CLUB_TABLE_NAME,null);
        return res;
    }

    public ArrayList<Club> returnClub(){
        return clubs;
    }


}
