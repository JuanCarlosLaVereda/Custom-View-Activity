package com.example.customviewactivity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private int grade;
    private CustomGradeView customGradeView;
    private Button buttonSubir;
    private Button buttonBajar;
    private Button buttonPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customGradeView = findViewById(R.id.customGradeView);
        customGradeView.setGrade(0);

        buttonBajar = findViewById(R.id.buttonBajar);
        buttonSubir = findViewById(R.id.buttonSubir);
        buttonPreferencias = findViewById(R.id.buttonPreferencias);

        buttonBajar.setOnClickListener(view -> {
            if(grade>0){
                customGradeView.setGrade(--grade);
            }
        });
        buttonSubir.setOnClickListener(view -> {
            if(grade<100){
                customGradeView.setGrade(++grade);
            }
        });

        ActivityResultLauncher resoultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_CANCELED || result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        //customGradeView = (CustomGradeView)data.getExtras().getSerializable("CustomGradeView");
                    }
                }
        );

        buttonPreferencias.setOnClickListener(view -> {
            Intent intent = new Intent(this, PreferenciasActivity.class);
            //intent.putExtra("CustomGradeView", customGradeView);
            resoultLauncher.launch(intent);
        });
    }
}