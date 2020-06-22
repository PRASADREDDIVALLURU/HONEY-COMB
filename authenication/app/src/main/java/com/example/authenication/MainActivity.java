package com.example.authenication;

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


public class MainActivity extends AppCompatActivity {
    EditText mail,pwd;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=findViewById(R.id.email);
        pwd=findViewById(R.id.pass);

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null)
        {
            startActivity(new Intent(this,signin.class));
        }

    }

    public void signin(View view)
    {
        startActivity(new Intent(this,signin.class));
    }

    public void register(View view) {
        startActivity(new Intent(this,Register.class));

    }



    public void fgp(View view) {
        startActivity(new Intent(this, forgetpassword.class));



    }
}