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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class Register extends AppCompatActivity {

    EditText username, emailid, et, et1, phno;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et = findViewById(R.id.pwd1);
        et1 = findViewById(R.id.pwd2);
        username = findViewById(R.id.user);
        emailid = findViewById(R.id.emailid);
        phno = findViewById(R.id.phno);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(this, Register.class));
        }
    }

    public boolean register(View view) {
        String email = emailid.getText().toString().trim();
        String password = et.getText().toString().trim();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
            emailid.setError("FIELD CANT BE EMPTY");
            return false;
        }
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(Register.this, Register.class));
                            Toast.makeText(Register.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return false;
    }

    public void signin(View view) {
        String mail = et.getText().toString().trim();

        String pass = et1.getText().toString().trim();
        if (mail.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }
        auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override

            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Register.this, "Logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Register.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(Register.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}