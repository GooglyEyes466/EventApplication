package com.example.eventapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class User_TR extends AppCompatActivity {
    EditText editName, editUserName, editEmail, editCity, editPhone, editPass, editConPass;
    Button btnCreate;
    DatabaseReference dbRef;
    AppUsers users;


    private void clearControls(){
        editName.setText("");
        editUserName.setText("");
        editEmail.setText("");
        editCity.setText("");
        editPhone.setText("");
        editPass.setText("");
        editConPass.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__tr);

        editName = findViewById(R.id.cname);
        editUserName = findViewById(R.id.cusername);
        editEmail = findViewById(R.id.cemail);
        editCity = findViewById(R.id.ccity);
        editPhone = findViewById(R.id.cphone);
        editPass = findViewById(R.id.cpassword);
        editConPass = findViewById(R.id.cconpassword);

        btnCreate = findViewById(R.id.btncreate);

        users = new AppUsers();
        createUser();
    }

    public void createUser(){
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("AppUsers");

                try {
                    if (TextUtils.isEmpty(editName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editUserName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a username", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editEmail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter your email", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editCity.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a city", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editPass.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a password", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editConPass.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please confirm password", Toast.LENGTH_SHORT).show();
                    else {
                        String usersId = dbRef.push().getKey();

                        users.setName(editName.getText().toString().trim());
                        users.setUsername(editUserName.getText().toString().trim());
                        users.setEmail(editEmail.getText().toString().trim());
                        users.setCity(editCity.getText().toString().trim());
                        users.setPhone(Integer.parseInt(editPhone.getText().toString().trim()));
                        users.setPassword(editPass.getText().toString().trim());



                        String password = editPass.getText().toString();
                        String conpassword = editConPass.getText().toString();

                        if (conpassword.equals(password)) {
                            dbRef.child(usersId).setValue(users);
                            Toast.makeText(getApplicationContext(), "Data Successfully Inserted", Toast.LENGTH_SHORT).show();
                            clearControls();

                            Intent intent = new Intent(User_TR.this, Main4ActivityS.class);
                            intent.putExtra("usersData", users);
                            intent.putExtra("userId", usersId);
                            startActivity(intent);

                        } else {
                            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                        }


                    }

                }catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_SHORT).show();
                }


            }

        });
    }



}
