package com.example.recyclerviews;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button add = findViewById(R.id.addStudentBtn);
        Button check = findViewById(R.id.checkStudentBtn);
        Button log = findViewById(R.id.logSortedGradesBtn);

        EditText name = findViewById(R.id.etStudentName);
        EditText grade = findViewById(R.id.etGrade);
        EditText query = findViewById(R.id.etStudentQuery);
        TextView txt = findViewById(R.id.tvStudentGrade);

        ArrayList<Student> students = new ArrayList<Student>();
        //Student student = new Student(name.getText().toString(), Integer.parseInt(grade.getText().toString()));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student tempStudent = new Student();
                tempStudent.name = name.getText().toString();
                tempStudent.score = Integer.parseInt(grade.getText().toString());
                students.add(tempStudent);
                Log.d("MainActivity", "Student add:" + tempStudent.name + " " + tempStudent.score);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et = query.getText().toString();
                for(Student student : students){
                    if(student.name.equals(et)){
                        txt.setText(student.toString());
                    }
                }
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}