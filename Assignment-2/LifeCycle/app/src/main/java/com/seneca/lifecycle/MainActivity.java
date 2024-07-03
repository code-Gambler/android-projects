package com.seneca.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                activityThreeIntent.putExtra("User", new User(firstName, lastName, email, password, dateOfBirth));
                startActivity(activityThreeIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuLogout){
            Toast.makeText(
                    getApplicationContext(),
                    "Logout Option Selected",
                    Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menuSettings) {
            Toast.makeText(
                    getApplicationContext(),
                    "Settings Option Selected",
                    Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.menuExit) {
            Toast.makeText(
                    getApplicationContext(),
                    "Exit Option Selected",
                    Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.menuShare) {
            Toast.makeText(
                    getApplicationContext(),
                    "Share Option Selected",
                    Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
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