package com.example.lab2_0.helper;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.lab2_0.contract.StaffContract;

public class MyContentProvider extends ContentProvider {
    public static final int STAFF_CODE = 1;
    static UriMatcher mMatcher;

    static {
        mMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mMatcher.addURI(StaffContract.InfoEntry.AUTHORITY, StaffContract.InfoEntry.TABLE_NAME, STAFF_CODE);
    }

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String table = getTableName(uri);
        return mDatabase.delete(table, selection, selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String table = getTableName(uri);

        mDatabase.insert(table, null, values);
        mContext.getContentResolver().notifyChange(uri, null);

        return uri;
    }

    @Override
    public boolean onCreate() {
        mContext = getContext();
        MyDBHelper myDBHelper = new MyDBHelper(mContext);
        mDatabase = myDBHelper.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        String table = getTableName(uri);

        return mDatabase.query(table, projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        String table = getTableName(uri);
        return mDatabase.update(table, values, selection, selectionArgs);
    }

    private String getTableName(Uri uri) {
        String tableName = null;
        if (mMatcher.match(uri) == STAFF_CODE) {
            tableName = StaffContract.InfoEntry.TABLE_NAME;
        }
        return tableName;
    }
}