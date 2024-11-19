package com.seneca.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_CREATE_CONTACT = 1;
    private static final int REQUEST_CODE_UPDATE_CONTACT = 2;
    ArrayList<Contact> contacts = new ArrayList<>();
    private ContactDao contactDao;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "contacts").allowMainThreadQueries().build();
        contactDao = db.contactDao();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        contacts = contactDao.getAllAsArrayList();


        RecyclerView rvContacts = findViewById(R.id.rvContacts);
        contactAdapter = new ContactAdapter(this, contacts);
        rvContacts.setAdapter(contactAdapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.Callback() {
                    @Override
                    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                        return makeMovementFlags(
                                0,
                                ItemTouchHelper.START | ItemTouchHelper.END
                        );
                    }

                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        switch (direction) {
                            case ItemTouchHelper.END:
                                // Handle swipe to update
                                Contact contact = contacts.get(viewHolder.getAdapterPosition());
                                Intent updateContactIntent = new Intent(getApplicationContext(), UpdateActivity.class);
                                updateContactIntent.putExtra(UpdateActivity.EXTRA_CONTACT_ID, contact.getContactId());
                                startActivityForResult(updateContactIntent, REQUEST_CODE_UPDATE_CONTACT);
                                break;
                            case ItemTouchHelper.START:
                                contactDao.delete(contacts.get(viewHolder.getAdapterPosition()));
                                contacts = contactDao.getAllAsArrayList();
                                contactAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                                break;
                        }
                    }
                }
        );
        helper.attachToRecyclerView(rvContacts);

        // Initialize and set up the button click listener
        Button btnCreateContact = findViewById(R.id.btnCreateContact);
        btnCreateContact.setOnClickListener(v -> {
            // Define what happens when the button is clicked
            // For example, open a new activity to create a contact
            Intent createContactIntent = new Intent(getApplicationContext(), CreateActivity.class);
            startActivityForResult(createContactIntent, REQUEST_CODE_CREATE_CONTACT);
        });
    }

    private void setUpContacts() {
        String[] contactNames = getResources().getStringArray(R.array.contact_name);
        String[] contactEmail = getResources().getStringArray(R.array.email);
        String[] contactPhone = getResources().getStringArray(R.array.phone);

        for (int i = 0; i < contactNames.length; i++){
            contacts.add(new Contact(contactNames[i], contactEmail[i], contactPhone[i]));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CREATE_CONTACT && resultCode == RESULT_OK) {
            // Refresh the contacts list
            contacts.clear();
            contacts.addAll(contactDao.getAllAsArrayList());
            contactAdapter.notifyDataSetChanged();
        }
        else if (requestCode == REQUEST_CODE_UPDATE_CONTACT && resultCode == RESULT_OK) {
            if (data != null) {
                int contactId = data.getIntExtra(UpdateActivity.EXTRA_CONTACT_ID, -1);
                String name = data.getStringExtra(UpdateActivity.EXTRA_NAME);
                String email = data.getStringExtra(UpdateActivity.EXTRA_EMAIL);
                String phone = data.getStringExtra(UpdateActivity.EXTRA_PHONE);

                Contact updatedContact = new Contact(contactId, name, email, phone);
                contactDao.update(updatedContact);

                contacts.clear();
                contacts.addAll(contactDao.getAllAsArrayList());
                contactAdapter.notifyDataSetChanged();
            }
        }
    }
}

