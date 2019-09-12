package com.example.eventapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileUserTR extends AppCompatActivity {
    TextView txtName, txtUsername, txtEmail, txtCity, txtPhone;
    Button btnEdit, btnDelete;
    AppUsers users = (AppUsers)getIntent().getSerializableExtra("usersData");
    String usersId = getIntent().getStringExtra("userId");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user_tr);



        txtName = findViewById(R.id.pname);
        txtUsername = findViewById(R.id.pusername);
        txtEmail = findViewById(R.id.pemail);
        txtPhone = findViewById(R.id.pphone);
        txtCity = findViewById(R.id.pcity);

        btnEdit = findViewById(R.id.btnEdittr);
        btnDelete = findViewById(R.id.btnDeltr);


        DatabaseReference showRef = FirebaseDatabase.getInstance().getReference().child("AppUsers").child(usersId);
        showRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    txtName.setText(dataSnapshot.child("name").getValue().toString());
                    txtUsername.setText(dataSnapshot.child("username").getValue().toString());
                    txtEmail.setText(dataSnapshot.child("email").getValue().toString());
                    txtCity.setText(dataSnapshot.child("city").getValue().toString());
                    txtPhone.setText(dataSnapshot.child("phone").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),"No source to Display",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    public void editUser(View view)
    {
        Intent intent = new Intent(this, EditProfileTR.class);
        intent.putExtra("usersData",users);
        intent.putExtra("userId",usersId);
        startActivity(intent);
    }

    public void deleteUser(View view){
        Intent intent = new Intent(this , DeleteUserTR.class);
        intent.putExtra("usersData",users);
        intent.putExtra("userId",usersId);
        startActivity(intent);
    }

}
