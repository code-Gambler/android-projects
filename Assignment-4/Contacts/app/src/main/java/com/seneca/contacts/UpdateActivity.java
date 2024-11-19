package com.seneca.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class UpdateActivity extends AppCompatActivity {

    public static final String EXTRA_CONTACT_ID = "com.seneca.contacts.EXTRA_CONTACT_ID";
    public static final String EXTRA_NAME = "com.seneca.contacts.EXTRA_NAME";
    public static final String EXTRA_EMAIL = "com.seneca.contacts.EXTRA_EMAIL";
    public static final String EXTRA_PHONE = "com.seneca.contacts.EXTRA_PHONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);
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
        // Retrieve the contact ID from the intent
        int contactId = getIntent().getIntExtra(EXTRA_CONTACT_ID, -1);

        // Initialize UI elements
        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPhone = findViewById(R.id.etPhone);
        Button btnUpdate = findViewById(R.id.btnUpdate);

        Contact currentContact = contactDao.findById(contactId);
        // Assuming you fetch the existing contact details using the contactId
        // For demonstration purposes, we'll use placeholder values
        // You should fetch and set actual values from your database

        // Example data, replace with actual database fetch
        etName.setText(currentContact.name);
        etEmail.setText(currentContact.email);
        etPhone.setText(currentContact.phone);

        btnUpdate.setOnClickListener(v -> {
            // Gather updated contact details
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String phone = etPhone.getText().toString();

            // Create a result Intent
            Intent resultIntent = new Intent();
            resultIntent.putExtra(EXTRA_CONTACT_ID, contactId);
            resultIntent.putExtra(EXTRA_NAME, name);
            resultIntent.putExtra(EXTRA_EMAIL, email);
            resultIntent.putExtra(EXTRA_PHONE, phone);

            // Set the result and finish
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}