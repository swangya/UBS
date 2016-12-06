package com.example.swangya.ubs;

/**
 * Created by Swangya on 12/6/2016.
 */

//Database for Market
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;



public class Database extends SQLiteOpenHelper {

    public static Cursor userCursor;
    public static final String DATABASE_NAME="UBSdata.db";
    private static Database INSTANCE = null;

    private Context context;

    public static final String TRADE_TABLE_NAME = "TRADE_TABLE";
    public static final String KEY_ID = "id";
    public static final String COL_ITEMNAME = "ITEMNAME";
    public static final String COL_DESC = "DESC";
    public static final String COL_COST = "COST";
    public static final String COL_NUM = "NUM";
    public static final String COL_PIC = "PIC";
    public static final String COL_MAILID = "MAILID";

    private ArrayList<Item> items = new ArrayList<Item>();

    public Database(Context context){
        super(context, DATABASE_NAME, null, 1);
        this.context =context;
    }

    public static Database getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new Database(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private static final String CREATE_TABLE = "create table "+ TRADE_TABLE_NAME + " ("
            + KEY_ID + " integer primary key autoincrement, "
            + COL_PIC + " blob, "
            + COL_ITEMNAME + " Item name text, "
            + COL_DESC + " detail, "
            + COL_COST + " price, "
            + COL_MAILID + " mailID, "
            + COL_NUM + " number);";

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(CREATE_TABLE);
//        "CREATE TABLE " + TRADE_TABLE_NAME +"(ITID INTEGER PRIMARY KEY AUTOINCREMENT, ITEMNAME TEXT, COST TEXT, DESC TEXT," +
//                " MAILID TEXT, NUM TEXT, PIC BLOB)"

    }



    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TRADE_TABLE_NAME);
        onCreate(DB);
    }

    public boolean insertMarket(String name, String price, String detail, String email, String num, byte[] pic){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ITEMNAME, name);
        contentValues.put(COL_COST, price);
        contentValues.put(COL_DESC, detail);
        contentValues.put(COL_MAILID, email);
        contentValues.put(COL_NUM, num);
        contentValues.put(COL_PIC, pic);

        Item item = new Item();
        item.setItemname(name);
        item.setPrice(price);
        item.setDesc(detail);
        item.setMail(email);
        item.setPhone(num);
        item.setPhoto(pic);
        items.add(item);
        long result = DB.insert(TRADE_TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        }
        else
        {return true;}
    }

    public ArrayList<Item> returnItem() {return items;}
}
