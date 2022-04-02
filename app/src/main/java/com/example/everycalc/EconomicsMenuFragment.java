package com.example.everycalc;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EconomicsMenuFragment extends Fragment {

    CardView simpleInterest,CompoundInterest;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_economics_menu, container, false);

        simpleInterest=view.findViewById(R.id.SimpleInterest);
        CompoundInterest=view.findViewById(R.id.CompoundInterest);
        simpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_economicsMenuFragment_to_simpleInterestFragment);


            }
        });

        CompoundInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_economicsMenuFragment_to_compoundInterestFragment);


            }
        });
        return view;
    }
}