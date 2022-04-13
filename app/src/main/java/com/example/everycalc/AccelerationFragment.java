package com.example.everycalc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AccelerationFragment extends Fragment {
    EditText FinalVelocity,InitialVelocity,Acceleration,Time;
    TextView Result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_acceleration, container, false);
        FinalVelocity = view.findViewById(R.id.Fvelocity);
        InitialVelocity = view.findViewById(R.id.Ivelocity);
        Acceleration = view.findViewById(R.id.acceleration);
        Time = view.findViewById(R.id.Ctime);
        Result = view.findViewById(R.id.result);

        FinalVelocity.addTextChangedListener(new TextWatcher() {
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
        InitialVelocity.addTextChangedListener(new TextWatcher() {
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
        Time.addTextChangedListener(new TextWatcher() {
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
        Acceleration.addTextChangedListener(new TextWatcher() {
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
        double vf, vi, a, t;

        if (FinalVelocity.getText().toString().trim().length() > 0 && InitialVelocity.getText().toString().trim().length() > 0 && Time.getText().toString().trim().length() > 0) {
            vf = Double.parseDouble(FinalVelocity.getText().toString());
            vi = Double.parseDouble(InitialVelocity.getText().toString());
            t = Double.parseDouble(Time.getText().toString());
            Result.setText("Accelaration " + (vf - vi) / t);
        }
        else if (FinalVelocity.getText().toString().trim().length() > 0 && InitialVelocity.getText().toString().trim().length() > 0 && Acceleration.getText().toString().trim().length() > 0) {
            vf = Double.parseDouble(FinalVelocity.getText().toString());
            a = Double.parseDouble(Acceleration.getText().toString());
            vi = Double.parseDouble(InitialVelocity.getText().toString());
            Result.setText("Time " + (vf - vi) / a);
        }
        else if (FinalVelocity.getText().toString().trim().length() > 0 && Acceleration.getText().toString().trim().length() > 0 && Time.getText().toString().trim().length() > 0) {
            vf = Double.parseDouble(FinalVelocity.getText().toString());
            t = Double.parseDouble(Time.getText().toString());
            a = Double.parseDouble(Acceleration.getText().toString());
            Result.setText("Initial Velocity " + (vf - t * a));
        }
        else if (Acceleration.getText().toString().trim().length() > 0 && InitialVelocity.getText().toString().trim().length() > 0 && Time.getText().toString().trim().length() > 0) {
            vi = Double.parseDouble(InitialVelocity.getText().toString());
            t = Double.parseDouble(Time.getText().toString());
            a = Double.parseDouble(Acceleration.getText().toString());
            Result.setText("Final Velocity " + a * t + vi);
        }
        else
        {
            Result.setText("Required fields are empty.");
            return;
        }
    }
}