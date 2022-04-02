package com.example.everycalc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ProfitLossFragment extends Fragment {

    Button Calculate;
    EditText SP, CP;
    TextView result;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profit_loss, container, false);
        SP=view.findViewById(R.id.SP);
        CP=view.findViewById(R.id.CP);
        result=view.findViewById(R.id.result);
        Calculate=view.findViewById(R.id.Calculate);
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
            }
        });



        return view;


    }
    public void calc(){
        double  sp=Double.parseDouble(SP.getText().toString());
        double  cp=Double.parseDouble(CP.getText().toString());

        if(SP.getText().toString().trim().length()==0|| CP.getText().toString().trim().length()==0)  {
            result.setText("Both fields can't be Empty.");
            return;
        }
        else if (sp>cp){

            result.setText("Profit: "+((sp-cp)*100)/cp+ "%");
        }
        else if(sp==cp){result.setText("0");

        }

        else {

            result.setText("Loss: "+((cp-sp)*100)/cp+ "%");
        }

    }
}