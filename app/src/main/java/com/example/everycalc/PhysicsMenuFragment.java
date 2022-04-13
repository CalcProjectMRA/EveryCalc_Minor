package com.example.everycalc;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PhysicsMenuFragment extends Fragment {

    CardView acceleration;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_physics_menu, container, false);

        acceleration = view.findViewById(R.id.Acceleration);
        acceleration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_physicsMenuFragment_to_accelerationFragment);
            }
        });
        return view;
    }
}