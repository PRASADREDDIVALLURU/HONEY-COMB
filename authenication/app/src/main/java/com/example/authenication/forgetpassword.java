package com.example.authenication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class forgetpassword extends AppCompatActivity {
    EditText mailid, pwd5, pwd6;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        mailid = findViewById(R.id.email);
        pwd5 = findViewById(R.id.pwd3);
        pwd6 = findViewById(R.id.pwd4);
        auth = FirebaseAuth.getInstance();


    }
    public void reset(View view) {
        String email =mailid.getText().toString();
        if(email.isEmpty()){
            Toast.makeText(this, "Field cant be empty", Toast.LENGTH_SHORT).show();
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(forgetpassword.this, "RESENT EMAIL SENT", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(forgetpassword.this, "ENTER VALID EMAIL", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void goback(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}