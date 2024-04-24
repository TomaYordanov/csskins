package com.example.homoseksualizum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        Intent goToRegister = new Intent(this, Register.class);
        Intent goToMain = new Intent(this, MainActivity.class);
        Button button = findViewById(R.id.buttonLogin);
        Button button2 = findViewById(R.id.buttonLogin4);
        button.setOnClickListener(v -> {
        EditText email = findViewById(R.id.editTextUsername);
        EditText password = findViewById(R.id.editTextPassword);


            auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = auth.getCurrentUser();
                                startActivity(goToMain);
                            }
                        }
                    });
        });
        button2.setOnClickListener( v -> {startActivity(goToRegister);});



            }
        }

