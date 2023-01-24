package com.example.cleany;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragment2 extends Fragment {
    Button houseowner,Cleaner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment2, container, false);

        houseowner=view.findViewById(R.id.Admin);
        Cleaner=view.findViewById(R.id.User);

        houseowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), houseowner.class);
                startActivity(intent);
            }
        });

        Cleaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Cleaner.class);
                startActivity(intent);
            }
        });



        return view;


    }
}