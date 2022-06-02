package com.example.projectwastebin.Sellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.projectwastebin.Admin.AdminAddNewProductActivity;
import com.example.projectwastebin.R;

public class SellerProductCategoryActivity extends AppCompatActivity {

    private RelativeLayout organic, plastic_bottle, broken_plastic, restaurant;
    private RelativeLayout newspaper, electronics, clothes, furniture;
    private RelativeLayout vehicles, sports, plant_nursery, fashion_beauty;

    // private Button LogoutBtn, CheckOrderBtn, maintainProductsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_product_category);


        organic = findViewById(R.id.organic_seller);
        plastic_bottle =  findViewById(R.id.plastic_bottle_seller);
        broken_plastic =  findViewById(R.id.broken_plastic_seller);
        restaurant = findViewById(R.id.restaurant_seller);

        newspaper = findViewById(R.id.newspaper_seller);
        electronics =  findViewById(R.id.electronics_seller);
        clothes = findViewById(R.id.clothes_seller);
        furniture = findViewById(R.id.furniture_seller);

        vehicles =  findViewById(R.id.vehicles_seller);
        sports =  findViewById(R.id.sports_seller);
        plant_nursery = findViewById(R.id.plant_nursery_seller);
        fashion_beauty =  findViewById(R.id.fashion_beauty_seller);

//        LogoutBtn = findViewById(R.id.admin_logout_btn);
//        CheckOrderBtn = findViewById(R.id.check_orders_btn);
//        maintainProductsBtn = findViewById(R.id.maintain_btn);
//

//        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SellerCategoryActivity.this, HomeActivity.class);
//                intent.putExtra("Admin", "Admin");
//                startActivity(intent);
//                finish();
//            }
//        });
//
//
//        LogoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SellerCategoryActivity.this, MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        CheckOrderBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SellerCategoryActivity.this, AdminNewOrderActivity.class);
//
//                startActivity(intent);
//
//            }
//        });


        organic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "Organic");
                startActivity(intent);
            }
        });


        plastic_bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "Plastic Bottle");
                startActivity(intent);
            }
        });


        broken_plastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "Broken Plastic");
                startActivity(intent);
            }
        });


        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this,SellerAddNewProductActivity.class);
                intent.putExtra("category", "Restaurant");
                startActivity(intent);
            }
        });


        newspaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "Newspaper");
                startActivity(intent);
            }
        });


        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "Electronics");
                startActivity(intent);
            }
        });


        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "Clothes");
                startActivity(intent);
            }
        });


        furniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "Furniture");
                startActivity(intent);
            }
        });


        vehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "Vehicles");
                startActivity(intent);
            }
        });


        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "Sports");
                startActivity(intent);
            }
        });


        plant_nursery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "Plant Nursery");
                startActivity(intent);
            }
        });


        fashion_beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "fashion Beauty");
                startActivity(intent);
            }
        });
    }
}