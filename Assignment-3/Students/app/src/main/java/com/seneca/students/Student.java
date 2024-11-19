package com.seneca.students;

import java.io.Serializable;

public class Student implements Serializable {
    String name;
    String phone;
    int imageId;

    public Student(String name, String phone, int imageId) {
        this.name = name;
        this.phone = phone;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
