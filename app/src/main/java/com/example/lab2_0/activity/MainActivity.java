package com.example.lab2_0.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2_0.R;
import com.example.lab2_0.adapter.TableRowAdapter;
import com.example.lab2_0.bean.TableRow;
import com.example.lab2_0.contract.StaffContract;
import com.example.lab2_0.helper.MyDBHelper;

import java.util.ArrayList;

import static com.example.lab2_0.contract.StaffContract.InfoEntry.TABLE_NAME;
import static com.example.lab2_0.contract.StaffContract.getSqlInsert;

public class MainActivity extends AppCompatActivity {
    public final static String prefName = "data";
    public final static String isInitializedString = "isInitialized";
    public final static String bgColorString = "bgColor";
    public final static String fontColorString = "fontColor";
    public final static String fontSizeString = "fontSize";

    private final MyDBHelper myDBHelper = new MyDBHelper(this);
    private SharedPreferences pref;
    private final ArrayList<TableRow> tableRows = new ArrayList<>();
    private boolean isInitialized;
    private String bgColor;
    private String fontColor;
    private int fontSize;

    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.main_layout);

        readSettings();
        initializeDB();
        applySettings();

        readFromDB();
        bindItems();
    }

    private void initializeDB() {
        if (!isInitialized) {
            SQLiteDatabase db = myDBHelper.getWritableDatabase();
            db.insert(StaffContract.InfoEntry.TABLE_NAME, null, getSqlInsert("1", "Tom", "male", "computer", "5400"));
            db.insert(StaffContract.InfoEntry.TABLE_NAME, null, getSqlInsert("2", "Einstein", "male", "computer", "4800"));
            db.insert(StaffContract.InfoEntry.TABLE_NAME, null, getSqlInsert("3", "Lily", "female", "market", "5000"));
            db.insert(StaffContract.InfoEntry.TABLE_NAME, null, getSqlInsert("4", "Warner", "male", "market", ""));
            db.insert(StaffContract.InfoEntry.TABLE_NAME, null, getSqlInsert("5", "Napoleon", "male", "", ""));

            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean(isInitializedString, true);
            editor.apply();
        }
    }

    private void readSettings() {
        final String TAG = "readSettings";
        pref = getSharedPreferences(prefName, MODE_PRIVATE);
        isInitialized = pref.getBoolean(isInitializedString, false);
        bgColor = pref.getString(bgColorString, "white");
        fontColor = pref.getString(fontColorString, "black");
        fontSize = pref.getInt(fontSizeString, 18);

        Log.d(TAG, "readSettings: bgColor = " + bgColor);
        Log.d(TAG, "readSettings: fontColor = " + fontColor);
        Log.d(TAG, "readSettings: fontSize = " + fontSize);
    }

    void bindItems() {
        LinearLayoutManager staffInfoLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        TableRowAdapter tableRowAdapter = new TableRowAdapter(tableRows);
        RecyclerView rvTableRow = findViewById(R.id.rv_table_row);
        rvTableRow.setLayoutManager(staffInfoLayoutManager);
        rvTableRow.setAdapter(tableRowAdapter);

        Button btnSettings = findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });

    }

    private void applySettings() {
        mainLayout.setBackgroundColor(Color.parseColor(bgColor));
    }

    private void readFromDB() {
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, "id asc", null);
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String gender = cursor.getString(cursor.getColumnIndex("gender"));
                String department = cursor.getString(cursor.getColumnIndex("department"));
                String salary = cursor.getString(cursor.getColumnIndex("salary"));
                tableRows.add(new TableRow(id, name, gender, department, salary));
            } while (cursor.moveToNext());
        }

        cursor.close();
    }
}