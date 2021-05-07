package com.example.lab2_0.contract;

import android.content.ContentValues;
import android.provider.BaseColumns;

public class StaffContract {
    private StaffContract() {
    }

    public static class InfoEntry implements BaseColumns {
        public static final String TABLE_NAME = "staff";
        public static final String COLUMN_PK = "pk";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_DEPARTMENT = "department";
        public static final String COLUMN_SALARY = "salary";
    }

    public static final String SQL_CREATE_ENTRIES = "create table " + InfoEntry.TABLE_NAME + " (" +
            InfoEntry.COLUMN_PK + " integer primary key autoincrement, " +
            InfoEntry.COLUMN_ID + " text not null, " +
            InfoEntry.COLUMN_NAME + " text not null, " +
            InfoEntry.COLUMN_GENDER + " text not null, " +
            InfoEntry.COLUMN_DEPARTMENT + " text not null, " +
            InfoEntry.COLUMN_SALARY + " text not null )";

    public static final String SQL_DELETE_ENTRIES = "delete table if exists " + InfoEntry.TABLE_NAME;

    public static ContentValues getSqlInsert(String id, String name, String gender, String department, String salary) {
        ContentValues cv = new ContentValues();
        cv.put(InfoEntry.COLUMN_ID, id);
        cv.put(InfoEntry.COLUMN_NAME, name);
        cv.put(InfoEntry.COLUMN_GENDER, gender);
        cv.put(InfoEntry.COLUMN_DEPARTMENT, department);
        cv.put(InfoEntry.COLUMN_SALARY, salary);
        return cv;
    }
}
