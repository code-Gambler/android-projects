package com.seneca.contacts;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contact")
    List<Contact> getAll();

    @Query("SELECT * FROM contact WHERE contactId IN (:contactIds)")
    List<Contact> loadAllByIds(int[] contactIds);

    @Query("SELECT * FROM contact WHERE contactId LIKE :id LIMIT 1")
    Contact findById(int id);

    @Insert
    void insertAll(ArrayList<Contact> contacts);

    @Insert
    void insert(Contact contact);

    @Update
    void update(Contact contact);

    @Delete
    void delete(Contact contact);

    @Query("SELECT * FROM contact")
    default ArrayList<Contact> getAllAsArrayList() {
        return new ArrayList<>(getAll());
    }

    @Query("SELECT * FROM contact WHERE contactId IN (:contactIds)")
    default ArrayList<Contact> loadAllByIdsAsArrayList(int[] contactIds) {
        return new ArrayList<>(loadAllByIds(contactIds));
    }
}
