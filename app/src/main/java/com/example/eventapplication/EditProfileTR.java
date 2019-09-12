package com.example.eventapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfileTR extends AppCompatActivity {
    EditText editEname, editEmail, editEphone, editEcity, editEpass, editEconPass;
    Button btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_tr);



        editEname = findViewById(R.id.uname);
        editEmail = findViewById(R.id.uemail);
        editEphone = findViewById(R.id.uphone);
        editEcity = findViewById(R.id.ucity);
        editEpass = findViewById(R.id.upassword);
        editEconPass = findViewById(R.id.uconpassword);

        btnEdit = findViewById(R.id.btnEditTr);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("AppUsers");

                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        AppUsers users = (AppUsers) getIntent().getSerializableExtra("usersData");
                        String usersId = getIntent().getStringExtra("userId");

                        if (dataSnapshot.hasChild(usersId)) {
                            try{
                                if (TextUtils.isEmpty(editEname.getText().toString()))
                                     Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
                                else if (TextUtils.isEmpty(editEmail.getText().toString()))
                                    Toast.makeText(getApplicationContext(), "Please enter your email", Toast.LENGTH_SHORT).show();
                                else if (TextUtils.isEmpty(editEcity.getText().toString()))
                                    Toast.makeText(getApplicationContext(), "Please enter a city", Toast.LENGTH_SHORT).show();
                                else if (TextUtils.isEmpty(editEpass.getText().toString()))
                                    Toast.makeText(getApplicationContext(),"Please enter a password", Toast.LENGTH_SHORT).show();
                                else if (TextUtils.isEmpty(editEconPass.getText().toString()))
                                    Toast.makeText(getApplicationContext(),"Please confirm password", Toast.LENGTH_SHORT).show();
                                else {
                                    users.setName(editEname.getText().toString().trim());
                                    users.setEmail(editEmail.getText().toString().trim());
                                    users.setCity(editEcity.getText().toString().trim());
                                    users.setPhone(Integer.parseInt(editEphone.getText().toString().trim()));
                                    users.setPassword(editEpass.getText().toString().trim());

                                    String pass = editEpass.getText().toString();
                                    String conPass = editEconPass.getText().toString();

                                    if (pass.equals(conPass)) {
                                        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("AppUsers").child(usersId);
                                        dbRef.setValue(users);
                                        Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(EditProfileTR.this, ProfileUserTR.class);
                                        intent.putExtra("usersData", users);
                                        intent.putExtra("userId", usersId);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Incorrect Contact Number", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }

}
