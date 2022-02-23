package com.example.myapplication22222;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;



public class AllProActivity extends AppCompatActivity {

    private RecyclerView rvProsAllPro;
    MyRecyclerViewAdapter adapter;
    FirebaseServices fbs;
    ArrayList<ProClass> Professionals;
    MyCallBack myCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_pro);

        fbs = FirebaseServices.getInstance();
        Professionals = new ArrayList<ProClass>();
        readData();
        myCallback = new MyCallBack(){
            @Override
            public void onCallBack(List<ProClass> attractionsList) {
                RecyclerView recyclerView = findViewById(R.id.rvProsAllPro);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new MyRecyclerViewAdapter(getApplicationContext(),Professionals);
                recyclerView.setAdapter(adapter);
            }
        };


        // set up the RecyclerView
        /*
        RecyclerView recyclerView = findViewById(R.id.rvRestsAllRest);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterRestaurant(this, rests);
        recyclerView.setAdapter(adapter);*/
    }

    private void readData() {
        try {

            fbs.getFire().collection("Professionals")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Professionals.add(document.toObject(ProClass.class));
                                }

                                myCallback.onCallBack(Professionals);
                            } else {
                                Log.e("AllRestActivity: readData()", "Error getting documents.", task.getException());
                            }
                        }
                    });
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "error reading!" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}