package com.shiftux.contactsapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contacts.class}, version = 1)
public abstract class ContactDB extends RoomDatabase {

    public abstract ContactsDAO getContactDAO();

    //Singleton Pattern
    private static ContactDB dbInstance;

    public static synchronized ContactDB getInstance(Context context){
        if(dbInstance==null){
            dbInstance= Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDB.class,
                    "contact_db"
            ).fallbackToDestructiveMigration().build();
        }
        return dbInstance;
    }



}
