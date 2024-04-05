package com.example.plantpal;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
<<<<<<< Updated upstream

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

=======
import android.widget.Button;


import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBar;
>>>>>>> Stashed changes
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.plantpal.databinding.ActivityMainBinding;
<<<<<<< Updated upstream
=======
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
>>>>>>> Stashed changes

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
<<<<<<< Updated upstream
=======
    private FirebaseAuth auth;
//    Button privacyPolicyButton = findViewById(R.id.nav_privacy);


>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

<<<<<<< Updated upstream
=======
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Check if user is authenticated
//        FirebaseUser currentUser = auth.getCurrentUser();
//        if (currentUser == null) {
//            // User is not authenticated, redirect to LoginActivity
//            startActivity(new Intent(this, LoginActivity.class));
//            finish(); // Finish MainActivity to prevent going back to it after logging in
//            return;
//        }

>>>>>>> Stashed changes
        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
<<<<<<< Updated upstream
                R.id.nav_home, R.id.nav_profile, R.id.nav_settings)
=======
                R.id.nav_home, R.id.nav_settings, R.id.nav_createPlant, R.id.nav_rank)
>>>>>>> Stashed changes
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
<<<<<<< Updated upstream
=======

        // Set title for the action bar if it's not null
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Menu");
        }
>>>>>>> Stashed changes
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();


    }


    private void navigateToPrivacyPolicy() {
        // Navigate to the privacy policy page, you can replace PrivacyPolicyActivity with your actual activity
        Intent intent = new Intent(MainActivity.this, PrivacyActivity.class);
        startActivity(intent);
    }
}