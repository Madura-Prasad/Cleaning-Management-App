package com.example.cleany.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbconnector extends SQLiteOpenHelper {


    public dbconnector(@Nullable Context context) {
        super(context, "Cleany", null, 1);;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE HouseOwner (id INTEGER PRIMARY KEY AUTOINCREMENT,FullName text,Age text,MobileNumber text, Residence text,Email text,Password text,Repeat_Password text)");
        db.execSQL("CREATE TABLE cleaner (id INTEGER PRIMARY KEY AUTOINCREMENT,FullName text,Age text,MobileNumber text, Residence text,Email text,Password text,Repeat_Password text)");
        db.execSQL("CREATE TABLE Adz (id INTEGER PRIMARY KEY AUTOINCREMENT,Rooms text,Bathrooms text,Flooring text,Storeys text,Location text,Contact text,Price text,Image Blob)");
        db.execSQL("CREATE TABLE Review (id INTEGER PRIMARY KEY AUTOINCREMENT,Name text,Review text)");
        db.execSQL("CREATE TABLE AddReview (id INTEGER PRIMARY KEY AUTOINCREMENT,Review text)");
        db.execSQL("CREATE TABLE ApplyJob (id INTEGER PRIMARY KEY AUTOINCREMENT,Address text,Price text,Name text)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS HouseOwner");
        db.execSQL("DROP TABLE IF EXISTS cleaner");
        db.execSQL("DROP TABLE IF EXISTS Adz");
        db.execSQL("DROP TABLE IF EXISTS Review");
        db.execSQL("DROP TABLE IF EXISTS AddReview");
        db.execSQL("DROP TABLE IF EXISTS ApplyJob");


    }
}
