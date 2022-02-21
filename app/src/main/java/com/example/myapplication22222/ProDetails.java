package com.example.myapplication22222;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProDetails extends AppCompatActivity {

    private TextView tvName, tvExprience, tvAddress, tvPhone,tvAge;
    private ImageView ivPhoto;

    public ProDetails(String name, String description, String address, String phone, String photo, ProCat valueOf) {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_details);

        // connectComponents();
        Intent i = this.getIntent();
        connectComponents();
    //  *  tvName.setText(ProDetails.getName());
        /*
        tvDescription.setText(rest.getDescription());
        tvAddress.setText(rest.getAddress());
        tvCategory.setText(rest.getCategory().toString());
        tvPhone.setText(rest.getPhone());
        Picasso.get().load(rest.getPhoto()).into(ivPhoto);*/

    }

    private void connectComponents() {

        tvAge = findViewById(R.id.tvAgeProDetails);
        tvName = findViewById(R.id.tvNameProDetails);
        tvExprience = findViewById(R.id.tvExprienceProDetails);
        tvAddress = findViewById(R.id.tvAddressProDetails);
        tvPhone = findViewById(R.id.etPhoneAddPro);
        ivPhoto = findViewById(R.id.ivPhotoAddPro);
    }
}