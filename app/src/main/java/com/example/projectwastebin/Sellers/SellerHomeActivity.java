package com.example.projectwastebin.Sellers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectwastebin.Buyer.HomeActivity;
import com.example.projectwastebin.Buyer.MainActivity;
import com.example.projectwastebin.R;
import com.google.firebase.auth.FirebaseAuth;

public class SellerHomeActivity extends AppCompatActivity {

    private CardView sellerHome, sellerAdd;

    private Button  sellerLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);

        sellerHome= findViewById(R.id.seller_home);
        sellerAdd= findViewById(R.id.seller_add);
        sellerLogout= findViewById(R.id.seller_logout);

        sellerHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellerHomeActivity.this, SellerHomeDemo.class);
                startActivity(intent);

            }
        });

        sellerAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellerHomeActivity.this, SellerProductCategoryActivity.class);
                startActivity(intent);

            }
        });


        sellerLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FirebaseAuth mAuth;
                mAuth= FirebaseAuth.getInstance();
                mAuth.signOut();

                Intent intentLog = new Intent(SellerHomeActivity.this, MainActivity.class);
                intentLog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentLog);
                finish();
            }
        });
    }
}