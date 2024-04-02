// HomeFragment.java
package com.example.plantpal.ui.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.plantpal.R; // Change this to your actual package name

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Now you can access UI elements and set up any event listeners
        // For example:
        TextView textView = rootView.findViewById(R.id.textView2);
        textView.setText("Your Plants");

        // You can continue accessing other UI elements similarly

        return rootView;
    }
}
