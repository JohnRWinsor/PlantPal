/*
This is the file that has the functionally for the Rank page with a clickable button that takes you back to your previous page
 */


package com.example.plantpal.ui.Rank;

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

public class RankFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rank, container, false);

        // Initialize the back button and set its onClickListener to navigate back to MainActivity
        ImageButton imageButtonNewBack = view.findViewById(R.id.imageButtonRankBack);
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
