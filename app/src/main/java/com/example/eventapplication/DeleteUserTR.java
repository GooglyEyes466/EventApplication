package com.example.eventapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DeleteUserTR extends AppCompatActivity {
    EditText editUsername, editPass;
    Button btnDel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user_tr);

        editUsername = findViewById(R.id.dusernametr);
        editPass = findViewById(R.id.dpasstr);


        btnDel = findViewById(R.id.btndeleteTr);

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("AppUsers");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        AppUsers users = (AppUsers) getIntent().getSerializableExtra("usersData");
                        String usersId = getIntent().getStringExtra("userId");

                        if (dataSnapshot.hasChild(usersId)) {

                            String username = editUsername.getText().toString();
                            String pass = editPass.getText().toString();

                            String classUsername = users.getUsername();
                            String classPassword = users.getPassword();

                            if(username.equals(classUsername)){
                                if(pass.equals(classPassword)){
                                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("AppUsers").child(usersId);
                                    dbRef.removeValue();
                                    Toast.makeText(getApplicationContext(),"Deleted Account Successfully!",Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(DeleteUserTR.this, MainActivityTR.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(getApplicationContext(), "Please re-enter password", Toast.LENGTH_SHORT).show();
                                }

                            }else {
                                Toast.makeText(getApplicationContext(), "Username is Incorrect!", Toast.LENGTH_SHORT).show();
                            }
                        }else {


                            Toast.makeText(getApplicationContext(), "No Source to Delete", Toast.LENGTH_SHORT).show();
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
