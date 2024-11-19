package com.seneca.contacts;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create);
        // Initialize database and DAO
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "contacts")
                .allowMainThreadQueries()  // Allow main thread queries for simplicity
                .build();
        ContactDao contactDao = db.contactDao();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize EditText fields
        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etNumber = findViewById(R.id.etPhone);

        // Initialize button
        Button btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(v -> {
            // Retrieve user input
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String number = etNumber.getText().toString().trim();

            // Validate input
            if (name.isEmpty() || email.isEmpty() || number.isEmpty()) {
                Toast.makeText(CreateActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Create a new Contact object
            Contact contact = new Contact(name, email, number);

            // Insert the new contact into the database
            contactDao.insert(contact);

            // Notify the user
            Toast.makeText(CreateActivity.this, "Contact added", Toast.LENGTH_SHORT).show();

            // Set result and finish activity
            setResult(RESULT_OK);
            // Finish the activity and return to the previous screen
            finish();
        });

    }


}