package com.example.myapplication22222;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProDetails extends AppCompatActivity {


    private TextView tvName, tvExprience, tvAddress, tvPhone;
    private ImageView ivPhoto;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

       // connectComponents();
        Intent i = this.getIntent();
    /*    User rest = (User) i.getSerializableExtra("rest");

        tvName.setText(rest.getName());
        tvExprience.setText(rest.getExprience());
        tvAddress.setText(rest.getAddress());
        tvPhone.setText(rest.getPhone());
        Picasso.get().load(rest.getPhoto()).into(ivPhoto);
    }*/

    private void connectComponents() {
        tvName = findViewById(R.id.tvNameProDetails);
        tvExprience = findViewById(R.id.tvExprienceProDetails);
        tvAddress = findViewById(R.id.tvAddressProDetails);
        tvPhone = findViewById(R.id.etPhoneAddUser);
        ivPhoto = findViewById(R.id.ivPhotoAddUser);
    }
}