package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithDataActivity extends AppCompatActivity {
    public static String EXTRA_NPM = "extra_npm";
    public static String EXTRA_NAME = "extra_name";
    private TextView tvDataReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);
        tvDataReceived = (TextView)findViewById(R.id.tv_data_received);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int npm = getIntent().getIntExtra(EXTRA_NPM, 0);
        String text = "Nama : "+name+"\nNPM   : "+npm;
        tvDataReceived.setText(text);
    }
}