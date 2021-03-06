package com.example.benjamin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void createInit(View v){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void createCredits(MenuItem item) {
        Intent i = new Intent(this, Credits.class);
        startActivity(i);
    }


    public void prankToast(MenuItem item) {

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.toast));

        Toast toast = new Toast(this);
        toast.setView(view);
        toast.show();
    }
}