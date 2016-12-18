package com.example.benjamin.myapplication;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DatePickerDialog dpd= null;
    private DatePickerDialog.OnDateSetListener odsl;
    private static final int NOTIF_ID=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void createInit(View v){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

}