package com.example.murtuza.feeder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Murtuza on 17-01-2017.
 */

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "URL.db";
    public static final String TABLE_NAME = "LINKS";
    public static final String TABLE_2 = "SAVED";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "URL";
    public static final String COL_3 = "CATEGORY";
    public static final String COL1="ID";
    public static final String COL2 = "TITLE";
    public static final String COL3 = "IMAGEURL";
    public static final String COL4 = "LINK";



    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY,URL TEXT,CATEGORY TEXT)");
        db.execSQL("create table " + TABLE_2 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,IMAGEURL TEXT,LINK TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_2);
        onCreate(db);
    }

    public boolean insertData(String id,String url,String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,url);
        contentValues.put(COL_3,category);
        long result = db.insert(TABLE_NAME, null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select distinct * from "+TABLE_NAME,null);
        return res;
    }


    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
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
        Cursor res = db.rawQuery("select * from "+TABLE_2,null);
        return res;
    }
    public Integer deleteData2 (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_2, "ID = ?",new String[] {id});
    }
}
