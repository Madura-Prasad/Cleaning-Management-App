package com.example.cleany.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.ByteArrayOutputStream;

public class datahandler {
    private Context con;
    private dbconnector dbCon;
    private SQLiteDatabase db;
    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInBytes;

    public datahandler (Context con) {
        this.con = con;
    }

    public void openDB() {
        this.dbCon = new dbconnector(con);
        this.db = dbCon.getWritableDatabase();
    }

    //HouseOwner
    public void houseowner_Create(houseOwner houseowner) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("FullName", houseowner.getFull_Name());
        contentValues.put("Age", houseowner.getAge());
        contentValues.put("MobileNumber", houseowner.getMobile_number());
        contentValues.put("Residence", houseowner.getResidence());
        contentValues.put("Email", houseowner.getEmail());
        contentValues.put("Password", houseowner.getPassword());
        contentValues.put("Repeat_Password", houseowner.getRepeat_Password());
        db.insert("HouseOwner", null, contentValues);
    }

    //Cleaner
    public void cleaner_Create(cleaner cleaner) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("FullName", cleaner.getFullName());
        contentValues.put("Age", cleaner.getNIC());
        contentValues.put("MobileNumber", cleaner.getMobile());
        contentValues.put("Residence", cleaner.getAddress());
        contentValues.put("Email", cleaner.getEmail());
        contentValues.put("Password", cleaner.getPassword());
        contentValues.put("Repeat_Password", cleaner.getConfirm_Password());
        db.insert("cleaner", null, contentValues);
    }

    //Review
    public void Review_Create(Rate rate) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", rate.getName());
        contentValues.put("Review", rate.getReview());
        db.insert("Review", null, contentValues);
    }

    //Review
    public void ApplyJob_Create(Apply apply) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Address", apply.getAddress());
        contentValues.put("Price", apply.getPrice());
        contentValues.put("Name", apply.getName());
        db.insert("ApplyJob", null, contentValues);
    }

    //Review
    public void AddReview_Create(AddReview rate) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Review", rate.getReview());
        db.insert("AddReview", null, contentValues);
    }


    //Check Login Record Database Customer
    public boolean checkLogin (String email, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM houseowner  WHERE Email=? and Password=?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    //Check Login Record Database Customer
    public boolean checkcleanerLogin (String email, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM cleaner  WHERE Email=? and Password=?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


}
