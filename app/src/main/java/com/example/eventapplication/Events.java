package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
    }
     public void onDecline(View view){
        Toast.makeText( Events.this,"Event Request Declined",Toast.LENGTH_LONG).show();
    }

    public void onAccept(View view){
        Toast.makeText(Events.this,"Event Request Accepted",Toast.LENGTH_LONG).show();
    }
}
