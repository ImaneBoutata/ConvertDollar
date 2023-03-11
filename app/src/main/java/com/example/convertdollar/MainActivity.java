package com.example.convertdollar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     Button btn;
     EditText editText;
     TextView textView2;
     TextView textView3;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =findViewById(R.id.button);
        editText = findViewById(R.id.editTextNumber);
        spinner = findViewById(R.id.spinner);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });

        ArrayList<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("MAD");
        spinnerArray.add("DOLLAR");
        spinnerArray.add("EURO");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void convert(){
        /*String valeur = editText.getText().toString();
        if(valeur.equals("")){
            Toast.makeText(this, "Enter valid number ",Toast.LENGTH_SHORT).show();

        }else{
            Double convertedValue = Double.parseDouble(valeur);
            Double bbb = convertedValue * 10.42;
            String cc= bbb.toString();
            Toast.makeText(this,"Amount in Dollar is "+ cc, Toast.LENGTH_SHORT).show();
        }*/

        String selected = spinner.getSelectedItem().toString();
        double number = Double.parseDouble(editText.getText().toString());
        if (selected=="MAD"){
            double dollar = number * 0.098;
            double euro = number * 0.090;
            textView2.setText(dollar + " DOLLAR");
            textView3.setText(euro + " EURO");
        } else if (selected=="DOLLAR") {
            double mad = number * 10.46;
            double euro = number * 0.95;
            textView2.setText(mad + " MAD");
            textView3.setText(euro + " EURO");
        } else if (selected=="EURO") {
            double mad = number * 11.06;
            double dollar = number * 1.06;
            textView2.setText(mad + " MAD");
            textView3.setText(dollar + " DOLLAR");
        }
    }
}