package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class reference extends AppCompatActivity {

    EditText etName, etEmail, etDesignation, etCompany;
    Button btnSubmit, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reference);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        btnSubmit.setOnClickListener((v)->{
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String designation = etDesignation.getText().toString().trim();
            String company = etCompany.getText().toString().trim();

            Intent intent = new Intent();
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            intent.putExtra("designation", designation);
            intent.putExtra("company",company);
            setResult(RESULT_OK,intent);
            finish();
        });
        btnCancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
    private void init(){
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etCompany = findViewById(R.id.etCompany);
        etDesignation = findViewById(R.id.etDesignation);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);
    }

}