package com.example.lab2_0.helper;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab2_0.contract.StaffContract;

public class MyProvider extends ContentProvider {

    private Context mContext;
    private MyDBHelper myDBHelper;
    SQLiteDatabase db = null;
    public static final String IDENTIFIER = "com.example.lab2_0.myprovider";

    public static final int Staff_Code = 1;

    private static final UriMatcher mMatcher;
    static {
        mMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        mMatcher.addURI(IDENTIFIER, StaffContract.InfoEntry.TABLE_NAME, Staff_Code);
    }

    @Override
    public boolean onCreate() {
        mContext = getContext();
        myDBHelper = new MyDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        String table = getTableName(uri);

        return db.query(table, projection, selection, selectionArgs, sortOrder, null, "desc");
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        String table= getTableName(uri);

        db.insert(table, null, values);
        mContext.getContentResolver().notifyChange(uri, null);

        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        String table= getTableName(uri);
        db.delete(table, selection, selectionArgs);

        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        String table= getTableName(uri);
        db.update(table, values, selection, selectionArgs);

        return 0;
    }

    private String getTableName(Uri uri) {
        String tableName = null;
        if (mMatcher.match(uri) == Staff_Code) {
            tableName = StaffContract.InfoEntry.TABLE_NAME;
        }
        return tableName;
    }
}
