package com.seneca.students;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    ArrayList<Student> students = new ArrayList<>();
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
        setUpStudents();

        RecyclerView rvStudents = findViewById(R.id.rvStudents);
        StudentAdapter studentAdapter = new StudentAdapter(this, students, this::onItemClick);
        rvStudents.setAdapter(studentAdapter);
        rvStudents.setLayoutManager(new LinearLayoutManager(this));
    }



    private void setUpStudents() {
        String[] studentNames = getResources().getStringArray(R.array.student_name);
        String[] studentPhone = getResources().getStringArray(R.array.phone);

        for (int i = 0; i < studentNames.length; i++){
            int imageResId = getResources().getIdentifier("_" + (i + 1), "drawable", getPackageName());
            students.add(new Student(studentNames[i], studentPhone[i], imageResId));
        }
    }

    @Override
    public void onItemClick(int position) {
        // Get the clicked student
        Student clickedStudent = students.get(position);

        // Create an Intent to start DetailActivity
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("student", clickedStudent); // Pass the student object

        // Start DetailActivity
        startActivity(intent);
    }

}