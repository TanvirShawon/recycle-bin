package com.example.projectwastebin.Sellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectwastebin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SellerRegistrationActivity extends AppCompatActivity {

    private Button sellerLoginBtn;
    private EditText nameInput, phoneInput, emailInput, passwordInput, addressInput;
    private Button registerBtn;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_registration);


        sellerLoginBtn = findViewById(R.id.seller_already_have_account_btn);
        registerBtn = findViewById(R.id.seller_register_btn);
        nameInput = findViewById(R.id.seller_name);
        phoneInput = findViewById(R.id.seller_phone);
        emailInput = findViewById(R.id.seller_email);
        passwordInput = findViewById(R.id.seller_password);
        addressInput = findViewById(R.id.seller_address);
        mAuth = FirebaseAuth.getInstance();
        loadingBar = new ProgressDialog(this);

        sellerLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerRegistrationActivity.this, SellerLoginActivity.class);
                startActivity(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerSeller();
            }
        });

    }

    private void registerSeller() {
        String name = nameInput.getText().toString();
        String phone = phoneInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String address = addressInput.getText().toString();


        if (name.isEmpty()) {
            nameInput.setError("Full name is required");
            nameInput.requestFocus();
            return;
        } else if (phone.isEmpty()) {
            phoneInput.setError("Phone number is required");
            phoneInput.requestFocus();
            return;
        } else if (phone.length() < 11) {
            phoneInput.setError("Invalid Phone Number");
            phoneInput.requestFocus();
            return;
        } else if (email.isEmpty()) {
            emailInput.setError("Email is required");
            emailInput.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Please provide valid email!");
            emailInput.requestFocus();
            return;
        } else if (password.isEmpty()) {
            passwordInput.setError("Phone number is required");
            passwordInput.requestFocus();
            return;
        } else if (password.length() < 6) {
            passwordInput.setError("Min password length should be 6 characters!");
            passwordInput.requestFocus();
            return;
        } else if (address.isEmpty()) {
            addressInput.setError("Address is required");
            addressInput.requestFocus();
            return;
        } else {
            loadingBar.setTitle("Creating Seller Account");
                loadingBar.setMessage("Please wait....");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();


            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){

                        final DatabaseReference rootRef;

                        rootRef = FirebaseDatabase.getInstance().getReference();

                        String sid = mAuth.getCurrentUser().getUid();

                        HashMap<String, Object> sellerMap = new HashMap<>();
                        sellerMap.put("sid", sid);
                        sellerMap.put("phone", phone);
                        sellerMap.put("email", email);
                        sellerMap.put("address", address);
                        sellerMap.put("name", name);

                        rootRef.child("Sellers").child(sid).updateChildren(sellerMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                loadingBar.dismiss();
                                Toast.makeText(SellerRegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(SellerRegistrationActivity.this, SellerLoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }
                        });

                    }
                    else {
                        Toast.makeText(SellerRegistrationActivity.this, "Failed to Registration! Try again.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}