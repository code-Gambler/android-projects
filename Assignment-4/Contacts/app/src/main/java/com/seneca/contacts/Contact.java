package com.seneca.contacts;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Contact { //Data Class
    @PrimaryKey(autoGenerate = true)
            int contactId;
    @ColumnInfo(name = "contact_name")
    String name;

    @ColumnInfo(name = "contact_email")
    String email;

    @ColumnInfo(name = "contact_phone")
    String phone;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Ignore
    public Contact(int contactId, String name, String email, String phone) {
        this.contactId = contactId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
