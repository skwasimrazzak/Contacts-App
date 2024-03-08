package com.shiftux.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.shiftux.contactsapp.databinding.ActivityAddNewContactBinding;

public class AddNewContactClickHandler {


    Contacts contacts;
    Context context;

    MyViewModel viewModel;
    public AddNewContactClickHandler(Contacts contacts, Context context, MyViewModel viewModel) {
        this.contacts = contacts;
        this.context = context;
        this.viewModel= viewModel;
    }

    public void onSubmitBtnClick(View view){
        if(contacts.getName()==null || contacts.getEmail()==null){
            Toast.makeText(context, "Fields can't be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent i=  new Intent(context, MainActivity.class);

//Intent may cause inconvenience in the transfer of data So we are using another way
//            i.putExtra("Name", contacts.getName());
//            i.putExtra("Email", contacts.getEmail());

            Contacts c= new Contacts (
                    contacts.getName(),
                    contacts.getEmail()
                    );

            viewModel.addNewContact(c);
            context.startActivity(i);
        }
    }
}
