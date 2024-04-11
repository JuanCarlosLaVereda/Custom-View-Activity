package com.example.customviewactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PreferenciasActivity extends AppCompatActivity {

    private EditText editTextGrades;
    private RadioGroup radioGroupBarColor;
    private Spinner spinnerTextColor;
    private EditText editTextTextSize;
    private Button buttonCancel;
    private Button buttonConfirm;
    private List<String> colors;
    private int grade;
    private int textColor;
    private int barColor;
    private int textSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
        Bundle extras = getIntent().getExtras();
        grade = extras.getInt("grade");
        barColor = extras.getInt("barColor");
        textColor = extras.getInt("textColor");
        textSize = extras.getInt("textSize");

        editTextGrades = findViewById(R.id.editTextNumberGrades);
        radioGroupBarColor = findViewById(R.id.radioGroupBarColors);
        spinnerTextColor = findViewById(R.id.spinnerTextColor);
        editTextTextSize = findViewById(R.id.editTextNumberSize);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonConfirm = findViewById(R.id.buttonConfirm);


        radioGroupBarColor.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i==R.id.radioButtonBlack){
                barColor = R.color.black;
            } else if (i==R.id.radioButtonWhite) {
                barColor = R.color.white;
            } else if (i==R.id.radioButtonBlue) {
                barColor = R.color.blue;
            } else if (i==R.id.radioButtonGreen) {
                barColor = R.color.green;
            } else if (i==R.id.radioButtonRed) {
                barColor = R.color.red;
            } else if (i==R.id.radioButtonOrange) {
                barColor = R.color.orange;
            } else {
                barColor = R.color.black;
            }
        });

        if (savedInstanceState == null){
            colors = new ArrayList<>();
            colors.add("White");
            colors.add("Black");
            colors.add("Blue");
            colors.add("Green");
            colors.add("Red");
            colors.add("Orange");
        }


        ArrayAdapter<String> miAdaptador =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colors);
        spinnerTextColor.setAdapter(miAdaptador);

        spinnerTextColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (colors.get(position).toString().equals("White")){
                    textColor = R.color.white;
                } else if (colors.get(position).toString().equals("Black")){
                    textColor = R.color.black;
                } else if (colors.get(position).toString().equals("Blue")){
                    textColor = R.color.blue;
                } else if (colors.get(position).toString().equals("Green")) {
                    textColor = R.color.green;
                } else if (colors.get(position).toString().equals("Red")) {
                    textColor = R.color.red;
                } else if (colors.get(position).toString().equals("Orange")) {
                    textColor = R.color.orange;
                } else {
                    textColor = R.color.blue;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


       buttonConfirm.setOnClickListener(view->{
           if (!editTextGrades.getText().toString().equals("") && !editTextTextSize.getText().toString().equals("")){
               if (Integer.parseInt(editTextGrades.getText().toString())>100 || Integer.parseInt(editTextTextSize.getText().toString())>60){
                   Toast.makeText(this, "Los valores no pueden ser mas que 100 y 60 para el tamaño del texto", Toast.LENGTH_SHORT).show();
               } else {
                   Intent intent = new Intent();
                   intent.putExtra("grade", Integer.parseInt(editTextGrades.getText().toString()));
                   intent.putExtra("barColor", barColor);
                   intent.putExtra("textColor", textColor);
                   intent.putExtra("textSize", Integer.parseInt(editTextTextSize.getText().toString()));
                   setResult(RESULT_OK, intent);
                   finish();
               }
           } else {
               Toast.makeText(this, "Faltan por poner algunos valores", Toast.LENGTH_SHORT).show();
           }
        });

        buttonCancel.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("grade", grade);
            intent.putExtra("barColor", barColor);
            intent.putExtra("textColor", textColor);
            intent.putExtra("textSize", textSize);
            setResult(RESULT_CANCELED, intent);
            finish();
        });






    }
}
