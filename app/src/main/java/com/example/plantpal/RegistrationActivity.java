package com.example.plantpal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.plantpal.R;
import com.example.plantpal.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = "RegistrationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registration);

        // Initialize Firebase Auth
        FirebaseAuth auth = FirebaseAuth.getInstance();

        // Get the email and password EditTexts
        EditText emailEditText = findViewById(R.id.editTextEmail);
        EditText passwordEditText = findViewById(R.id.editTextPassword);

        // Get the register button
        Button registerButton = findViewById(R.id.buttonRegister);

        // Get the back button
//        Button backButton = findViewById(R.id.buttonBack);
//
//         Set a click listener on the back button
//        backButton.setOnClickListener(v -> {
//            // Go to the login activity
//            startActivity(new Intent(RegistrationActivity.this, SignInActivity.class));
//        });

        // Set a click listener on the register button
        registerButton.setOnClickListener(v -> {
            // Get the email and password from the EditTexts
            String email = emailEditText.getText().toString().trim(); // Trim removes leading/trailing spaces
            String password = passwordEditText.getText().toString().trim();

            // Validate email and password
            if (email.isEmpty() || password.isEmpty()) {
                // Show an error message if email or password is empty
                Toast.makeText(RegistrationActivity.this, "Email or password cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            // Attempt to create a user with the provided email and password
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(RegistrationActivity.this, task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = auth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegistrationActivity.this, "Authentication failed: " + task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    });
        });
    }

    private void updateUI(FirebaseUser user) {
        // if the user is not null
        if (user != null) {
            // Log the user
            Log.d(TAG, "createUserWithEmail:success");
            // Get the user's email
            String email = user.getEmail();
            // Display the user's email
            Toast.makeText(getApplicationContext(), "Authentication success. Email: " + email,
                    Toast.LENGTH_SHORT).show();
            // Go to the login activity
            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
        } else {
            // Log the user
            Log.d(TAG, "createUserWithEmail:failure");
            // Display a message to the user
            Toast.makeText(getApplicationContext(), "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}