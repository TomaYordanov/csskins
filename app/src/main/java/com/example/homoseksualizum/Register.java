package com.example.homoseksualizum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        Intent goToLogin = new Intent(this, LoginActivity.class);
        Button button = findViewById(R.id.buttonLogin2);
        Button button3 = findViewById(R.id.buttonLogin3);
        button.setOnClickListener(v -> {
            EditText email = findViewById(R.id.editTextUsername2);
            EditText password = findViewById(R.id.editTextPassword2);


            auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = auth.getCurrentUser();
                                startActivity(goToLogin);
                            } else {
                                Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
        });
        button3.setOnClickListener(v -> {startActivity(goToLogin);});

    }
}