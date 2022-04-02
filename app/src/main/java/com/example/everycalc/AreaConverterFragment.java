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


public class AreaConverterFragment extends Fragment {

    Spinner sp1, sp2;
    EditText ed1;
    TextView answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_area_converter, container, false);

        sp1 = view.findViewById(R.id.from);
        sp2 = view.findViewById(R.id.spto);
        ed1 = view.findViewById(R.id.text_input);
        answer = view.findViewById(R.id.textView_Result);


        String[] from = {"Square foot", "Square inch", "Square yard", "Square meter", "Square kilometer", "Hectare", "Acre"};
        ArrayAdapter ad = new ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);


        String[] to = {"Square foot", "Square inch", "Square yard", "Square meter", "Square kilometer", "Hectare", "Acre"};
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
SQUARE FOOT CONVERSION
 */
            //1.Square Foot to Square inch
            if (sp1.getSelectedItem().toString() == "Square foot" && sp2.getSelectedItem().toString() == "Square inch") {
                tot = amt * 144;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f in²",tot));
            }
            //2.Square foot to Square yard
            else if (sp1.getSelectedItem().toString() == "Square foot" && sp2.getSelectedItem().toString() == "Square yard") {
                tot = amt/9;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f yard²",tot));

            }
            //3.Square foot to Square meter
            else if (sp1.getSelectedItem().toString() == "Square foot" && sp2.getSelectedItem().toString() == "Square meter") {
                tot = amt/10.764;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m²",tot));

            }
            //4.Square foot to Square kilometer
            else if (sp1.getSelectedItem().toString() == "Square foot" && sp2.getSelectedItem().toString() == "Square kilometer") {
                tot = amt/1.076e+7;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f km²",tot));

            }
            //5.Square foot to Hectare
            else if (sp1.getSelectedItem().toString() == "Square foot" && sp2.getSelectedItem().toString() == "Hectare") {
                tot = amt/107639;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ha",tot));

            }
            //6.Square foot to acre
            else if (sp1.getSelectedItem().toString() == "Square foot" && sp2.getSelectedItem().toString() == "Acre") {
                tot = amt/43560;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ac",tot));

            }
/*
SQUARE INCH CONVERSION
*/
            //1.Square inch to Square foot
            else if (sp1.getSelectedItem().toString() == "Square inch" && sp2.getSelectedItem().toString() == "Square foot") {
                tot = amt/144;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft²",tot));
            }
            //2.Square inch to Square yard
            else if (sp1.getSelectedItem().toString() == "Square inch" && sp2.getSelectedItem().toString() == "Square yard") {
                tot = amt/1296;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f yard²",tot));

            }
            //3.Square inch to Square meter
            else if (sp1.getSelectedItem().toString() == "Square inch" && sp2.getSelectedItem().toString() == "Square meter") {
                tot = amt/1550;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m²",tot));

            }
            //4.Square inch to Square kilometer
            else if (sp1.getSelectedItem().toString() == "Square inch" && sp2.getSelectedItem().toString() == "Square kilometer") {
                tot = amt/1.55e+9;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f km²",tot));

            }
            //5.Square inch to Hectare
            else if (sp1.getSelectedItem().toString() == "Square inch" && sp2.getSelectedItem().toString() == "Hectare") {
                tot = amt/1.55e+7;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ha",tot));

            }
            //6.Square inch to acre
            else if (sp1.getSelectedItem().toString() == "Square inch" && sp2.getSelectedItem().toString() == "Acre") {
                tot = amt/6.273e+6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ac",tot));

            }
