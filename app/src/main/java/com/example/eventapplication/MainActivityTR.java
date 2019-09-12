package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivityTR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tr);

    }
    public void goToCreate(View view){
        Intent intent = new Intent(this, Create_AccountTR.class);
        startActivity(intent);
    }

    public void goToLogin(View view){
        Intent intent = new Intent (this, LoginTR.class);
        startActivity(intent);
    }
}
