package com.example.studentdetails;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        View view = findViewById(R.id.addStudentText);

        Snackbar.make(view, "Enter all details of new Student", Snackbar.LENGTH_LONG).show();
    }

    private void addStudent() {

    }


}
