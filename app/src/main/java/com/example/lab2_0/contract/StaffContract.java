package com.example.lab2_0.contract;

import android.provider.BaseColumns;

public class StaffContract {
    private StaffContract() {
    }

    public static class InfoEntry implements BaseColumns {
        public static final String TABLE_NAME = "staff";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_DEPARTMENT = "department";
        public static final String COLUMN_SALARY = "salary";
    }

    public static final String SQL_CREATE_ENTRIES = "create table " + InfoEntry.TABLE_NAME + " (" +
            InfoEntry.COLUMN_ID + "integer primary key autoincrement, " +
            InfoEntry.COLUMN_NAME + " text not null, " +
            InfoEntry.COLUMN_GENDER + " text not null, " +
            InfoEntry.COLUMN_DEPARTMENT + " text not null, " +
            InfoEntry.COLUMN_SALARY + " text not null";

    public static final String SQL_DELETE_ENTRIES = "delete table if exists " + InfoEntry.TABLE_NAME;
}
