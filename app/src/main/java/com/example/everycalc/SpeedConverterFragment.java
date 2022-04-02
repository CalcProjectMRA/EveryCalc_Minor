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

public class SpeedConverterFragment extends Fragment {

    Spinner sp1, sp2;
    EditText ed1;
    TextView answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speed_converter, container, false);


        sp1 = view.findViewById(R.id.from);
        sp2 = view.findViewById(R.id.spto);
        ed1 = view.findViewById(R.id.text_input);
        answer = view.findViewById(R.id.textView_Result);


        String[] from = {"Miles per hour", "Foot per second", "Meter per second", "Kilometer per hour", "Knot"};
        ArrayAdapter ad = new ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);


        String[] to = {"Miles per hour", "Foot per second", "Meter per second", "Kilometer per hour", "Knot"};
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
MILES PER HOUR CONVERSION
 */
            //1.Miles per hour to Foot per second
            if (sp1.getSelectedItem().toString() == "Miles per hour" && sp2.getSelectedItem().toString() == "Foot per second") {
                tot = amt*1.46667;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft/s",tot));
            }
            //2.Miles per hour to Meter per second
            else if (sp1.getSelectedItem().toString() == "Miles per hour" && sp2.getSelectedItem().toString() == "Meter per second") {
                tot = amt/2.236936;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m/s",tot));

            }
            //3.Miles per hour to Kilometer per hour
            else if (sp1.getSelectedItem().toString() == "Miles per hour" && sp2.getSelectedItem().toString() == "Kilometer per hour") {
                tot = amt*1.60934;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f km/h",tot));

            }
            //4.Miles per hour to Knot
            else if (sp1.getSelectedItem().toString() == "Miles per hour" && sp2.getSelectedItem().toString() == "Knot") {
                tot = amt/1.150779;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f kn",tot));

            }
/*
 FOOT PER SECOND CONVERSION
*/
            //1.Foot per second to Miles per hour
            else if (sp1.getSelectedItem().toString() == "Foot per second" && sp2.getSelectedItem().toString() == "Miles per hour") {
                tot = amt/1.46667;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mi/h",tot));
            }
            //2.Foot per second to Meter per second
            else if (sp1.getSelectedItem().toString() == "Foot per second" && sp2.getSelectedItem().toString() == "Meter per second") {
                tot = amt/3.28084;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m/s",tot));

            }
            //3.Foot per second to Kilometer per hour
            else if (sp1.getSelectedItem().toString() == "Foot per second" && sp2.getSelectedItem().toString() == "Kilometer per hour") {
                tot = amt*1.09728;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f km/h",tot));

            }
            //4.Foot per second to Knot
            else if (sp1.getSelectedItem().toString() == "Foot per second" && sp2.getSelectedItem().toString() == "Knot") {
                tot = amt/1.68781;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f kn",tot));

            }
            /*
 METER PER SECOND CONVERSION
*/
            //1.Meter per second to Miles per hour
            else if (sp1.getSelectedItem().toString() == "Meter per second" && sp2.getSelectedItem().toString() == "Miles per hour") {
                tot = amt*2.236936;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mi/h",tot));
            }
            //2.Meter per second to Foot per second
            else if (sp1.getSelectedItem().toString() == "Meter per second" && sp2.getSelectedItem().toString() == "Foot per second") {
                tot = amt*3.28084;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft/s",tot));

            }
            //3.Meter per second to Kilometer per hour
            else if (sp1.getSelectedItem().toString() == "Meter per second" && sp2.getSelectedItem().toString() == "Kilometer per hour") {
                tot = amt*3.6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f km/h",tot));

            }
            //4.Meter per second to Knot
            else if (sp1.getSelectedItem().toString() == "Meter per second" && sp2.getSelectedItem().toString() == "Knot") {
                tot = amt*1.943844;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f kn",tot));

            }
/*
KILOMETER PER HOUR CONVERSION
*/
            //1.Kilometer per hour to Miles per hour
            else if (sp1.getSelectedItem().toString() == "Kilometer per hour" && sp2.getSelectedItem().toString() == "Miles per hour") {
                tot = amt*0.6213712;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mi/h",tot));
            }
            //2.Kilometer per hour to Foot per second
            else if (sp1.getSelectedItem().toString() == "Kilometer per hour" && sp2.getSelectedItem().toString() == "Foot per second") {
                tot = amt*0.911344;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft/s",tot));

            }
            //3.Kilometer per hour to Meter per second
            else if (sp1.getSelectedItem().toString() == "Kilometer per hour" && sp2.getSelectedItem().toString() == "Meter per second") {
                tot = amt/3.6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m/s",tot));

            }
            //4.Kilometer per hour second to Knot
            else if (sp1.getSelectedItem().toString() == "Kilometer per hour" && sp2.getSelectedItem().toString() == "Knot") {
                tot = amt*0.5399568;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f kn",tot));

            }
/*
KNOT CONVERSION
*/
            //1.Knot to Miles per hour
            else if (sp1.getSelectedItem().toString() == "Knot" && sp2.getSelectedItem().toString() == "Miles per hour") {
                tot = amt*1.15077945;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f mi/h",tot));
            }
            //2.Knot to Foot per second
            else if (sp1.getSelectedItem().toString() == "Knot" && sp2.getSelectedItem().toString() == "Foot per second") {
                tot = amt*1.68781;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft/s",tot));

            }
            //3.Knot to Meter per second
            else if (sp1.getSelectedItem().toString() == "Knot" && sp2.getSelectedItem().toString() == "Meter per second") {
                tot = amt/1.944;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m/s",tot));

            }
            //4.Knot to Kilometer per hour
            else if (sp1.getSelectedItem().toString() == "Knot" && sp2.getSelectedItem().toString() == "Kilometer per hour") {
                tot = amt*1.852;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f km/h",tot));

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