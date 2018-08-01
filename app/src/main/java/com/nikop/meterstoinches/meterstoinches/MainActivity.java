package com.nikop.meterstoinches.meterstoinches;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText enterUnit;
    private Button convertButton;
    private TextView resultTextView;
    private Button clearButton;
    private Spinner spinner;
    private int pos = 0;

    public void ifEmptyEdittext() {
        resultTextView.setText(R.string.error_message);
        resultTextView.setTextColor(Color.RED);
        resultTextView.setVisibility(View.VISIBLE);
    }
    // This is the final change :)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterUnit=findViewById(R.id.metersEditText);
        convertButton=findViewById(R.id.convertButtonId);
        resultTextView=findViewById(R.id.resultId);
        clearButton=findViewById(R.id.clearButtonId);
        spinner=findViewById(R.id.spinnerID);

        /* Populating the spinner with our @string/Conversions
           Specifying that our spinner will be a dropdown menu
           Assigning adapter to spinner
        */
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.Conversions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Event for the Spinner so we know that it is selected
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos=position;
                if (pos == 0) {
                    enterUnit.setHint("Enter in Meters");
                } else if (pos == 1) {
                    enterUnit.setHint("Enter in Inches");
                } else if (pos == 2) {
                    enterUnit.setHint("Enter in Feet");
                } else if (pos == 3) {
                    enterUnit.setHint("Enter in Yards");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double result;

                if (pos == 0) {
                    // Conversion Logic for meters to inches
                    double oneMeter=39.37;

                    if (enterUnit.getText().toString().equals("")) {
                        ifEmptyEdittext();
                    } else {
                        double meterValue=Double.parseDouble(enterUnit.getText().toString());
                        result=meterValue * oneMeter;

                        // Use String format to round number
                        resultTextView.setText(String.format("%.2f", result) + " inches");
                        resultTextView.setTextColor(Color.BLACK);
                        resultTextView.setVisibility(View.VISIBLE);
                    }
                } else if (pos == 1) {
                        // Conversion logic for inches to meters
                        double oneInch=0.0254;

                        if (enterUnit.getText().toString().equals("")) {
                           ifEmptyEdittext();
                        } else {
                            double inchValue=Double.parseDouble(enterUnit.getText().toString());
                            result=inchValue * oneInch;

                            resultTextView.setText(String.format("%.2f", result) + " meters");
                            resultTextView.setTextColor(Color.BLACK);
                            resultTextView.setVisibility(View.VISIBLE);
                    }
                } else if (pos == 2) {
                    // Conversion logic for feet to yards
                    double oneFoot=0.333333;

                    if (enterUnit.getText().toString().equals("")) {
                        ifEmptyEdittext();
                    } else {
                        double yardValue=Double.parseDouble(enterUnit.getText().toString());
                        result=yardValue * oneFoot;

                        resultTextView.setText(String.format("%.2f", result) + " yards");
                        resultTextView.setTextColor(Color.BLACK);
                        resultTextView.setVisibility(View.VISIBLE);
                    }
                } else if (pos == 3) {
                    // Conversion logic for yards to feet
                    double oneYard=3;

                    if (enterUnit.getText().toString().equals("")) {
                        ifEmptyEdittext();
                    } else {
                        double inchValue=Double.parseDouble(enterUnit.getText().toString());
                        result=inchValue * oneYard;

                        if (inchValue >= 0.332 && inchValue <= 0.334) {
                            resultTextView.setText(String.format("%.2f", result) + " foot");
                        } else {
                            resultTextView.setText(String.format("%.2f", result) + " feet");
                        }
                        resultTextView.setTextColor(Color.BLACK);
                        resultTextView.setVisibility(View.VISIBLE);
                    }
                } else if (pos == 4) {
                    // Conversion logic for inches to feet
                    double oneInch=0.083333;

                    if (enterUnit.getText().toString().equals("")) {
                        ifEmptyEdittext();;
                    }  else {
                        double inchValue=Double.parseDouble(enterUnit.getText().toString());
                        result=inchValue * oneInch;

                        // Use string format to round number
                        resultTextView.setText(String.format("%.2f", result) + " yards");
                        resultTextView.setTextColor(Color.BLACK);
                        resultTextView.setVisibility(View.VISIBLE);
                    }
                } else if (pos == 5) {
                    // Conversion logic for feet to inches
                    double oneFoot=12;

                    if (enterUnit.getText().toString().equals("")) {
                        ifEmptyEdittext();;
                    }  else {
                        double inchValue=Double.parseDouble(enterUnit.getText().toString());
                        result=inchValue * oneFoot;

                        // Use string format to round number
                        resultTextView.setText(String.format("%.2f", result) + " yards");
                        resultTextView.setTextColor(Color.BLACK);
                        resultTextView.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterUnit.setText("");
                resultTextView.setVisibility(View.INVISIBLE);
            }
        });
    }
}