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


public class TimeConverterFragment extends Fragment {

    Spinner sp1,sp2;
    EditText ed1;
    TextView answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_time_converter, container, false);

        sp1 = view.findViewById(R.id.spfrom);
        sp2 = view.findViewById(R.id.spto);
        ed1 = view.findViewById(R.id.txtamt);
        answer = view.findViewById(R.id.textView5);


        String[] from = {"Sec","Min", "Hr","Day","Year"};
        ArrayAdapter ad = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"Sec","Min", "Hr","Day","Year"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,to);
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
1.Sec CONVERSION
 */
            //1.Celsius to Fahrenheit
            if (sp1.getSelectedItem().toString() == "Sec" && sp2.getSelectedItem().toString() == "Min") {
                tot = amt/60;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Sec" && sp2.getSelectedItem().toString() == "Hr") {
                tot = amt/3600;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Sec" && sp2.getSelectedItem().toString() == "Day") {
                tot = (amt/3600)/24;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Sec" && sp2.getSelectedItem().toString() == "Year") {
                tot = ((amt/3600)/24)/365;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
/*
2.Min CONVERSION
 */
            else if (sp1.getSelectedItem().toString() == "Min" && sp2.getSelectedItem().toString() == "Sec") {
                tot = amt*60;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Min" && sp2.getSelectedItem().toString() == "Hr") {
                tot = amt/60;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Min" && sp2.getSelectedItem().toString() == "Day") {
                tot = (amt/60)/24;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Min" && sp2.getSelectedItem().toString() == "Year") {
                tot = ((amt/60)/24)/365;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            /*
3.Hour CONVERSION
 */
            else if (sp1.getSelectedItem().toString() == "Hr" && sp2.getSelectedItem().toString() == "Sec") {
                tot = amt*3600;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Hr" && sp2.getSelectedItem().toString() == "Min") {
                tot = amt*60;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Hr" && sp2.getSelectedItem().toString() == "Day") {
                tot = amt/24;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Hr" && sp2.getSelectedItem().toString() == "Year") {
                tot = (amt/24)/365;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
                        /*
4.Day CONVERSION
 */
            else if (sp1.getSelectedItem().toString() == "Day" && sp2.getSelectedItem().toString() == "Sec") {
                tot = amt*3600*24;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Day" && sp2.getSelectedItem().toString() == "Min") {
                tot = amt*60*24;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Day" && sp2.getSelectedItem().toString() == "Hr") {
                tot = amt*24;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Day" && sp2.getSelectedItem().toString() == "Year") {
                tot = amt/365;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
                                    /*
4.Year CONVERSION
 */
            else if (sp1.getSelectedItem().toString() == "Year" && sp2.getSelectedItem().toString() == "Sec") {
                tot = amt*365*24*60*60;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Year" && sp2.getSelectedItem().toString() == "Min") {
                tot = amt*365*24*60;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Year" && sp2.getSelectedItem().toString() == "Hr") {
                tot = amt*365*24;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
            }
            else if (sp1.getSelectedItem().toString() == "Year" && sp2.getSelectedItem().toString() == "Day") {
                tot = amt*365;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f",tot));
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