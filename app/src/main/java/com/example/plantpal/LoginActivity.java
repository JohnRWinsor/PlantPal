/*
 This activity handles user login functionality. It allows users to sign in with their email
 and password using Firebase Authentication. If the user is already signed in, it redirects
 them to the MainActivity. It also provides options for users to navigate to the registration
 page to create a new account or view the privacy policy.
 */

package com.example.plantpal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        mAuth = FirebaseAuth.getInstance();

        // Check if user is already signed in
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser != null) {
//            // User is already signed in, redirect to MainActivity
//            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//            finish();
//        }

        // Initialize UI elements
        EditText emailEditText = findViewById(R.id.editTextEmail);
        EditText passwordEditText = findViewById(R.id.editTextPassword);
        Button loginButton = findViewById(R.id.buttonLogin);
        Button registerButton = findViewById(R.id.registerButton);
        Button privacyButton = findViewById(R.id.privacyButton);

        // Set OnClickListener for login button
        loginButton.setOnClickListener(v -> signInWithEmailAndPassword(emailEditText.getText().toString(),
                passwordEditText.getText().toString()));

        // Set OnClickListener for Register button
        registerButton.setOnClickListener(v -> navigateToRegistrationActivity());

       // Aet OnClickListener for Privacy button
        privacyButton.setOnClickListener(v -> navigateToPrivacyPolicy());
    }



    // Method to sign in with email and password
    private void signInWithEmailAndPassword(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                });
    }

    // Method to navigate to RegistrationActivity
    private void navigateToRegistrationActivity() {
        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }

    // Method to navigate to PrivacyActivity
    private void navigateToPrivacyPolicy() {
        Intent intent = new Intent(LoginActivity.this, PrivacyActivity.class);
        startActivity(intent);
    }

    // Method to sign out the user
    private void signOut() {
        mAuth.signOut(); // Sign out from Firebase Authentication

        // After sign-out, navigate the user back to the login page
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Finish the current activity to prevent returning to it when pressing back
    }


    // Method to update UI based on Firebase user authentication
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            // User is signed in, update UI with success message and navigate to MainActivity
            Log.d(TAG, "signInWithEmail:success");
            String email = user.getEmail();
            Toast.makeText(LoginActivity.this, "Authentication success. Email: " + email,
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish(); // Finish LoginActivity to prevent going back to it
        } else {
            // Authentication failed, display failure message
            Log.d(TAG, "signInWithEmail:failure");
            Toast.makeText(LoginActivity.this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
        }
    }


}