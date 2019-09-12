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

public class EditProfileTR extends AppCompatActivity {
   /* EditText editEname, editEmail, editEphone, editEcity, editEpass, editEconPass;
    Button btnEdit;
    AppUsers users = (AppUsers)getIntent().getSerializableExtra("usersData");
    String usersId = getIntent().getStringExtra("userId");

    private void clearControls(){
        editEname.setText("");
        editEmail.setText("");
        editEphone.setText("");
        editEcity.setText("");
        editEpass.setText("");
        editEconPass.setText("");

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_tr);

      /*  editEname = findViewById(R.id.uname);
        editEmail = findViewById(R.id.uemail);
        editEphone = findViewById(R.id.uphone);
        editEcity = findViewById(R.id.ucity);
        editEpass = findViewById(R.id.upassword);
        editEconPass = findViewById(R.id.uconpassword);

        btnEdit = findViewById(R.id.btnEditTr);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updateRef = FirebaseDatabase.getInstance().getReference().child("AppUsers");
                updateRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(usersId)) {
                            try {
                                users.setName(editEname.getText().toString().trim());
                                users.setEmail(editEmail.getText().toString().trim());
                                users.setCity(editEcity.getText().toString().trim());
                                users.setPhone(Integer.parseInt(editEphone.getText().toString().trim()));
                                users.setPassword(editEpass.getText().toString().trim());
                                users.setConPass(editEconPass.getText().toString().trim());

                                String password = editEpass.getText().toString();
                                String conpassword = editEconPass.getText().toString();

                                if(conpassword.equals(password)) {
                                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("AppUsers").child(usersId);
                                    dbRef.setValue(users);
                                    clearControls();
                                    Toast.makeText(getApplicationContext(), "Data Updated Successfully",Toast.LENGTH_SHORT).show();


                                    Intent intent = new Intent(EditProfileTR.this,ProfileUserTR.class);
                                    intent.putExtra("usersData",users);
                                    intent.putExtra("userId",usersId);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(getApplicationContext(), "Passwords do not match",Toast.LENGTH_SHORT).show();
                                }

                            }catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Update", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });*/

    }

    public void onUpdate(View view){
        Intent intent = new Intent(this, ProfileUserTR.class);

        startActivity(intent);

        Context context = getApplicationContext();
        CharSequence text = "Successfully Updated Account!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
