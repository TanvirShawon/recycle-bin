package com.example.projectwastebin.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectwastebin.Buyer.HomeActivity;
import com.example.projectwastebin.Buyer.MainActivity;
import com.example.projectwastebin.R;



public class AdminActivity extends AppCompatActivity {


    private CardView  CheckOrderBtn, maintainProductsBtn, checkApproveProductsBtn, addProductBtn;
    private Button LogoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        addProductBtn= findViewById(R.id.add_new_product_admin);
        LogoutBtn= findViewById(R.id.admin_logout_btn);
        CheckOrderBtn= findViewById(R.id.check_orders_btn);
        maintainProductsBtn= findViewById(R.id.maintain_btn);
        checkApproveProductsBtn= findViewById(R.id.check_approve_products_btn);


        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminActivity.this, AdminCategoryActivity.class);
                startActivity(intent);
            }
        });



        checkApproveProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminActivity.this, AdminCheckNewProductsActivity.class);
                startActivity(intent);

            }
        });

        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminActivity.this, HomeActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);

            }
        });



        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        CheckOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminActivity.this, AdminNewOrderActivity.class);

                startActivity(intent);

            }
        });

    }
}