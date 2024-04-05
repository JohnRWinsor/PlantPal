package com.example.plantpal.ui.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.plantpal.R;
import com.example.plantpal.ui.Create.CreatePlantFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.navigation.Navigation;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        FloatingActionButton fab = root.findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to CreatePlantFragment using NavController
                Navigation.findNavController(view).navigate(R.id.nav_createPlant);
            }
        });

        // Find the ImageView for the plant
        ImageView imageViewPlant = root.findViewById(R.id.imageView4);
        // Set an OnClickListener for the plant ImageView
        imageViewPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to CreatePlantFragment using NavController
                Navigation.findNavController(view).navigate(R.id.nav_view);
            }
        });

        return root;
    }
}

