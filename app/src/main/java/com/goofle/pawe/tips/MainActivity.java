package com.goofle.pawe.tips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    String[] items = new String[]{"30% - Wspaniale", "20% - Dobrze", "15% - W porządku", "10% - Źle", "5% - Okropnie"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner dropdown = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final EditText billEditText = (EditText)findViewById(R.id.bill);
        final EditText peopleEditText = (EditText)findViewById(R.id.people);


        Button calculate = (Button)findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String spinnerValue = spinner.getSelectedItem().toString();
                final double procent;

                if(spinnerValue.equals("30% - Wspaniale"))
                    procent = 0.3;
                else if (spinnerValue.equals("20% - Dobrze"))
                    procent = 0.2;
                else if (spinnerValue.equals("15% - W porządku"))
                    procent = 0.15;
                else if (spinnerValue.equals("10% - Źle"))
                    procent = 0.1;
                else
                    procent = 0.05;

                double bill = Double.parseDouble(billEditText.getText().toString());
                double people = Double.parseDouble(peopleEditText.getText().toString());
                double tip = (bill * procent) / people;
                DecimalFormat df = new DecimalFormat("##.##");

                final TextView tipp = (TextView)findViewById(R.id.tip);
                tipp.setText("Sugerowany napiwek: "+df.format(tip) + " zł");


                if (people != 1) {
                    final TextView each = (TextView) findViewById(R.id.each);
                    each.setText("na osobę!");
                } else {
                    final TextView each = (TextView) findViewById(R.id.each);
                    each.setText("");
                }

            }
        });


    }
}
