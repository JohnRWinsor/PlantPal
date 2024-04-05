package com.example.plantpal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PrivacyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_privacy); // Replace with your privacy policy layout file

        // Find the back button
        ImageButton backButton = findViewById(R.id.imageButtonBack);

        // Set click listener on back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to LoginActivity
                Intent intent = new Intent(PrivacyActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Finish PrivacyActivity
            }
        });
    }
}
