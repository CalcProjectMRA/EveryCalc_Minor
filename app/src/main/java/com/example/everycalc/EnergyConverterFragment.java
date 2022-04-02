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

public class EnergyConverterFragment extends Fragment {

    Spinner sp1, sp2;
    EditText ed1;
    TextView answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_energy_converter, container, false);
        sp1 = view.findViewById(R.id.from);
        sp2 = view.findViewById(R.id.spto);
        ed1 = view.findViewById(R.id.text_input);
        answer = view.findViewById(R.id.textView_Result);


        String[] from = {"Joule", "Kilo Joule", "Gram Calorie", "Kilo Calorie", "Watt Hour", "Kilowatt Hour"};
        ArrayAdapter ad = new ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);


        String[] to = {"Joule", "Kilo Joule", "Gram Calorie", "Kilo Calorie", "Watt Hour", "Kilowatt Hour"};
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
JOULE CONVERSION
 */
            //1.Joule to Kilo Joule
            if (sp1.getSelectedItem().toString() == "Joule" && sp2.getSelectedItem().toString() == "Kilo Joule") {
                tot = amt/1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kJ",tot));
            }
            //2.Joule to Gram Calorie
            else if (sp1.getSelectedItem().toString() == "Joule" && sp2.getSelectedItem().toString() == "Gram Calorie") {
                tot = amt/4.184;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f cal",tot));

            }
            //3.Joule to Kilo Calorie
            else if (sp1.getSelectedItem().toString() == "Joule" && sp2.getSelectedItem().toString() == "Kilo Calorie") {
                tot = amt/4184;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kcal",tot));

            }
            //4.Joule to Watt Hour
            else if (sp1.getSelectedItem().toString() == "Joule" && sp2.getSelectedItem().toString() == "Watt Hour") {
                tot = amt/3600;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f Wh",tot));

            }
            //5.Joule to Kilowatt Hour
            else if (sp1.getSelectedItem().toString() == "Joule" && sp2.getSelectedItem().toString() == "Kilowatt Hour") {
                tot = amt/3.6e+6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kWh",tot));

            }
            /*
KILO JOULE CONVERSION
 */
            //1.Kilo Joule to Joule
            else if (sp1.getSelectedItem().toString() == "Kilo Joule" && sp2.getSelectedItem().toString() == "Joule") {
                tot = amt*1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f J",tot));
            }
            //2.Kilo Joule to Gram Calorie
            else if (sp1.getSelectedItem().toString() == "Kilo Joule" && sp2.getSelectedItem().toString() == "Gram Calorie") {
                tot = amt*239.006;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f cal",tot));

            }
            //3.Kilo Joule to Kilo Calorie
            else if (sp1.getSelectedItem().toString() == "Kilo Joule" && sp2.getSelectedItem().toString() == "Kilo Calorie") {
                tot = amt/4.184;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kcal",tot));

            }
            //4.Kilo Joule to Watt Hour
            else if (sp1.getSelectedItem().toString() == "Kilo Joule" && sp2.getSelectedItem().toString() == "Watt Hour") {
                tot = amt/3.6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f Wh",tot));

            }
            //5.Kilo Joule to Kilowatt Hour
            else if (sp1.getSelectedItem().toString() == "Kilo Joule" && sp2.getSelectedItem().toString() == "Kilowatt Hour") {
                tot = amt/3600;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kWh",tot));

            }
            /*
GRAM CALORIE CONVERSION
 */
            //1.Gram Calorie to Kilo Joule
            else if (sp1.getSelectedItem().toString() == "Gram Calorie" && sp2.getSelectedItem().toString() == "Kilo Joule") {
                tot = amt/239;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kJ",tot));
            }
            //2.Gram Calorie to Joule
            else if (sp1.getSelectedItem().toString() == "Gram Calorie" && sp2.getSelectedItem().toString() == "Joule") {
                tot = amt*4.184;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f J",tot));

            }
            //3.Gram Calorie to Kilo Calorie
            else if (sp1.getSelectedItem().toString() == "Gram Calorie" && sp2.getSelectedItem().toString() == "Kilo Calorie") {
                tot = amt/1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kcal",tot));

            }
            //4.Gram Calorie to Watt Hour
            else if (sp1.getSelectedItem().toString() == "Gram Calorie" && sp2.getSelectedItem().toString() == "Watt Hour") {
                tot = amt/860;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f Wh",tot));

            }
            //5.Gram Calorie to Kilowatt Hour
            else if (sp1.getSelectedItem().toString() == "Gram Calorie" && sp2.getSelectedItem().toString() == "Kilowatt Hour") {
                tot = amt/860421;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kWh",tot));

            }
            /*
KILO CALORIE CONVERSION
 */
            //1.Kilo Calorie to Kilo Joule
            else if (sp1.getSelectedItem().toString() == "Kilo Calorie" && sp2.getSelectedItem().toString() == "Kilo Joule") {
                tot = amt*4.184;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kJ",tot));
            }
            //2.Kilo Calorie to Gram Calorie
            else if (sp1.getSelectedItem().toString() == "Kilo Calorie" && sp2.getSelectedItem().toString() == "Gram Calorie") {
                tot = amt*1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f cal",tot));

            }
            //3.Kilo Calorie to Joule
            else if (sp1.getSelectedItem().toString() == "Kilo Calorie" && sp2.getSelectedItem().toString() == "Joule") {
                tot = amt*4184;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kcal",tot));

            }
            //4.Kilo Calorie to Watt Hour
            else if (sp1.getSelectedItem().toString() == "Kilo Calorie" && sp2.getSelectedItem().toString() == "Watt Hour") {
                tot = amt*1.6222;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f Wh",tot));

            }
            //5.Kilo Calorie to Kilowatt Hour
            else if (sp1.getSelectedItem().toString() == "Kilo Calorie" && sp2.getSelectedItem().toString() == "Kilowatt Hour") {
                tot = amt*0.00116222;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kWh",tot));

            }
            /*
WATT HOUR CONVERSION
 */
            //1.Watt Hour to Kilo Joule
            else if (sp1.getSelectedItem().toString() == "Watt Hour" && sp2.getSelectedItem().toString() == "Kilo Joule") {
                tot = amt*3.6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kJ",tot));
            }
            //2.Watt Hour to Gram Calorie
            else if (sp1.getSelectedItem().toString() == "Watt Hour" && sp2.getSelectedItem().toString() == "Gram Calorie") {
                tot = amt*860.421;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f cal",tot));

            }
            //3.Watt Hour to Kilo Calorie
            else if (sp1.getSelectedItem().toString() == "Watt Hour" && sp2.getSelectedItem().toString() == "Kilo Calorie") {
                tot = amt*0.860421;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kcal",tot));

            }
            //4.Watt Hour to Joule
            else if (sp1.getSelectedItem().toString() == "Watt Hour" && sp2.getSelectedItem().toString() == "Joule") {
                tot = amt*3600;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f J",tot));

            }
            //5.Watt Hour to Kilowatt Hour
            else if (sp1.getSelectedItem().toString() == "Watt Hour" && sp2.getSelectedItem().toString() == "Kilowatt Hour") {
                tot = amt/1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kWh",tot));

            }
            /*
KILOWATT HOUR CONVERSION
 */
            //1.Kilowatt Hour to Kilo Joule
            else if (sp1.getSelectedItem().toString() == "Kilowatt Hour" && sp2.getSelectedItem().toString() == "Kilo Joule") {
                tot = amt*3600;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kJ",tot));
            }
            //2.Kilowatt Hour to Gram Calorie
            else if (sp1.getSelectedItem().toString() == "Kilowatt Hour" && sp2.getSelectedItem().toString() == "Gram Calorie") {
                tot = amt*860421;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f cal",tot));

            }
            //3.Kilowatt Hour to Kilo Calorie
            else if (sp1.getSelectedItem().toString() == "Kilowatt Hour" && sp2.getSelectedItem().toString() == "Kilo Calorie") {
                tot = amt*860.421;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f kcal",tot));

            }
            //4.Kilowatt Hour to Watt Hour
            else if (sp1.getSelectedItem().toString() == "Kilowatt Hour" && sp2.getSelectedItem().toString() == "Watt Hour") {
                tot = amt*1000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" +String.format("%.4f Wh",tot));

            }
            //5.Kilowatt Hour to Joule
            else if (sp1.getSelectedItem().toString() == "Kilowatt Hour" && sp2.getSelectedItem().toString() == "Joule") {
                tot = amt*3.6e+6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f J",tot));

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