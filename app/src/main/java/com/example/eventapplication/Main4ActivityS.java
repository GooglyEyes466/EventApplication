package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main4ActivityS extends AppCompatActivity {
    Button btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    public void onaddClick(View view ){
        Intent intent = new Intent(Main4ActivityS.this, MainActivityS.class);
        startActivity(intent);
    }

    public void onallClick(View view ){
        Intent intent = new Intent(Main4ActivityS.this, Main3ActivityS.class);
        startActivity(intent);
    }

    public void onlogClick(View view ){
        Intent intent = new Intent(this , LoginTR.class);
        startActivity(intent);
        Context context = getApplicationContext();
        CharSequence text = "You are now logged out!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void onFeedback(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onProf(View view){
        Intent intent = new Intent(this, ProfileUserTR.class);
        AppUsers users = (AppUsers)getIntent().getSerializableExtra("usersData");
        String usersId = getIntent().getStringExtra("userId");

        intent.putExtra("usersData",users);
        intent.putExtra("userId",usersId);
        startActivity(intent);
    }
}
