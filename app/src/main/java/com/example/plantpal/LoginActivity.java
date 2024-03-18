package com.example.plantpal;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.plantpal.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "SignInActivity";
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        // Initialize Firebase Authentication
        auth = FirebaseAuth.getInstance();

        // Check if user is already signed in
        if (auth.getCurrentUser() != null) {
            // User is already signed in, redirect to MainActivity
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        // Set OnClickListener for login button
        findViewById(R.id.buttonLogin).setOnClickListener(v -> signInWithEmailAndPassword());

        findViewById(R.id.registerButton).setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, com.example.plantpal.ui.login.RegistrationActivity.class));
        });
    }

    // Method to sign in with email and password
    private void signInWithEmailAndPassword() {
        EditText emailEditText = findViewById(R.id.editTextEmail);
        EditText passwordEditText = findViewById(R.id.editTextPassword);

        // Get text from EditText fields
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Sign in with email and password using Firebase Authentication
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = auth.getCurrentUser();
                        updateUIFire(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        updateUIFire(null);
                    }
                });
    }

    // Method to update UI based on Firebase user authentication
    private void updateUIFire(FirebaseUser user) {
        if (user != null) {
            // User is signed in, update UI with success message and navigate to MainActivity
            Log.d(TAG, "createUserWithEmail:success");
            String email = user.getEmail();
            Toast.makeText(this, "Authentication success. Email: " + email, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        } else {
            // Authentication failed, display failure message
            Log.d(TAG, "createUserWithEmail:failure");
            Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show();
        }
    }
}
