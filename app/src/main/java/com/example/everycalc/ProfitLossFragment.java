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


public class ProfitLossFragment extends Fragment {


    EditText sp1, cp1, loss1, profit1;
    TextView result;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profit_loss, container, false);
        sp1 = view.findViewById(R.id.SP);
        cp1 = view.findViewById(R.id.CP);
        loss1 = view.findViewById(R.id.Loss);
        profit1 = view.findViewById(R.id.Profit);
        result=view.findViewById(R.id.result);

        sp1.addTextChangedListener(new TextWatcher() {
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

        cp1.addTextChangedListener(new TextWatcher() {
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

        loss1.addTextChangedListener(new TextWatcher() {
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

        profit1.addTextChangedListener(new TextWatcher() {
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
    public void calc(){
//profit/loss
        if(sp1.getText().toString().trim().length()>0 && cp1.getText().toString().trim().length()>0){
            double sp = Double.parseDouble(sp1.getText().toString());
            double cp = Double.parseDouble(cp1.getText().toString());

            if (sp>cp){
                double tot = ((sp - cp) * 100) / cp;
                result.setText("" + String.format("%.2f %%",tot));
            }
            else if(sp==cp){
                result.setText("0");
            }
            else {
                double tot = ((cp-sp)*100)/cp;
                result.setText("" + String.format("%.2f %%",tot));
            }
        }
//cp
        else if(sp1.getText().toString().trim().length()>0 && profit1.getText().toString().trim().length()>0){
            double sp = Double.parseDouble(sp1.getText().toString());
            double profit = Double.parseDouble(profit1.getText().toString());
            double tot = sp * 100 / (100 + profit);
            result.setText("" + String.format("%.2f",tot));
        }
//cp
        else if(sp1.getText().toString().trim().length()>0 && loss1.getText().toString().trim().length()>0){
            double sp = Double.parseDouble(sp1.getText().toString());
            double loss = Double.parseDouble(loss1.getText().toString());
            double tot = sp * 100 / (100 - loss);
            result.setText("" + String.format("%.2f",tot));
        }
//sp
        else if(cp1.getText().toString().trim().length()>0 && profit1.getText().toString().trim().length()>0){
            double cp = Double.parseDouble(cp1.getText().toString());
            double profit = Double.parseDouble(profit1.getText().toString());
            double tot = (100 + profit) * cp / 100;
            result.setText("" + String.format("%.2f",tot));
        }
//sp
        else if(loss1.getText().toString().trim().length()>0 && cp1.getText().toString().trim().length()>0){
            double loss = Double.parseDouble(loss1.getText().toString());
            double cp = Double.parseDouble(cp1.getText().toString());
            double tot = (100 - loss) * cp / 100;
            result.setText("" + String.format("%.2f",tot));
        }

        else {
            Toast.makeText(getContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }

    }
}