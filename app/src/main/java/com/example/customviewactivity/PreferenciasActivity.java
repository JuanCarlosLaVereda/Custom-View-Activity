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

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

public class PreferenciasActivity extends AppCompatActivity {

    private EditText editTextGrades;
    private RadioGroup radioGroupBarColor;
    private Spinner spinnerTextColor;
    private EditText editTextTextSize;
    private Button buttonCancel;
    private Button buttonConfirm;
    private List<Integer> colors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
        Bundle extras = getIntent().getExtras();
        //CustomGradeView customGradeView = (CustomGradeView)extras.getSerializable("CustomGradeView");

        editTextGrades = findViewById(R.id.editTextNumberGrades);
        radioGroupBarColor = findViewById(R.id.radioGroupBarColors);
        spinnerTextColor = findViewById(R.id.spinnerTextColor);
        editTextTextSize = findViewById(R.id.editTextNumberSize);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonConfirm = findViewById(R.id.buttonConfirm);

        buttonCancel.setOnClickListener(view -> {
            Intent intent = new Intent();
            //intent.putExtra("CustomGradeView", (Serializable)customGradeView);
            setResult(RESULT_CANCELED, intent);
            finish();
        });
/*        if (savedInstanceState == null){
            colors.add(R.color.white);
            colors.add(R.color.black);
            colors.add(R.color.blue);
            colors.add(R.color.green);
            colors.add(R.color.red);
            colors.add(R.color.orange);
        }


        ArrayAdapter<Integer> miAdaptador =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colors);
        spinnerTextColor.setAdapter(miAdaptador);

        spinnerTextColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //customGradeView.getTextView().setTextColor(colors.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/


/*        buttonConfirm.setOnClickListener(view->{
            Intent intent = new Intent();
            intent.putExtra("CustomGradeView", (Serializable)customGradeView);
            setResult(RESULT_OK, intent);
            finish();
        });*/





    }
}
