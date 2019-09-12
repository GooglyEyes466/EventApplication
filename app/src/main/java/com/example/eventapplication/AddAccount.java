package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
    }
    public void onClick(View view){
        Intent intent = new Intent(this, ServiceProviderUI.class);
        startActivity(intent);
    }
}
