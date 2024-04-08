/*
This is the file that has the functionally for the Settings page with a clickable button that takes you back to your previous page
 */

package com.example.plantpal.ui.Setting;

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

public class SettingsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        // Initialize views or perform any other setup here
        ImageButton imageButtonNewBack = root.findViewById(R.id.imageButtonSettingsBack);
        imageButtonNewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the MainActivity (home page)
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}