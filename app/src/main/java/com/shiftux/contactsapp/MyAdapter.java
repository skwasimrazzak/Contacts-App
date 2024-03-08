package com.shiftux.contactsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shiftux.contactsapp.databinding.ContactsListItemsBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    private ArrayList<Contacts> contacts;

    public MyAdapter(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ContactsListItemsBinding contactsListItemsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.contacts_list_items,
                parent,
                false
        );
        return new ContactViewHolder(contactsListItemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contacts currentContact= contacts.get(position);

        holder.contactsListItemsBinding.setContact(currentContact);
    }

    @Override
    public int getItemCount() {
        if(contacts != null){
            return contacts.size();
        }else {
            return 0;
        }
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;

        notifyDataSetChanged();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        private ContactsListItemsBinding contactsListItemsBinding;

        public ContactViewHolder(@NonNull ContactsListItemsBinding contactsListItemsBinding) {
            super(contactsListItemsBinding.getRoot());
            this.contactsListItemsBinding = contactsListItemsBinding;
        }
    }
}
