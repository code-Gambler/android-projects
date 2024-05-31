package com.seneca.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Log.d("Lifecycle Activity", "Steven David Pillay's log: OnCreate Method Called Activity 2");


        TextView tvOutput = findViewById(R.id.tvOutput);

        Bundle extras = getIntent().getExtras();
        String firstName = extras.get("FirstName").toString();
        String lastName = extras.get("LastName").toString();
        String email = extras.get("Email").toString();
        String confirmEmail = extras.get("ConfirmEmail").toString();
        String password = extras.get("Password").toString();
        String confirmPassword = extras.get("ConfirmPassword").toString();
        String dateOfBirth = extras.get("DateOfBirth").toString();

        tvOutput.setText(firstName+"\n\n\n"+lastName+"\n\n\n"+email+"\n\n\n"+confirmEmail+"\n\n\n"+password+"\n\n\n"+confirmPassword+"\n\n\n"+dateOfBirth);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onStart Method Called Activity 2");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onRestart Method Called  Activity 2");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onResume Method Called Activity 2");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onPause Method Called Activity 2");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onStop Method Called Activity 2");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle Activity", "Steven David Pillay's log: onDestroy Method Called Activity 2");

    }

}