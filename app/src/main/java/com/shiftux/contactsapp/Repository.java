package com.shiftux.contactsapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    public final ContactsDAO contactsDAO;

    ExecutorService executor;
    Handler handler;
    public Repository(Application application) {
        ContactDB contactDB= ContactDB.getInstance(application);
        this.contactsDAO = contactDB.getContactDAO();

        executor = Executors.newSingleThreadExecutor();
        handler=  new Handler(Looper.getMainLooper());
    }

    public void addContact(Contacts contacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDAO.insert(contacts);
            }
        });


    }

    public void deleteContact(Contacts contacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDAO.delete(contacts);
            }
        });

    }

    public LiveData<List<Contacts>> displayContacts(){

        return contactsDAO.getAllContacts();
    }
}
