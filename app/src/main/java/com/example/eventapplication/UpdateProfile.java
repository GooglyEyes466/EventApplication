package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UpdateProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
    }

    public void Update(View view){
        Intent intent = new Intent(this, SaveChanges.class);
        startActivity(intent);
    }

    public void onDelete(View view){
        Intent intent = new Intent(this, MainActivityTR.class);
        startActivity(intent);

        Context context = getApplicationContext();
        CharSequence text = "Successfully Deleted Account!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