/*
SQUARE YARD CONVERSION
*/
            //1.Square yard to Square foot
            else if (sp1.getSelectedItem().toString() == "Square yard" && sp2.getSelectedItem().toString() == "Square foot") {
                tot = amt*9;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft²",tot));
            }
            //2.Square yard to Square yard
            else if (sp1.getSelectedItem().toString() == "Square yard" && sp2.getSelectedItem().toString() == "Square inch") {
                tot = amt*1296;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f in²",tot));

            }
            //3.Square yard to Square meter
            else if (sp1.getSelectedItem().toString() == "Square yard" && sp2.getSelectedItem().toString() == "Square meter") {
                tot = amt/1.196;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m²",tot));

            }
            //4.Square yard to Square kilometer
            else if (sp1.getSelectedItem().toString() == "Square yard" && sp2.getSelectedItem().toString() == "Square kilometer") {
                tot = amt/1.196e+6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f km²",tot));

            }
            //5.Square yard to Hectare
            else if (sp1.getSelectedItem().toString() == "Square yard" && sp2.getSelectedItem().toString() == "Hectare") {
                tot = amt/11960;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ha",tot));

            }
            //6.Square yard to acre
            else if (sp1.getSelectedItem().toString() == "Square yard" && sp2.getSelectedItem().toString() == "Acre") {
                tot = amt/4840;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ac",tot));

            }
            /*
SQUARE METER CONVERSION
*/
            //1.Square meter to Square foot
            else if (sp1.getSelectedItem().toString() == "Square meter" && sp2.getSelectedItem().toString() == "Square foot") {
                tot = amt*10.764;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft²",tot));
            }
            //2.Square meter to Square inch
            else if (sp1.getSelectedItem().toString() == "Square meter" && sp2.getSelectedItem().toString() == "Square inch") {
                tot = amt*1550;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f in²",tot));

            }
            //3.Square meter to Square yard
            else if (sp1.getSelectedItem().toString() == "Square meter" && sp2.getSelectedItem().toString() == "Square yard") {
                tot = amt*1.196;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f yard²",tot));

            }
            //4.Square meter to Square kilometer
            else if (sp1.getSelectedItem().toString() == "Square meter" && sp2.getSelectedItem().toString() == "Square kilometer") {
                tot = amt/1e+6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f km²",tot));

            }
            //5.Square meter to Hectare
            else if (sp1.getSelectedItem().toString() == "Square meter" && sp2.getSelectedItem().toString() == "Hectare") {
                tot = amt/10000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ha",tot));

            }
            //6.Square meter to acre
            else if (sp1.getSelectedItem().toString() == "Square meter" && sp2.getSelectedItem().toString() == "Acre") {
                tot = amt/4047;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ac",tot));

            }

            /*
SQUARE KILOMETER CONVERSION
*/
            //1.Square kilometer to Square foot
            else if (sp1.getSelectedItem().toString() == "Square kilometer" && sp2.getSelectedItem().toString() == "Square foot") {
                tot = amt*1.076e+7;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft²",tot));
            }
            //2.Square kilometer to Square inch
            else if (sp1.getSelectedItem().toString() == "Square kilometer" && sp2.getSelectedItem().toString() == "Square inch") {
                tot = amt*1.55e+9;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f in²",tot));

            }
            //3.Square kilometer to Square yard
            else if (sp1.getSelectedItem().toString() == "Square kilometer" && sp2.getSelectedItem().toString() == "Square yard") {
                tot = amt*1.196e+6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f yard²",tot));

            }
            //4.Square kilometer to Square meter
            else if (sp1.getSelectedItem().toString() == "Square kilometer" && sp2.getSelectedItem().toString() == "Square meter") {
                tot = amt*1e+6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m²",tot));

            }
            //5.Square kilometer to Hectare
            else if (sp1.getSelectedItem().toString() == "Square kilometer" && sp2.getSelectedItem().toString() == "Hectare") {
                tot = amt*100;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ha",tot));

            }
            //6.Square kilometer to acre
            else if (sp1.getSelectedItem().toString() == "Square kilometer" && sp2.getSelectedItem().toString() == "Acre") {
                tot = amt*247.105;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ac",tot));

            }
            /*
HECTARE CONVERSION
*/
            //1.Hectare to Square foot
            else if (sp1.getSelectedItem().toString() == "Hectare" && sp2.getSelectedItem().toString() == "Square foot") {
                tot = amt*107639;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft²",tot));
            }
            //2.Hectare to Square inch
            else if (sp1.getSelectedItem().toString() == "Hectare" && sp2.getSelectedItem().toString() == "Square inch") {
                tot = amt*1.55e+7;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f in²",tot));

            }
            //3.Hectare to Square yard
            else if (sp1.getSelectedItem().toString() == "Hectare" && sp2.getSelectedItem().toString() == "Square yard") {
                tot = amt*11960;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f yard²",tot));

            }
            //4.Hectare to Square meter
            else if (sp1.getSelectedItem().toString() == "Hectare" && sp2.getSelectedItem().toString() == "Square meter") {
                tot = amt*10000;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m²",tot));

            }
            //5.Hectare to Square kilometer
            else if (sp1.getSelectedItem().toString() == "Hectare" && sp2.getSelectedItem().toString() == "Square kilometer") {
                tot = amt/100;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f km²",tot));

            }
            //6.Hectare to acre
            else if (sp1.getSelectedItem().toString() == "Hectare" && sp2.getSelectedItem().toString() == "Acre") {
                tot = amt*2.47105;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ac",tot));

            }
            /*
ACRE CONVERSION
*/
            //1.Acre to Square foot
            else if (sp1.getSelectedItem().toString() == "Acre" && sp2.getSelectedItem().toString() == "Square foot") {
                tot = amt*43560;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ft²",tot));
            }
            //2.Acre to Square inch
            else if (sp1.getSelectedItem().toString() == "Acre" && sp2.getSelectedItem().toString() == "Square inch") {
                tot = amt*6.273e+6;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f in²",tot));

            }
            //3.Acre to Square yard
            else if (sp1.getSelectedItem().toString() == "Acre" && sp2.getSelectedItem().toString() == "Square yard") {
                tot = amt*4840;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f yard²",tot));

            }
            //4.Acre to Square meter
            else if (sp1.getSelectedItem().toString() == "Acre" && sp2.getSelectedItem().toString() == "Square meter") {
                tot = amt*4046.86;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f m²",tot));

            }
            //5.Acre to Square kilometer
            else if (sp1.getSelectedItem().toString() == "Acre" && sp2.getSelectedItem().toString() == "Square kilometer") {
                tot = amt/247;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f km²",tot));

            }
            //6.Acre to Hectare
            else if (sp1.getSelectedItem().toString() == "Acre" && sp2.getSelectedItem().toString() == "Hectare") {
                tot = amt/2.47105;
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + String.format("%.4f ha",tot));

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