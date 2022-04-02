package com.example.everycalc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class CompoundInterestFragment extends Fragment {

    Spinner sp;
    EditText ed1, ed2, ed3, answer, answer2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_compound_interest, container, false);

        sp = view.findViewById(R.id.choose);
        ed1 = view.findViewById(R.id.amount);
        ed2 = view.findViewById(R.id.rate);
        ed3 = view.findViewById(R.id.time);
        answer = view.findViewById(R.id.result);
        answer2 = view.findViewById(R.id.resultAmount);

        String[] periodType = {"Quarterly", "Yearly", "Half Yearly", "Monthly"};
        ArrayAdapter ad = new ArrayAdapter<String>(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, periodType);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;

    }

    public void calculate() {

        if (ed1.getText().toString().trim().length() > 0 && ed2.getText().toString().trim().length() > 0 && ed3.getText().toString().trim().length() > 0) {
            double p = Double.parseDouble(ed1.getText().toString());
            double ratePercent = Double.parseDouble(ed2.getText().toString());
            double r = ratePercent / 100;
            double t = Double.parseDouble(ed3.getText().toString());
            double ci, Amount;

            //Toast.makeText(getApplicationContext(), "Enter Values", Toast.LENGTH_LONG).show();


            if (sp.getSelectedItem().toString() == "Half Yearly") {
                Amount = p * Math.pow(1 + r / 2, 2 * t);
                ci = Amount - p;
                answer.setText("" + ci);
                answer2.setText("" + Amount);

            }

            if (sp.getSelectedItem().toString() == "Quarterly") {
                Amount = p * Math.pow(1 + r / 4, 4 * t);
                ci = Amount - p;
                answer.setText("" + ci);
                answer2.setText("" + Amount);

            }

            if (sp.getSelectedItem().toString() == "Yearly") {
                Amount = p * Math.pow(1 + r, t);
                ci = Amount - p;
                answer.setText("" + ci);
                answer2.setText("" + Amount);
            }

            if (sp.getSelectedItem().toString() == "Monthly") {
                Amount = p * Math.pow(1 + r / 12, 12 * t);
                ci = Amount - p;
                answer.setText("" + ci);
                answer2.setText("" + Amount);
            }


        }
    }
}
