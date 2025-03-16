package com.example.cv_builder;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;

public class CV extends AppCompatActivity {

    TextView tvName, tvPersonalDetail, tvSummary, tvExperience, tvEducation, tvReference, tvCertification;
    ImageView ivProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cv);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("name"));
        tvPersonalDetail.setText(intent.getStringExtra("personMail")+"\n"+intent.getStringExtra("personAddress")+"\n"+intent.getStringExtra("personGender")+"\n"+intent.getStringExtra("personPhone"));
        tvSummary.setText(intent.getStringExtra("summary"));
        tvExperience.setText(intent.getStringExtra("exJob")+"\n"+intent.getStringExtra("exCompany")+"\n"+intent.getStringExtra("exStart")+"-"+intent.getStringExtra("exEnd"));
        tvEducation.setText(intent.getStringExtra("educationName")+"\n"+intent.getStringExtra("instituteName")+"\n"+intent.getStringExtra("GPA")+"\n"+intent.getStringExtra("degreeSYear")+"-"+intent.getStringExtra("degreeEyear"));
        tvReference.setText(intent.getStringExtra("refName")+"\n"+intent.getStringExtra("refDesignation")+"\n"+intent.getStringExtra("refCompany")+"\n"+intent.getStringExtra("refMail"));
        tvCertification.setText(intent.getStringExtra("certificationName")+"\n"+intent.getStringExtra("certificationOrg")+"\n"+intent.getStringExtra("certificationYear"));
        String uriString = intent.getStringExtra("pictureProfile");
        if (uriString != null) {
            Uri imageUri = Uri.parse(uriString);
            ivProfile.setImageURI(imageUri);
        }
    }
    public void init(){
        tvName = findViewById(R.id.tvName);
        ivProfile = findViewById(R.id.ivProfilePic);
        tvPersonalDetail = findViewById(R.id.tvPersonalDetail);
        tvSummary = findViewById(R.id.tvSummary);
        tvExperience = findViewById(R.id.tvExperience);
        tvEducation = findViewById(R.id.tvEducation);
        tvReference = findViewById(R.id.tvReferences);
        tvCertification = findViewById(R.id.tvCertification);
        ivProfile = findViewById(R.id.ivProfilePic);
    }

}