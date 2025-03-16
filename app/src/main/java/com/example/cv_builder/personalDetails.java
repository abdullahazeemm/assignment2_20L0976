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

public class personalDetails extends AppCompatActivity {
     EditText etName, etEmail, etPhoneNumber, etAddress;
     RadioGroup rgGender;
     Button btnSubmit, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        btnSubmit.setOnClickListener((v)->{
            String gender = "";
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phoneNum  = etPhoneNumber.getText().toString().trim();
            String address = etAddress.getText().toString().trim();
            int id = rgGender.getCheckedRadioButtonId();
            if(id != -1){
                RadioButton selectedRadio = findViewById(id);
                gender = selectedRadio.getText().toString().trim();
            }
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            intent.putExtra("phone", phoneNum);
            intent.putExtra("address",address);
            intent.putExtra("gender",gender);
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
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etAddress = findViewById(R.id.etAddress);
        rgGender = findViewById(R.id.rgAnswer);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);
    }
}