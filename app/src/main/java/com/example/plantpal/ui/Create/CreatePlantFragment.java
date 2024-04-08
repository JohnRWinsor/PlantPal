/*
This is the file that has the functionally for the create plant page with a clickable button that takes you back to your previous page
 */


package com.example.plantpal.ui.Create;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.plantpal.MainActivity;
import com.example.plantpal.R;

public class CreatePlantFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_createplant, container, false);

        // Image on the page turned into a button to take you to main activity
        ImageButton imageButtonNewBack = view.findViewById(R.id.imageButtonNewBack);
        imageButtonNewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the MainActivity (home page)
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
