package com.seneca.contacts;

public class Contact { //Data Class
    String name;
    String email;
    String phone;
    int imageId;

    public Contact(String name, String email, String phone, int imageId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.imageId = imageId;
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

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
