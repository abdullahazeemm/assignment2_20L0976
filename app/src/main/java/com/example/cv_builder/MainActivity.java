package com.example.cv_builder;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Button btnProfilePicture, btnPersonalDetails, btnSummary, btnEducation, btnExperience, btnCertifications, btnReferences, btnSubmit;
    ActivityResultLauncher<Intent> launcherProfilePic, launcherPersonalDetails,launcherSummary, launcherEducation,launcherExperience, launcherCertifications, launcherReferences;
    personalDetailsData p1;
    certificationData c1;
    educationData e1;
    summaryData s1;
    referenceData r1;
    experienceData ex1;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();

       launcherProfilePic = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        imageUri = result.getData().getData();
                    }
                }
        );
        launcherPersonalDetails = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        assert data != null;
                        p1.namePerson = data.getStringExtra("name");
                        p1.email = data.getStringExtra("email");
                        p1.address = data.getStringExtra("address");
                        p1.phoneNum = data.getStringExtra("phone");
                        p1.gender = data.getStringExtra("gender");
                    }
                }
        );
        launcherSummary = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        s1.summary = data.getStringExtra("summary");
                    }
                }
        );
        launcherEducation = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        e1.name = data.getStringExtra("name");
                        e1.institute = data.getStringExtra("institute");
                        e1.GPA = data.getStringExtra("Gpa");
                        e1.yearStart = data.getStringExtra("yearStart");
                        e1.yearEnd = data.getStringExtra("yearEnd");
                    }
                }
        );
        launcherExperience = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        ex1.job = data.getStringExtra("Job");
                        ex1.company = data.getStringExtra("company");
                        ex1.start = data.getStringExtra("yearStart");
                        ex1.end = data.getStringExtra("yearEnd");
                    }
                }
        );
        launcherCertifications = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        c1.name = data.getStringExtra("name");
                        c1.organization = data.getStringExtra("org");
                        c1.year = data.getStringExtra("year");
                    }
                }
        );
        launcherReferences = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        r1.name = data.getStringExtra("name");
                        r1.company = data.getStringExtra("company");
                        r1.designation = data.getStringExtra("designation");
                        r1.email = data.getStringExtra("email");
                    }
                }
        );

        btnProfilePicture.setOnClickListener((v)->{
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            launcherProfilePic.launch(intent);
        });
        btnPersonalDetails.setOnClickListener((v)->{
            Intent intent = new Intent(this, personalDetails.class);
            launcherPersonalDetails.launch(intent);
        });
        btnSummary.setOnClickListener((v)->{
            Intent intent = new Intent(this, summary.class);
            launcherSummary.launch(intent);
        });
        btnEducation.setOnClickListener((v)->{
            Intent intent = new Intent(this, education.class);
            launcherEducation.launch(intent);
        });
        btnExperience.setOnClickListener((v)->{
            Intent intent = new Intent(this, experience.class);
            launcherExperience.launch(intent);
        });
        btnCertifications.setOnClickListener((v)->{
            Intent intent = new Intent(this, certification.class);
            launcherCertifications.launch(intent);
        });
        btnReferences.setOnClickListener((v)->{
            Intent intent = new Intent(this, reference.class);
            launcherReferences.launch(intent);
        });

        btnSubmit.setOnClickListener((v)->{
            Intent intent = new Intent(this, CV.class);
            intent.putExtra("pictureProfile", imageUri.toString());
            intent.putExtra("name", p1.namePerson);
            intent.putExtra("personMail", p1.email);
            intent.putExtra("personAddress", p1.address);
            intent.putExtra("personGender", p1.gender);
            intent.putExtra("personPhone", p1.phoneNum);
            intent.putExtra("summary",s1.summary);
            intent.putExtra("certificationName", c1.name);
            intent.putExtra("certificationYear", c1.year);
            intent.putExtra("certificationOrg", c1.organization);
            intent.putExtra("educationName", e1.name);
            intent.putExtra("instituteName", e1.institute);
            intent.putExtra("GPA", e1.GPA);
            intent.putExtra("degreeSYear", e1.yearEnd);
            intent.putExtra("degreeEYear", e1.yearEnd);
            intent.putExtra("refName", r1.name);
            intent.putExtra("refMail", r1.email);
            intent.putExtra("refCompany", r1.company);
            intent.putExtra("refDesignation", r1.designation);
            intent.putExtra("exCompany", ex1.company);
            intent.putExtra("exJob", ex1.job);
            intent.putExtra("exStart", ex1.start);
            intent.putExtra("exEnd", ex1.end);
            startActivity(intent);
            finish();
        });

    }
    private void init(){
        btnProfilePicture = findViewById(R.id.btnProfilePic);
        btnPersonalDetails = findViewById(R.id.btnPersonalDetails);
        btnSummary = findViewById(R.id.btnSummary);
        btnEducation = findViewById(R.id.btnEducation);
        btnExperience = findViewById(R.id.btnExperience);
        btnCertifications = findViewById(R.id.btnCertifications);
        btnReferences = findViewById(R.id.btnReferences);
        btnSubmit = findViewById(R.id.btnSubmit);
        p1 = new personalDetailsData("", "", "", "", "");
        s1 = new summaryData("");
        e1 = new educationData("", "", "", "", "");
        ex1 = new experienceData("", "", "", "");
        c1 = new certificationData("", "", "");
        r1 = new referenceData("", "", "", "");
    }
    public class personalDetailsData implements Serializable {
        public String address, phoneNum, namePerson, email, gender;

        public personalDetailsData(String name, String mail, String num, String homeAddress, String gen){
            namePerson = name;
            email = mail;
            phoneNum = num;
            address = homeAddress;
            gender = gen;
        }
    }
    public class certificationData implements Serializable{
        public String name, year, organization;

        certificationData(String nam, String yearr, String org){
            name = nam;
            year = yearr;
            organization = org;
        }
    }

    public class educationData implements Serializable{
        public String name, institute, GPA, yearStart, yearEnd;

        educationData(String nam, String instit, String gpa, String start, String end){
            name = nam;
            institute = instit;
            GPA = gpa;
            yearStart = start;
            yearEnd = end;
        }
    }

    public class summaryData implements Serializable {
        public String summary;

        summaryData(String summ){
            summary=summ;
        }
    }

    public class referenceData implements Serializable{
        public String name, email, designation, company;

        referenceData(String person, String mail, String desig, String comp){
            name = person;
            email = mail;
            designation = desig;
            company = comp;
        }
    }

    public class experienceData implements Serializable{
        public String job, company, start,end;
        experienceData(String Job, String Company, String Start, String End){
            job=Job;
            company=Company;
            start=Start;
            end=End;
        }
    }
}