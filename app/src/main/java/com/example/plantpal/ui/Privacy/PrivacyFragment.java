package com.example.plantpal.ui.Privacy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.plantpal.R;

public class PrivacyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_privacy, container, false);

        // Find the privacyButton
        View privacyButton = view.findViewById(R.id.privacyButton);

        // Set OnClickListener for the privacyButton
        privacyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the FragmentActivity fragment using NavController
                Navigation.findNavController(v).navigate(R.id.nav_privacy);
            }
        });

        return view;
    }
}
