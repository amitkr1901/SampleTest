package com.example.akumar.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by akumar on 7/11/2017.
 */

public class StudentDetail extends AppCompatActivity {

    TextView studentName, date_of_birth, gender, passing_mark, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentdetail);

        studentName = (TextView) findViewById(R.id.studentName);
        date_of_birth = (TextView) findViewById(R.id.date_of_birth);
        gender = (TextView) findViewById(R.id.gender);
        passing_mark = (TextView) findViewById(R.id.passing_mark);
        address = (TextView) findViewById(R.id.address);

        StudentModel studentModel = (StudentModel) getIntent().getSerializableExtra("studentDetail");

        studentName.setText(studentModel.getName());
        date_of_birth.setText(studentModel.getDate_of_birth());
        gender.setText(studentModel.getGender());
        passing_mark.setText(studentModel.getPassing_mark());
        address.setText(studentModel.getAddress());

    }
}