package com.example.myapplication22222;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

 class AddUserActivity extends AppCompatActivity {

    private static final String TAG = "AddUserActivity";
    private EditText etName, etDesc, etAddress, etPhone;
    private Spinner spCat;
    private ImageView ivPhoto;
    private FirebaseServices fbs;
    private Uri filePath;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        getSupportActionBar().hide();
        connectComponents();
    }

    private void connectComponents() {
        etName = findViewById(R.id.etNameAddUser);
        etDesc = findViewById(R.id.etDescriptionAddUser);
        etAddress = findViewById(R.id.etAddressAddUser);
        etPhone = findViewById(R.id.etPhoneAddUser);
        spCat = findViewById(R.id.spRestCatAddUser);
        ivPhoto = findViewById(R.id.ivPhotoAddUser);
        fbs = FirebaseServices.getInstance();
        spCat.setAdapter(new ArrayAdapter<UserCat>(this, android.R.layout.simple_list_item_1, UserCat.values()));
        storageReference = fbs.getStorage().getReference();
    }

    public void add(View view) {
        // check if any field is empty
        String name, description, address, phone, category, photo;
        name = etName.getText().toString();
        description = etDesc.getText().toString();
        address = etAddress.getText().toString();
        phone = etPhone.getText().toString();
        category = spCat.getSelectedItem().toString();
        if (ivPhoto.getDrawable() == null)
            photo = "no_image";
        else photo = storageReference.toString();

        if (name.trim().isEmpty() || description.trim().isEmpty() || address.trim().isEmpty() ||
                phone.trim().isEmpty() || category.trim().isEmpty() || photo.trim().isEmpty())
        {
            Toast.makeText(this, R.string.err_fields_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        User rest = new User(name, description, address, UserCat.valueOf(category), photo, phone);
        fbs.getFire().collection("restaurants")
                .add(rest)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    public void selectPhoto(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),40);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 40) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    try {
                        filePath = data.getData();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                        ivPhoto.setBackground(null);
                        ivPhoto.setImageBitmap(bitmap);
                        uploadImage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED)  {
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void uploadImage()
    {
        if (filePath != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference
            StorageReference ref
                    = storageReference
                    .child(
                            "images/"
                                    + UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(filePath)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(AddUserActivity.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(AddUserActivity.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int)progress + "%");
                                }
                            });
        }
    }
}
