package com.example.studentdetails;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentDetailsActivity extends AppCompatActivity {
    final String TAG = "StudentDetailsActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Bundle extras = getIntent().getExtras();
        Student stu = (Student) extras.get("student");

        TextView name = findViewById(R.id.nameTextView);
        TextView gender = findViewById(R.id.genderTextView);
        TextView dob = findViewById(R.id.dateOfBirthTextView);
        TextView address = findViewById(R.id.addressTextView);
        TextView postcode = findViewById(R.id.postcodeTextView);
        TextView studentNumber = findViewById(R.id.studentNumberTextView);
        TextView courseTitle = findViewById(R.id.courseTitleTextView);
        TextView startDate = findViewById(R.id.startDateTextView);
        TextView bursary = findViewById(R.id.bursaryTextView);
        TextView email = findViewById(R.id.emailTextView);

        name.setTypeface(name.getTypeface(), Typeface.BOLD);
        name.setText(stu.getName());
        gender.setText(stu.getGender());
        dob.setText(stu.getDob());
        address.setText(stu.getAddress());
        postcode.setText(stu.getPostcode());
        studentNumber.setText(Integer.toString(stu.getStudentNumber()));
        courseTitle.setText(stu.getCourseTitle());
        startDate.setText(stu.getStartDate());
        bursary.setText(Double.toString(stu.getBursary()));
        email.setText(stu.getEmail());
    }
}
