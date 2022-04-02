package com.example.everycalc;

import static com.google.android.material.R.layout.support_simple_spinner_dropdown_item;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class VolumeConverterFragment extends Fragment {
    Spinner sp1, sp2;
    EditText ed1;
    TextView answer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_volume_converter, container, false);

        sp1 = view.findViewById(R.id.from);
        sp2 = view.findViewById(R.id.spto);
        ed1 = view.findViewById(R.id.text_input);
        answer = view.findViewById(R.id.textView_Result);


        String[] from = {"Cubic meter", "Litre", "Millilitre", "Cubic foot", "Cubic inch"};
        ArrayAdapter ad = new ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);


        String[] to = {"Cubic meter", "Litre", "Millilitre", "Cubic foot", "Cubic inch"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, to);
        sp2.setAdapter(ad1);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //check if spinner1 has a selected item and show the value in edittext
                convert();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //check if spinner2 has a selected item and show the value in edittext
                convert();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here

            }
        });


        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                convert();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int aft) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                //call your function here of calculation here
                convert();

            }
        });
        return view;
    }
    public void convert() {


        if (ed1.getText().toString().trim().length() > 0) {

            Double tot;

            Double amt = Double.parseDouble(ed1.getText().toString());

/*
CUBIC METER CONVERSION
 */
            //1.Cubic meter to Litre
            if (sp1.getSelectedItem().toString() == "Cubic meter" && sp2.getSelectedItem().toString() == "Litre") {
                tot = amt * 1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f l", tot));
            }
            //2.Cubic meter to Millilitre
            else if (sp1.getSelectedItem().toString() == "Cubic meter" && sp2.getSelectedItem().toString() == "Millilitre") {
                tot = amt*1e+6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ml", tot));

            }
            //3.Cubic meter to Cubic foot
            else if (sp1.getSelectedItem().toString() == "Cubic meter" && sp2.getSelectedItem().toString() == "Cubic foot") {
                tot = amt * 35.3147;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft³", tot));

            }
            //4.Cubic meter to Cubic inch
            else if (sp1.getSelectedItem().toString() == "Cubic meter" && sp2.getSelectedItem().toString() == "Cubic inch") {
                tot = amt * 61023.7;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f in³", tot));

            }
/*
LITRE CONVERSION
 */
            //1.Litre to Cubic meter
            else if (sp1.getSelectedItem().toString() == "Litre" && sp2.getSelectedItem().toString() == "Cubic meter") {
                tot = amt / 1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m³", tot));
            }
            //2.Litre to Millilitre
            else if (sp1.getSelectedItem().toString() == "Litre" && sp2.getSelectedItem().toString() == "Millilitre") {
                tot = amt * 1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ml", tot));

            }
            //3.Litre to Cubic foot
            else if (sp1.getSelectedItem().toString() == "Litre" && sp2.getSelectedItem().toString() == "Cubic foot") {
                tot = amt / 28.317;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft³", tot));

            }
            //4.Litre to Cubic inch
            else if (sp1.getSelectedItem().toString() == "Litre" && sp2.getSelectedItem().toString() == "Cubic inch") {
                tot = amt * 61.0237;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f in³", tot));

            }
/*
MILLILITRE CONVERSION
 */
            //1.Millilitre to Cubic meter
            else if (sp1.getSelectedItem().toString() == "Millilitre" && sp2.getSelectedItem().toString() == "Cubic meter") {
                tot = amt / 1e+6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m³", tot));
            }
            //2.Millilitre to Litre
            else if (sp1.getSelectedItem().toString() == "Millilitre" && sp2.getSelectedItem().toString() == "Litre") {
                tot = amt / 1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f l", tot));

            }
            //3.Millilitre to Cubic foot
            else if (sp1.getSelectedItem().toString() == "Millilitre" && sp2.getSelectedItem().toString() == "Cubic foot") {
                tot = amt / 28317;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft³", tot));

            }
            //4.Millilitre to Cubic inch
            else if (sp1.getSelectedItem().toString() == "Millilitre" && sp2.getSelectedItem().toString() == "Cubic inch") {
                tot = amt / 16.387;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f in³", tot));

            }
/*
CUBIC FOOT CONVERSION
 */
            //1.Cubic foot to Cubic meter
            else if (sp1.getSelectedItem().toString() == "Cubic foot" && sp2.getSelectedItem().toString() == "Cubic meter") {
                tot = amt / 35.315;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m³", tot));
            }
            //2.Cubic foot to Litre
            else if (sp1.getSelectedItem().toString() == "Cubic foot" && sp2.getSelectedItem().toString() == "Litre") {
                tot = amt * 28.3168;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f l", tot));

            }
            //3.Cubic foot to Millilitre
            else if (sp1.getSelectedItem().toString() == "Cubic foot" && sp2.getSelectedItem().toString() == "Millilitre") {
                tot = amt * 28317;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ml", tot));

            }
            //4.Cubic foot to Cubic inch
            else if (sp1.getSelectedItem().toString() == "Cubic foot" && sp2.getSelectedItem().toString() == "Cubic inch") {
                tot = amt * 1728;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f in³", tot));

            }
/*
CUBIC INCH CONVERSION
 */
            //1.Cubic inch to Cubic meter
            else if (sp1.getSelectedItem().toString() == "Cubic inch" && sp2.getSelectedItem().toString() == "Cubic meter") {
                tot = amt / 61024;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m³", tot));
            }
            //2.Cubic inch to Litre
            else if (sp1.getSelectedItem().toString() == "Cubic inch" && sp2.getSelectedItem().toString() == "Litre") {
                tot = amt / 61.024;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f l", tot));

            }
            //3.Cubic inch to Cubic foot
            else if (sp1.getSelectedItem().toString() == "Cubic inch" && sp2.getSelectedItem().toString() == "Cubic foot") {
                tot = amt / 1728;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft³", tot));

            }
            //4.Cubic inch to Millilitre
            else if (sp1.getSelectedItem().toString() == "Cubic inch" && sp2.getSelectedItem().toString() == "Millilitre") {
                tot = amt * 16.387;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ml", tot));

            }
            else if (sp1.getSelectedItem().toString() == sp2.getSelectedItem().toString()) {
                tot = amt;
                //if both spinner are same (Note):-
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            } else {
                //amt = 0.0;
                answer.setText("0");
            }

        }
    }

}