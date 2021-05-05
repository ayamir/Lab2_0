package com.example.lab2_0.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.lab2_0.R;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
    private String bgColor;
    private String fgColor;
    private String fontColor;
    private int fontSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readSettings();
    }

    void readSettings() {
        final String TAG = "readSettings";
        bgColor = pref.getString("bgColor", "white");
        fgColor = pref.getString("fgColor", "white");
        fontColor = pref.getString("fontColor", "black");
        fontSize = pref.getInt("fontSize", 18);

        Log.d(TAG, "readSettings: bgColor = " + bgColor);
        Log.d(TAG, "readSettings: fgColor = " + fgColor);
        Log.d(TAG, "readSettings: fontColor = " + fontColor);
        Log.d(TAG, "readSettings: fontSize = " + fontSize);
    }

}