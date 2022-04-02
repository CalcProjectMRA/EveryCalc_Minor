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


public class MassConverterFragment extends Fragment {

    Spinner sp1,sp2;
    EditText ed1;
    TextView answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_mass_converter, container, false);

        sp1 = view.findViewById(R.id.spfrom);
        sp2 = view.findViewById(R.id.spto);
        ed1 = view.findViewById(R.id.txtamt);
        answer = view.findViewById(R.id.textView5);


        String[] from = {"Kilogram","gram", "Decigram","Centigram", "Milligram", "Microgram"};
        ArrayAdapter ad = new ArrayAdapter<String>(getContext() ,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"Kilogram","gram", "Decigram","Centigram", "Milligram", "Microgram"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(getContext() ,R.layout.support_simple_spinner_dropdown_item,to);
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
1.KILOgram CONVERSION
 */
            //1.kilogram to gram
            if (sp1.getSelectedItem().toString() == "Kilogram" && sp2.getSelectedItem().toString() == "gram") {
                tot = amt * 1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f g",tot));
            }
            //2.kilogram to Decigram
            else if (sp1.getSelectedItem().toString() == "Kilogram" && sp2.getSelectedItem().toString() == "Decigram") {
                tot = amt * 10000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f dg",tot));

            }
            //3/kilogram to Centigram
            else if (sp1.getSelectedItem().toString() == "Kilogram" && sp2.getSelectedItem().toString() == "Centigram") {
                tot = amt * 100000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f cg",tot));

            }
            //4.kilogram to Milligram
            else if (sp1.getSelectedItem().toString() == "Kilogram" && sp2.getSelectedItem().toString() == "Milligram") {
                tot = amt * 1000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mg",tot));

            }
            //5.kilogram to microgram
            else if (sp1.getSelectedItem().toString() == "Kilogram" && sp2.getSelectedItem().toString() == "Microgram") {
                tot = amt * 1000000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f μg",tot));

            }

/*
2.gram CONVERSION
 */
            //1.gram to kilogram
            else if (sp1.getSelectedItem().toString() == "gram" && sp2.getSelectedItem().toString() == "Kilogram") {
                tot = amt / 1000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kg",tot));

            }
            //2.gram to decigram
            else if (sp1.getSelectedItem().toString() == "gram" && sp2.getSelectedItem().toString() == "Decigram") {
                tot = amt * 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f dg",tot));

            }
            //3.gram to centigram
            else if (sp1.getSelectedItem().toString() == "gram" && sp2.getSelectedItem().toString() == "Centigram") {
                tot = amt * 100;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f cg",tot));

            }
            //4.gram to centigram
            else if (sp1.getSelectedItem().toString() == "gram" && sp2.getSelectedItem().toString() == "Milligram") {
                tot = amt * 1000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mg",tot));

            }
            //5.gram to centigram
            else if (sp1.getSelectedItem().toString() == "gram" && sp2.getSelectedItem().toString() == "Microgram") {
                tot = amt * 1000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f μg",tot));

            }

/*
3.DECIgram CONVERSION
 */
            //1.decigram to kilogram
            else if (sp1.getSelectedItem().toString() == "Decigram" && sp2.getSelectedItem().toString() == "Kilogram") {
                tot = amt / 10000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kg",tot));

            }
            //2.decigram to gram
            else if (sp1.getSelectedItem().toString() == "Decigram" && sp2.getSelectedItem().toString() == "gram") {
                tot = amt / 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f g",tot));

            }
            //3.decigram to centigram
            else if (sp1.getSelectedItem().toString() == "Decigram" && sp2.getSelectedItem().toString() == "Centigram") {
                tot = amt * 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f cg",tot));

            }
            //4.decigram to milligram
            else if (sp1.getSelectedItem().toString() == "Decigram" && sp2.getSelectedItem().toString() == "Milligram") {
                tot = amt * 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mg",tot));

            }
            //5.decigram to microgram
            else if (sp1.getSelectedItem().toString() == "Decigram" && sp2.getSelectedItem().toString() == "Microgram") {
                tot = amt * 100000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f μg",tot));

            }

/*
4.CENTIgram CONVERSION
 */
            //1.Centigram to kilogram
            else if (sp1.getSelectedItem().toString() == "Centigram" && sp2.getSelectedItem().toString() == "Kilogram") {
                tot = amt / 100000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kg",tot));

            }
            //2.Centigram to gram
            else if (sp1.getSelectedItem().toString() == "Centigram" && sp2.getSelectedItem().toString() == "gram") {
                tot = amt / 100;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f g",tot));
            }
            //3.Centigram to decigram
            else if (sp1.getSelectedItem().toString() == "Centigram" && sp2.getSelectedItem().toString() == "Decigram") {
                tot = amt / 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f dg",tot));

            }
            //4.Centigram to Milligram
            else if (sp1.getSelectedItem().toString() == "Centigram" && sp2.getSelectedItem().toString() == "Milligram") {
                tot = amt * 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mg",tot));

            }
            //5.Centigram to microgram
            else if (sp1.getSelectedItem().toString() == "Centigram" && sp2.getSelectedItem().toString() == "Microgram") {
                tot = amt * 10000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f μg", tot));

            }
/*
5.MILLIgram CONVERSION
 */
            //1.milligram to kilogram
            else if (sp1.getSelectedItem().toString() == "Milligram" && sp2.getSelectedItem().toString() == "Kilogram") {
                tot = amt / 1000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kg",tot));

            }
            //2.milligram to gram
            else if (sp1.getSelectedItem().toString() == "Milligram" && sp2.getSelectedItem().toString() == "gram") {
                tot = amt / 1000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f g",tot));

            }
            //3.milligram to decigram
            else if (sp1.getSelectedItem().toString() == "Milligram" && sp2.getSelectedItem().toString() == "Decigram") {
                tot = amt / 100;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f dg",tot));

            }
            //4.milligram to centigram
            else if (sp1.getSelectedItem().toString() == "Milligram" && sp2.getSelectedItem().toString() == "Centigram") {
                tot = amt / 10;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f cg",tot));

            }
            //5.milligram to microgram
            else if (sp1.getSelectedItem().toString() == "Milligram" && sp2.getSelectedItem().toString() == "Microgram") {
                tot = amt * 1000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f μg",tot));

            }

/*
6.Microgram CONVERSION
 */
            //1.microgram to kilogram
            else if (sp1.getSelectedItem().toString() == "Microgram" && sp2.getSelectedItem().toString() == "Kilogram") {
                tot = amt / 1000000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kg",tot));
            }
            //2.microgram to gram
            else if (sp1.getSelectedItem().toString() == "Microgram" && sp2.getSelectedItem().toString() == "gram") {
                tot = amt / 1000000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f g",tot));
            }
            //3.microgram to decigram
            else if (sp1.getSelectedItem().toString() == "Microgram" && sp2.getSelectedItem().toString() == "Decigram") {
                tot = amt / 100000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f dg",tot));
            }
            //4.microgram to centigram
            else if (sp1.getSelectedItem().toString() == "Microgram" && sp2.getSelectedItem().toString() == "Centigram") {
                tot = amt / 10000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f cg",tot));
            }
            //5.microgram to milligram
            else if (sp1.getSelectedItem().toString() == "Microgram" && sp2.getSelectedItem().toString() == "Milligram") {
                tot = amt / 1000;
                // Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mg",tot));
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