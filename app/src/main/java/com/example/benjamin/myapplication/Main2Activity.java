package com.example.benjamin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn_svc = (Button) findViewById(R.id.button2);
    }

    public void createServices(View v){
    GetBiersServices.startActionGetAllBiers(this);
    }

}
