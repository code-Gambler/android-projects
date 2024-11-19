package com.seneca.contacts;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts = new ArrayList<>();

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
        setUpContacts();

        RecyclerView rvContacts = findViewById(R.id.rvContacts);
        ContactAdapter contactAdapter = new ContactAdapter(this, contacts);
        rvContacts.setAdapter(contactAdapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpContacts() {
        String[] contactNames = getResources().getStringArray(R.array.contact_name);
        String[] contactEmail = getResources().getStringArray(R.array.email);
        String[] contactPhone = getResources().getStringArray(R.array.phone);

        for (int i = 0; i < contactNames.length; i++){
            int imageResId = getResources().getIdentifier("_" + (i + 1), "drawable", getPackageName());
            contacts.add(new Contact(contactNames[i], contactEmail[i], contactPhone[i], imageResId));
        }
    }
}