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
        Button btn_hw=(Button)findViewById(R.id.button);
        odsl = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Button btn_hello = (Button) findViewById(R.id.button);
                btn_hello.setText(dpd.getDatePicker().getYear()+" "+dpd.getDatePicker().getMonth()+" "+dpd.getDatePicker().getDayOfMonth());
            }
        };

        dpd = new DatePickerDialog(this, odsl, 2016 , 11 , 14);


    }
    public void createInit(View v){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }


    public void datePick(View v){
        /*dpd.show();
        NotificationCompat.Builder builder= (NotificationCompat.Builder) new  NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.notif))
                .setContentText("aianr aiurairn");
        NotificationManager nm =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(NOTIF_ID,builder.build());*/
    }
}