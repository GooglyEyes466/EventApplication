package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class LoginTR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_tr);
    }

    public void logAsUser(View view) {
        Intent intent = new Intent(this, Main4ActivityS.class);;
        startActivity(intent);

    }

    public void logAsProvider(View view){
        Intent intent = new Intent(this, ServiceProviderUI.class);
        startActivity(intent);


    }
}
