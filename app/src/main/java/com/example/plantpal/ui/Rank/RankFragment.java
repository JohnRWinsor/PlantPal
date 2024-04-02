// RankFragment.java
package com.example.plantpal.ui.Rank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.plantpal.R;

public class RankFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rank, container, false);

        // Access the text view and set its text
        TextView textView = rootView.findViewById(R.id.rankTextView);
        textView.setText("This is the Rank Fragment");

        return rootView;
    }
}
