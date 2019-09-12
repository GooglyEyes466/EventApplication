package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main3ActivityS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void onClick(View view){
        Intent intent = new Intent(Main3ActivityS.this, MainActivityS.class);
        startActivity(intent);
    }

    public void btnClick(View view){
        Intent intent = new Intent(Main3ActivityS.this, Main2ActivityS.class);
        startActivity(intent);
    }
}
