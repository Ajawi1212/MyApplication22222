package com.example.myapplication22222;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;



public class AllProActivity extends AppCompatActivity {

    private RecyclerView rvAllUser;
    MyRecyclerViewAdapter adapter;
    private AddUserActivity professional;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user);

        // data to populate the RecyclerView with
        ArrayList<String> professionalNames = new ArrayList<>();
        professional.add("aws");
        professional.add("ward");
        professional.add("jamel");
        professional.add("mohamad");
        professional.add("ghazy");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvUsersAllUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, professionalNames);
        recyclerView.setAdapter(adapter);
    }
}
