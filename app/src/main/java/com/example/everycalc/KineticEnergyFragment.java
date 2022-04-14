package com.example.everycalc;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class KineticEnergyFragment extends Fragment {

EditText velocity, mass, kineticEnergy;
TextView Result;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kinetic_energy, container, false);


        velocity = view.findViewById(R.id.velocity);
        mass = view.findViewById(R.id.mass);
        kineticEnergy = view.findViewById(R.id.kineticEnergy);
        Result = view.findViewById(R.id.result);

        velocity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calc();
            }
        });
        mass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calc();
            }
        });
        kineticEnergy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calc();
            }
        });
        return view;
    }
    public void calc() {
        double v, m, ke;

        if (velocity.getText().toString().trim().length() > 0 && mass.getText().toString().trim().length() > 0) {
            v = Double.parseDouble(velocity.getText().toString());
            m = Double.parseDouble(mass.getText().toString());
            ke = 0.5*m*v*v;
            Result.setText("" + String.format("%.2f",ke));
        }
        else if (kineticEnergy.getText().toString().trim().length() > 0 && mass.getText().toString().trim().length() > 0) {
            ke = Double.parseDouble(kineticEnergy.getText().toString());
            m = Double.parseDouble(mass.getText().toString());
            v = Math.sqrt(2*m*ke);
            Result.setText("" + String.format("%.2f",v));
        }
        else if (kineticEnergy.getText().toString().trim().length() > 0 && velocity.getText().toString().trim().length() > 0) {
            v = Double.parseDouble(velocity.getText().toString());
            ke = Double.parseDouble(kineticEnergy.getText().toString());
            m = (2*ke)/(v*v);
            Result.setText("" + String.format("%.2f",m));
        }
        else
        {
            Result.setText("Required fields are empty.");
            return;
        }
    }
}