package com.seneca.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Lifecycle Activity", "Steven David Pillay's log: OnCreate Method Called Activity 1");
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.etName);
        EditText etLastName = findViewById(R.id.etLastName);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etConfirmEmail = findViewById(R.id.etConfirmEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        EditText etConfirmPassword = findViewById(R.id.etConfirmPassword);
        EditText etDateOfBirth = findViewById(R.id.etDateOfBirth);
        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = etName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String confirmEmail = etConfirmEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();
                String dateOfBirth = etDateOfBirth.getText().toString().trim();

                Intent activityThreeIntent = new Intent(getApplicationContext(), SecondActivity.class);
                //Sending Data to next intent
                activityThreeIntent.putExtra("FirstName", firstName);
                activityThreeIntent.putExtra("LastName", lastName);
                activityThreeIntent.putExtra("Email", email);
                activityThreeIntent.putExtra("ConfirmEmail", confirmEmail);
                activityThreeIntent.putExtra("Password", password);
                activityThreeIntent.putExtra("ConfirmPassword", confirmPassword);
                activityThreeIntent.putExtra("DateOfBirth", dateOfBirth);
                startActivity(activityThreeIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onStart Method Called");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onRestart Method Called Activity 1");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onResume Method Called Activity 1");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onPause Method Called Activity 1");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onStop Method Called Activity 1");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onDestroy Method Called Activity 1");

    }
}