package com.example.everycalc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SimpleInterestFragment extends Fragment {

    EditText principal, rate, time, simple_interest;
    TextView result;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view = inflater.inflate(R.layout.fragment_simple_interest, container, false);

        result =view.findViewById(R.id.output);
        rate = view.findViewById(R.id.rate);
        time = view.findViewById(R.id.time);
        principal = view.findViewById(R.id.principal);
        simple_interest = view.findViewById(R.id.simpleInterest);

        rate.addTextChangedListener(new TextWatcher() {
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

        time.addTextChangedListener(new TextWatcher() {
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

        simple_interest.addTextChangedListener(new TextWatcher() {
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

        principal.addTextChangedListener(new TextWatcher() {
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
        //SI
        if (principal.getText().toString().trim().length() > 0 && rate.getText().toString().trim().length() > 0 && time.getText().toString().trim().length() > 0) {


            double Principal = Double.parseDouble(principal.getText().toString());
            double Rate = Double.parseDouble(rate.getText().toString());
            double Time = Double.parseDouble(time.getText().toString());
            double SI = ((Principal * Rate * Time) / 100);
            result.setText("" + String.format("%.2f",SI));
        }

        //Principal
        else if (simple_interest.getText().toString().trim().length() > 0 && rate.getText().toString().trim().length() > 0 && time.getText().toString().trim().length() > 0) {


            double SI = Double.parseDouble(simple_interest.getText().toString());
            double Rate = Double.parseDouble(rate.getText().toString());
            double Time = Double.parseDouble(time.getText().toString());
            double Principal = (SI * 100) / (Rate * Time);

            result.setText("" + String.format("%.2f",Principal));
        }

        //Rate
        else if (principal.getText().toString().trim().length() > 0 && simple_interest.getText().toString().trim().length() > 0 && time.getText().toString().trim().length() > 0) {


            double SI = Double.parseDouble(simple_interest.getText().toString());
            double Principal = Double.parseDouble(principal.getText().toString());
            double Time = Double.parseDouble(time.getText().toString());
            double Rate = (SI * 100) / (Principal * Time);

            result.setText("" + String.format("%.2f %%",Rate));
        }

        //Time
        else if (principal.getText().toString().trim().length() > 0 && rate.getText().toString().trim().length() > 0 && simple_interest.getText().toString().trim().length() > 0) {


            double Principal = Double.parseDouble(principal.getText().toString());
            double Rate = Double.parseDouble(rate.getText().toString());
            double SI = Double.parseDouble(simple_interest.getText().toString());
            double Time = (SI * 100) / (Rate * Principal);

            result.setText("" + String.format("%.2f y",Time));
        }
        else {
            Toast.makeText(getActivity(), "Enter the values", Toast.LENGTH_SHORT).show();
        }

    }





}