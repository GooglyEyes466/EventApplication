package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivityS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_s);
    }
    public void onClick(View view){
        Toast.makeText(MainActivityS.this,"Successful!!!", Toast.LENGTH_LONG).show();
    }
}
