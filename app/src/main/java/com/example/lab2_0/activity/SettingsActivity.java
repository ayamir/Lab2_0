package com.example.lab2_0.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_0.R;

import static com.example.lab2_0.activity.MainActivity.bgColorString;
import static com.example.lab2_0.activity.MainActivity.fontColorString;
import static com.example.lab2_0.activity.MainActivity.fontSizeString;
import static com.example.lab2_0.activity.MainActivity.prefName;

public class SettingsActivity extends AppCompatActivity {
    private String bgColor;
    private String fontSize;
    private String fontColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

        Button btnApply = findViewById(R.id.btn_apply);
        btnApply.setOnClickListener(v -> {
            SharedPreferences.Editor editor = getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
            editor.putString(bgColorString, bgColor);
            editor.putString(fontColorString, fontColor);
            editor.putString(fontSizeString, fontSize);
            editor.apply();
        });

        Spinner bgColorSpinner = findViewById(R.id.bg_color_spinner);
        bgColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString().trim();
                switch (selected) {
                    case "黑色":
                        bgColor = "black";
                        break;
                    case "白色":
                        bgColor = "white";
                        break;
                    case "红色":
                        bgColor = "red";
                        break;
                    case "绿色":
                        bgColor = "green";
                        break;
                    case "蓝色":
                        bgColor = "blue";
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner fontSizeSpinner = findViewById(R.id.font_size_spinner);
        fontSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fontSize = parent.getItemAtPosition(position).toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner fontColorSpinner = findViewById(R.id.font_color_spinner);
        fontColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString().trim();
                switch (selected) {
                    case "黑色":
                        fontColor = "black";
                        break;
                    case "白色":
                        fontColor = "white";
                        break;
                    case "红色":
                        fontColor = "red";
                        break;
                    case "绿色":
                        fontColor = "green";
                        break;
                    case "蓝色":
                        fontColor = "blue";
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}