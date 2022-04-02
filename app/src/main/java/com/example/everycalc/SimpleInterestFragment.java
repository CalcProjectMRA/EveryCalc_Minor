package com.example.everycalc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SimpleInterestFragment extends Fragment {

    Button Calculate;
    EditText amount, rate, time;
    TextView result;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view = inflater.inflate(R.layout.fragment_simple_interest, container, false);

        amount =view.findViewById(R.id.amount);
        rate = view.findViewById(R.id.rate);
        time=view.findViewById(R.id.time);
        result = view.findViewById(R.id.result);
        Calculate =view.findViewById(R.id.Calculate);
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc();
            }
        });

        return view;

    }

    public void calc() {
        if (amount.getText().toString().trim().length() > 0 && rate.getText().toString().trim().length() > 0 && time.getText().toString().trim().length() > 0) {


            double Amount = Double.parseDouble(amount.getText().toString());
            double Rate = Double.parseDouble(rate.getText().toString());
            double Time = Double.parseDouble(time.getText().toString());


            result.setText("" + (Amount * Rate * Time / 100));


        }
        else {
            Toast.makeText(getActivity(), "Enter the values", Toast.LENGTH_SHORT).show();
        }

    }





}