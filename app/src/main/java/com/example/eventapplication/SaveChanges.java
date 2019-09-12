package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SaveChanges extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_changes);
    }
    public void onClick(View view){
        Toast.makeText(SaveChanges.this,"Update Successful",Toast.LENGTH_LONG).show();
    }
}
