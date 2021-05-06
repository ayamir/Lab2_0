package com.example.lab2_0.activity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2_0.R;
import com.example.lab2_0.adapter.TableRowAdapter;
import com.example.lab2_0.bean.TableRow;
import com.example.lab2_0.helper.MyDBHelper;

import java.util.ArrayList;

import static com.example.lab2_0.contract.StaffContract.InfoEntry.TABLE_NAME;

public class MainActivity extends AppCompatActivity {
    public final static String prefName = "data";
    public final static String bgColorString = "bgColor";
    public final static String fontColorString = "fontColor";
    public final static String fontSizeString = "fontSize";

    private final MyDBHelper myDBHelper = new MyDBHelper(this);
    private final SharedPreferences pref = getSharedPreferences(prefName, MODE_PRIVATE);
    private final ArrayList<TableRow> tableRows = new ArrayList<>();
    private String bgColor;
    private String fontColor;
    private int fontSize;

    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readSettings();
        applySettings();

        readFromDB();
        bindItems();
    }

    void readSettings() {
        final String TAG = "readSettings";
        bgColor = pref.getString(bgColorString, "white");
        fontColor = pref.getString(fontColorString, "black");
        fontSize = pref.getInt(fontSizeString, 18);

        Log.d(TAG, "readSettings: bgColor = " + bgColor);
        Log.d(TAG, "readSettings: fontColor = " + fontColor);
        Log.d(TAG, "readSettings: fontSize = " + fontSize);
    }

    void bindItems() {
        mainLayout = findViewById(R.id.main_layout);
        LinearLayoutManager staffInfoLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        TableRowAdapter tableRowAdapter = new TableRowAdapter(tableRows);
        RecyclerView rvTableRow = findViewById(R.id.rv_table_row);
        rvTableRow.setLayoutManager(staffInfoLayoutManager);
        rvTableRow.setAdapter(tableRowAdapter);

    }

    void applySettings() {
        mainLayout.setBackgroundColor(Color.parseColor(bgColor));


    }

    void readFromDB() {
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