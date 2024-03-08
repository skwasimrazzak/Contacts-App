package com.shiftux.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.shiftux.contactsapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //DataSource
    private ContactDB contactDB;
    private ArrayList<Contacts> contactsArrayList= new ArrayList<>();

    //Adapter
    private MyAdapter adapter;

    //Binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DataBinding
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        handler= new MainActivityClickHandler(this);

        mainBinding.setClickHandler(handler);

        //Recycler View
        RecyclerView recyclerView= mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



        //DataBase
        contactDB= ContactDB.getInstance(this);

        //ViewModel
        MyViewModel viewModel= new ViewModelProvider(this).get(MyViewModel.class);

        //Inserting a New Contact
//        Contacts c1= new Contacts( "Maow", "maow@gmail.com");
//        viewModel.addNewContact(c1);

        //Load Data from Room DB
        viewModel.getAllContacts().observe(this,
                new Observer<List<Contacts>>() {
                    @Override
                    public void onChanged(List<Contacts> contacts) {

                        contactsArrayList.clear();

                        for(Contacts c: contacts){
//                            Log.v("Tag", c.getName());
                            contactsArrayList.add(c);
                        }

                        adapter.notifyDataSetChanged();
                    }
                });

        //Adapter
        adapter = new MyAdapter(contactsArrayList);
        //Link Recycler VIew with adapter
        recyclerView.setAdapter(adapter);
    }
}