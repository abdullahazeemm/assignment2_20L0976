package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class education extends AppCompatActivity {

    EditText etName, etInstitute, etGPA;
    Button btnSubmit, btnCancel;
    Spinner sStart, sEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        btnSubmit.setOnClickListener((v)->{
            String name = etName.getText().toString().trim();
            String institute = etInstitute.getText().toString().trim();
            String Gpa  = etGPA.getText().toString().trim();
            String yearStart = sStart.getSelectedItem().toString();
            String yearEnd = sEnd.getSelectedItem().toString();

            Intent intent = new Intent();
            intent.putExtra("name",name);
            intent.putExtra("institute",institute);
            intent.putExtra("Gpa", Gpa);
            intent.putExtra("yearStart", yearStart);
            intent.putExtra("yearEnd", yearEnd);
            setResult(RESULT_OK,intent);
            finish();
        });
        btnCancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
    private void init(){
        etName = findViewById(R.id.etDegree);
        etInstitute = findViewById(R.id.etInstitute);
        etGPA = findViewById(R.id.etGPA);
        sStart = findViewById(R.id.sStart);
        sEnd = findViewById(R.id.sEnd);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        List<String> years = new ArrayList<>();
        for (int i = 1950; i <= 2025; i++) {
            years.add(String.valueOf(i));
        }
        years.add("Present");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years);
        sStart.setAdapter(adapter);
        sEnd.setAdapter(adapter);
        int defaultYearIndex = years.indexOf("2020");
        sStart.setSelection(defaultYearIndex);
        sEnd.setSelection(defaultYearIndex);
    }
}