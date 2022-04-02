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


public class AngleConverterFragment extends Fragment {

    Spinner sp1, sp2;
    EditText ed1;
    TextView answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_angle_converter, container, false);

        sp1 = view.findViewById(R.id.from);
        sp2 = view.findViewById(R.id.spto);
        ed1 = view.findViewById(R.id.text_input);
        answer = view.findViewById(R.id.textView_Result);


        String[] from = {"Degree", "Gradian", "Milliradian", "Radian", "Minute of Arc", "Second of Arc"};
        ArrayAdapter ad = new ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);


        String[] to = {"Degree", "Gradian", "Milliradian", "Radian", "Minute of Arc", "Second of Arc"};
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


        if (ed1.getText().toString().trim().length()>0) {

            Double tot;

            Double amt = Double.parseDouble(ed1.getText().toString());

/*
DEGREE CONVERSION
 */
            //1.Degree to Gradian
            if (sp1.getSelectedItem().toString() == "Degree" && sp2.getSelectedItem().toString() == "Gradian") {
                tot = amt * 200/180;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f grad",tot));
            }
            //2.Degree to Milliradian
            else if (sp1.getSelectedItem().toString() == "Degree" && sp2.getSelectedItem().toString() == "Milliradian") {
                tot = amt*(1000*3.14159265358/180);
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mrad",tot));

            }
            //3.Degree to Minute of Arc
            else if (sp1.getSelectedItem().toString() == "Degree" && sp2.getSelectedItem().toString() == "Minute of Arc") {
                tot = amt*60;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f '",tot));

            }
            //4.Degree to Radian
            else if (sp1.getSelectedItem().toString() == "Degree" && sp2.getSelectedItem().toString() == "Radian") {
                tot = amt*0.0174533;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f rad",tot));

            }
            //5.Degree to Second of Arc
            else if (sp1.getSelectedItem().toString() == "Degree" && sp2.getSelectedItem().toString() == "Second of Arc") {
                tot = amt*3600;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ''",tot));

            }
            /*
GRADIAN CONVERSION
 */
            //1.Gradian to Degree
            else if (sp1.getSelectedItem().toString() == "Gradian" && sp2.getSelectedItem().toString() == "Degree") {
                tot = amt * 0.9;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f °",tot));
            }
            //2.Gradian to Milliradian
            else if (sp1.getSelectedItem().toString() == "Gradian" && sp2.getSelectedItem().toString() == "Milliradian") {
                tot = amt * 15.7079633;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mrad",tot));

            }
            //3.Gradian to Minute of Arc
            else if (sp1.getSelectedItem().toString() == "Gradian" && sp2.getSelectedItem().toString() == "Minute of Arc") {
                tot = amt*54;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f '",tot));

            }
            //4.Gradian to Radian
            else if (sp1.getSelectedItem().toString() == "Gradian" && sp2.getSelectedItem().toString() == "Radian") {
                tot = amt*0.0157079633;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f rad",tot));

            }
            //5.Gradian to Second of Arc
            else if (sp1.getSelectedItem().toString() == "Gradian" && sp2.getSelectedItem().toString() == "Second of Arc") {
                tot = amt*3240;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ''",tot));

            }
            /*
MILLIRADIAN CONVERSION
 */
            //1.Milliradian to Gradian
            else if (sp1.getSelectedItem().toString() == "Milliradian" && sp2.getSelectedItem().toString() == "Gradian") {
                tot = amt * 0.063662;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f grad",tot));
            }
            //2.Milliradian to Degree
            else if (sp1.getSelectedItem().toString() == "Milliradian" && sp2.getSelectedItem().toString() == "Degree") {
                tot = amt*180/(1000*3.14159265358);
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f °",tot));

            }
            //3.Milliradian to Minute of Arc
            else if (sp1.getSelectedItem().toString() == "Milliradian" && sp2.getSelectedItem().toString() == "Minute of Arc") {
                tot = amt*60*180/(1000*3.14159265358);
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f '",tot));

            }
            //4.Milliradian to Radian
            else if (sp1.getSelectedItem().toString() == "Milliradian" && sp2.getSelectedItem().toString() == "Radian") {
                tot = amt/1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f rad",tot));

            }
            //5.Milliradian to Second of Arc
            else if (sp1.getSelectedItem().toString() == "Milliradian" && sp2.getSelectedItem().toString() == "Second of Arc") {
                tot = amt*3600*180/(1000*3.14159265358);
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ''",tot));

            }
            /*
MINUTE OF ARC CONVERSION
 */
            //1.Minute of Arc to Gradian
            else if (sp1.getSelectedItem().toString() == "Minute of Arc" && sp2.getSelectedItem().toString() == "Gradian") {
                tot = amt/54;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f grad",tot));
            }
            //2.Minute of Arc to Milliradian
            else if (sp1.getSelectedItem().toString() == "Minute of Arc" && sp2.getSelectedItem().toString() == "Milliradian") {
                tot = amt*1000*3.14159265358/(180*60);
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mrad",tot));

            }
            //3.Minute of Arc to Degree
            else if (sp1.getSelectedItem().toString() == "Minute of Arc" && sp2.getSelectedItem().toString() == "Degree") {
                tot = amt/60;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f °",tot));

            }
            //4.Minute of Arc to Radian
            else if (sp1.getSelectedItem().toString() == "Minute of Arc" && sp2.getSelectedItem().toString() == "Radian") {
                tot = amt*3.14159265358/(60*180);
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f rad",tot));

            }
            //5.Minute of Arc to Second of Arc
            else if (sp1.getSelectedItem().toString() == "Minute of Arc" && sp2.getSelectedItem().toString() == "Second of Arc") {
                tot = amt*60;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ''",tot));

            }
            /*
RADIAN CONVERSION
 */
            //1.Radian to Gradian
            else if (sp1.getSelectedItem().toString() == "Radian" && sp2.getSelectedItem().toString() == "Gradian") {
                tot = amt * 200/3.14159265358;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f grad",tot));
            }
            //2.Radian to Milliradian
            else if (sp1.getSelectedItem().toString() == "Radian" && sp2.getSelectedItem().toString() == "Milliradian") {
                tot = amt*1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mrad",tot));

            }
            //3.Radian to Minute of Arc
            else if (sp1.getSelectedItem().toString() == "Radian" && sp2.getSelectedItem().toString() == "Minute of Arc") {
                tot = amt*60*180/3.14159265358;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f '",tot));

            }
            //4.Radian to Degree
            else if (sp1.getSelectedItem().toString() == "Radian" && sp2.getSelectedItem().toString() == "Degree") {
                tot = amt*180/3.14159265358;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f °",tot));

            }
            //5.Radian to Second of Arc
            else if (sp1.getSelectedItem().toString() == "Radian" && sp2.getSelectedItem().toString() == "Second of Arc") {
                tot = amt*3600*180/3.14159265358;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ''",tot));

            }
            /*
SECOND OF ARC CONVERSION
 */
            //1.Second of Arc to Gradian
            else if (sp1.getSelectedItem().toString() == "Second of Arc" && sp2.getSelectedItem().toString() == "Gradian") {
                tot = amt / 3240;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f grad",tot));
            }
            //2.Second of Arc to Milliradian
            else if (sp1.getSelectedItem().toString() == "Second of Arc" && sp2.getSelectedItem().toString() == "Milliradian") {
                tot = amt*1000*3.14159265358/(180*3600);
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mrad",tot));

            }
            //3.Second of Arc to Minute of Arc
            else if (sp1.getSelectedItem().toString() == "Second of Arc" && sp2.getSelectedItem().toString() == "Minute of Arc") {
                tot = amt/60;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f '",tot));

            }
            //4.Second of Arc to Radian
            else if (sp1.getSelectedItem().toString() == "Second of Arc" && sp2.getSelectedItem().toString() == "Radian") {
                tot = amt*3.14159265358/(180*3600);
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f rad",tot));

            }
            //5.Second of Arc to Degree
            else if (sp1.getSelectedItem().toString() == "Second of Arc" && sp2.getSelectedItem().toString() == "Degree") {
                tot = amt/3600;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f °",tot));

            }
            else if (sp1.getSelectedItem().toString() ==  sp2.getSelectedItem().toString()) {
                tot = amt;
                //if both spinner are same (Note):-
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }

            else {
                //amt = 0.0;
                answer.setText("0");
            }

        }
    }
}
