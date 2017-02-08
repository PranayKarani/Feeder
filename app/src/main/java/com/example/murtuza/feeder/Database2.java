package com.example.murtuza.feeder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Murtuza on 08-02-2017.
 */

public class Database2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "SAVED.db";

    public static final String TABLE_2 = "SAVED";

    public static final String COL1="ID";
    public static final String COL2 = "TITLE";
    public static final String COL3 = "IMAGEURL";
    public static final String COL4 = "LINK";



    public Database2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY,URL TEXT,CATEGORY TEXT)");
        db.execSQL("create table " + TABLE_2 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,IMAGEURL TEXT,LINK TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_2);
        onCreate(db);
    }


    public boolean insert2(String title,String imageurl,String link) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,title);
        contentValues.put(COL3,imageurl);
        contentValues.put(COL4,link);
        long result = db.insert(TABLE_2, null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select distinct * from "+TABLE_2,null);
        return res;
    }
    public Integer deleteData2 (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_2, "ID = ?",new String[] {id});
    }
}


