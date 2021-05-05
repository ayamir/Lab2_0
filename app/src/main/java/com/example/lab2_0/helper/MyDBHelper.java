package com.example.lab2_0.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.lab2_0.contract.StaffContract;

import static com.example.lab2_0.contract.StaffContract.SQL_CREATE_ENTRIES;
import static com.example.lab2_0.contract.StaffContract.SQL_DELETE_ENTRIES;

public class MyDBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "test.db";

    public MyDBHelper(@Nullable Context context) {
        super(context, StaffContract.InfoEntry.TABLE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
