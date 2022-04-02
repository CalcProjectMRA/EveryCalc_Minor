package com.example.everycalc;

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


public class LengthConverterFragment extends Fragment {

    Spinner sp1,sp2;
    EditText ed1;
    TextView answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_length_converter, container, false);

        sp1 = view.findViewById(R.id.spfrom);
        sp2 = view.findViewById(R.id.spto);
        ed1 = view.findViewById(R.id.text_input);
        answer = view.findViewById(R.id.textView_Result);


        String[] from = {"Kilometer","Meter", "Decimeter","Centimeter", "Millimeter", "Micrometer","Mile"};
        ArrayAdapter ad = new ArrayAdapter<String>(requireContext(),R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"Kilometer","Meter", "Decimeter","Centimeter", "Millimeter", "Micrometer","Mile"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(requireContext(),R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
            public void beforeTextChanged(CharSequence s, int start, int count, int aft ) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                //call your function here of calculation here
                convert();

            }
        });



        return view;
    }
    public void convert(){

        if (ed1.getText().toString().trim().length()>0) {

            double tot;

            double amt = Double.parseDouble(ed1.getText().toString());


/*
1.KILOMETER CONVERSION
 */
            //1.kilometer to meter
            if (sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Meter") {
                tot = amt * 1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //2.kilometer to Decimeter
            else if (sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Decimeter") {
                tot = amt * 10000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //3/kilometer to Centimeter
            else if (sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Centimeter") {
                tot = amt * 100000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //4.kilometer to Millimeter
            else if (sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Millimeter") {
                tot = amt * 1000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //5.kilometer to micrometer
            else if (sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Micrometer") {
                tot = amt * 1000000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //6.kilometer to mile
            else if (sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Mile") {
                tot = amt / 1.609344;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            /*7.kilometer to yard
            else if (sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Yard") {
                tot = amt * 1093.61;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }*/
/*
2.METER CONVERSION
 */
            //1.meter to kilometer
            else if (sp1.getSelectedItem().toString() == "Meter" && sp2.getSelectedItem().toString() == "Kilometer") {
                tot = amt / 1000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //2.meter to decimeter
            else if (sp1.getSelectedItem().toString() == "Meter" && sp2.getSelectedItem().toString() == "Decimeter") {
                tot = amt * 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //3.meter to centimeter
            else if (sp1.getSelectedItem().toString() == "Meter" && sp2.getSelectedItem().toString() == "Centimeter") {
                tot = amt * 100;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //4.meter to centimeter
            else if (sp1.getSelectedItem().toString() == "Meter" && sp2.getSelectedItem().toString() == "Millimeter") {
                tot = amt * 1000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //5.meter to centimeter
            else if (sp1.getSelectedItem().toString() == "Meter" && sp2.getSelectedItem().toString() == "Micrometer") {
                tot = amt * 1000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //6.meter to mile
            else if (sp1.getSelectedItem().toString() == "Meter" && sp2.getSelectedItem().toString() == "Mile") {
                tot = amt / 1609.344;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
/*
3.DECIMETER CONVERSION
 */
            //1.decimeter to kilometer
            else if (sp1.getSelectedItem().toString() == "Decimeter" && sp2.getSelectedItem().toString() == "Kilometer") {
                tot = amt / 10000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //2.decimeter to meter
            else if (sp1.getSelectedItem().toString() == "Decimeter" && sp2.getSelectedItem().toString() == "Meter") {
                tot = amt / 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //3.decimeter to centimeter
            else if (sp1.getSelectedItem().toString() == "Decimeter" && sp2.getSelectedItem().toString() == "Centimeter") {
                tot = amt * 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //4.decimeter to millimeter
            else if (sp1.getSelectedItem().toString() == "Decimeter" && sp2.getSelectedItem().toString() == "Millimeter") {
                tot = amt * 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //5.decimeter to micrometer
            else if (sp1.getSelectedItem().toString() == "Decimeter" && sp2.getSelectedItem().toString() == "Micrometer") {
                tot = amt * 100000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //6.decimeter to mile
            else if (sp1.getSelectedItem().toString() == "Decimeter" && sp2.getSelectedItem().toString() == "Mile") {
                tot = amt / 16093.44;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
/*
4.CENTIMETER CONVERSION
 */
            //1.Centimeter to kilometer
            else if (sp1.getSelectedItem().toString() == "Centimeter" && sp2.getSelectedItem().toString() == "Kilometer") {
                tot = amt / 100000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //2.Centimeter to meter
            else if (sp1.getSelectedItem().toString() == "Centimeter" && sp2.getSelectedItem().toString() == "Meter") {
                tot = amt / 100;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //3.Centimeter to decimeter
            else if (sp1.getSelectedItem().toString() == "Centimeter" && sp2.getSelectedItem().toString() == "Decimeter") {
                tot = amt / 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //4.Centimeter to Millimeter
            else if (sp1.getSelectedItem().toString() == "Centimeter" && sp2.getSelectedItem().toString() == "Millimeter") {
                tot = amt * 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //5.Centimeter to micrometer
            else if (sp1.getSelectedItem().toString() == "Centimeter" && sp2.getSelectedItem().toString() == "Micrometer") {
                tot = amt * 10000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //6.Centimeter to mile
            else if (sp1.getSelectedItem().toString() == "Centimeter" && sp2.getSelectedItem().toString() == "Mile") {
                tot = amt / 160934.4;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
/*
5.MILLIMETER CONVERSION
 */
            //1.millimeter to kilometer
            else if (sp1.getSelectedItem().toString() == "Millimeter" && sp2.getSelectedItem().toString() == "Kilometer") {
                tot = amt / 1000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //2.millimeter to meter
            else if (sp1.getSelectedItem().toString() == "Millimeter" && sp2.getSelectedItem().toString() == "Meter") {
                tot = amt / 1000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //3.millimeter to decimeter
            else if (sp1.getSelectedItem().toString() == "Millimeter" && sp2.getSelectedItem().toString() == "Decimeter") {
                tot = amt / 100;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //4.millimeter to centimeter
            else if (sp1.getSelectedItem().toString() == "Millimeter" && sp2.getSelectedItem().toString() == "Centimeter") {
                tot = amt / 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //5.millimeter to micrometer
            else if (sp1.getSelectedItem().toString() == "Millimeter" && sp2.getSelectedItem().toString() == "Micrometer") {
                tot = amt * 1000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            //6.millimeter to mile
            else if (sp1.getSelectedItem().toString() == "Millimeter" && sp2.getSelectedItem().toString() == "Mile") {
                tot = amt / 1609344;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
/*
6.Micrometer CONVERSION
 */
            //1.micrometer to kilometer
            else if (sp1.getSelectedItem().toString() == "Micrometer" && sp2.getSelectedItem().toString() == "Kilometer") {
                tot = amt / 1000000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //2.micrometer to meter
            else if (sp1.getSelectedItem().toString() == "Micrometer" && sp2.getSelectedItem().toString() == "Meter") {
                tot = amt / 1000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //3.micrometer to decimeter
            else if (sp1.getSelectedItem().toString() == "Micrometer" && sp2.getSelectedItem().toString() == "Decimeter") {
                tot = amt / 100000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //4.micrometer to centimeter
            else if (sp1.getSelectedItem().toString() == "Micrometer" && sp2.getSelectedItem().toString() == "Centimeter") {
                tot = amt / 10000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //5.micrometer to millimeter
            else if (sp1.getSelectedItem().toString() == "Micrometer" && sp2.getSelectedItem().toString() == "Millimeter") {
                tot = amt / 1000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //6.micrometer to mile
            else if (sp1.getSelectedItem().toString() == "Micrometer" && sp2.getSelectedItem().toString() == "Mile") {
                tot = amt / 1.609e+9;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
/*
7.mile CONVERSION
 */
            //1.mile to kilometer
            else if (sp1.getSelectedItem().toString() == "Mile" && sp2.getSelectedItem().toString() == "Kilometer") {
                tot = amt * 1.609344;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //2.mile to meter
            else if (sp1.getSelectedItem().toString() == "Mile" && sp2.getSelectedItem().toString() == "Meter") {
                tot = amt * 1609.344;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //3.mile to decimeter
            else if (sp1.getSelectedItem().toString() == "Mile" && sp2.getSelectedItem().toString() == "Decimeter") {
                tot = amt * 16093.44;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //4.mile to centi
            else if (sp1.getSelectedItem().toString() == "Mile" && sp2.getSelectedItem().toString() == "Centimeter") {
                tot = amt * 160934.4;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //5.mile to millimeter
            else if (sp1.getSelectedItem().toString() == "Mile" && sp2.getSelectedItem().toString() == "Millimeter") {
                tot = amt * 1609344;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            //6.mile to micrometer
            else if (sp1.getSelectedItem().toString() == "Mile" && sp2.getSelectedItem().toString() == "Micrometer") {
                tot = amt * 1.609e+9;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            }
            else if (sp1.getSelectedItem().toString() ==  sp2.getSelectedItem().toString()) {
                tot = amt;
                //if both spinner are same (Note):-
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }
            else {
                amt = 0.0;
                answer.setText("0");
            }

        }

    }

}