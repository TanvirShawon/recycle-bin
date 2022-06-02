package com.example.projectwastebin.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.projectwastebin.Buyer.HomeActivity;
import com.example.projectwastebin.Buyer.MainActivity;
import com.example.projectwastebin.R;

public class AdminCategoryActivity extends AppCompatActivity
{
    private RelativeLayout organic, plastic_bottle, broken_plastic, restaurant;
    private RelativeLayout newspaper, electronics, clothes, furniture;
    private RelativeLayout vehicles, sports, plant_nursery, fashion_beauty;

    private ImageView backBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        backBtn= findViewById(R.id.back_pressed);

        organic = findViewById(R.id.organic);
        plastic_bottle = findViewById(R.id.plastic_bottle);
        broken_plastic =  findViewById(R.id.broken_plastic);
        restaurant =  findViewById(R.id.restaurant);

        newspaper = findViewById(R.id.newspaper);
        electronics =  findViewById(R.id.electronics);
        clothes =  findViewById(R.id.clothes);
        furniture = findViewById(R.id.furniture);

        vehicles = findViewById(R.id.vehicles);
        sports =  findViewById(R.id.sports);
        plant_nursery =  findViewById(R.id.plant_nursery);
        fashion_beauty =  findViewById(R.id.fashion_beauty);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });


        organic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Organic");
                startActivity(intent);
            }
        });


        plastic_bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Plastic Bottle");
                startActivity(intent);
            }
        });


        broken_plastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Broken Plastic");
                startActivity(intent);
            }
        });


        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Restaurant");
                startActivity(intent);
            }
        });


        newspaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Newspaper");
                startActivity(intent);
            }
        });


        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Electronics");
                startActivity(intent);
            }
        });



        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Clothes");
                startActivity(intent);
            }
        });


        furniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Furniture");
                startActivity(intent);
            }
        });



        vehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Vehicles");
                startActivity(intent);
            }
        });


        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Sports");
                startActivity(intent);
            }
        });


        plant_nursery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Plant Nursery");
                startActivity(intent);
            }
        });


        fashion_beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "fashion Beauty");
                startActivity(intent);
            }
        });
    }
}
