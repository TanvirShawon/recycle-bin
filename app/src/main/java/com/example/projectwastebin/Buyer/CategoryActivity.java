package com.example.projectwastebin.Buyer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.projectwastebin.Admin.AdminActivity;
import com.example.projectwastebin.Admin.AdminAddNewProductActivity;
import com.example.projectwastebin.Admin.AdminCategoryActivity;
import com.example.projectwastebin.Category.BrokenPlastic;
import com.example.projectwastebin.Category.Clothes;
import com.example.projectwastebin.Category.Electronics;
import com.example.projectwastebin.Category.FashionBeauty;
import com.example.projectwastebin.Category.Furniture;
import com.example.projectwastebin.Category.Newspaper;
import com.example.projectwastebin.Category.Organic;
import com.example.projectwastebin.Category.PlasticBottle;
import com.example.projectwastebin.Category.Restaurant;
import com.example.projectwastebin.Category.Sports;
import com.example.projectwastebin.Category.Vehicles;
import com.example.projectwastebin.R;

public class CategoryActivity extends AppCompatActivity {

    private RelativeLayout organic, plastic_bottle, broken_plastic, restaurant;
    private RelativeLayout newspaper, electronics, clothes, furniture;
    private RelativeLayout vehicles, sports, plant_nursery, fashion_beauty;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        backBtn= findViewById(R.id.back_pressed_cat);
        organic = findViewById(R.id.organic_cat);
        plastic_bottle = findViewById(R.id.plastic_bottle_cat);
        broken_plastic =  findViewById(R.id.broken_plastic_cat);
        restaurant =  findViewById(R.id.restaurant_cat);

        newspaper = findViewById(R.id.newspaper_cat);
        electronics =  findViewById(R.id.electronics_cat);
        clothes =  findViewById(R.id.clothes_cat);
        furniture = findViewById(R.id.furniture_cat);

        vehicles = findViewById(R.id.vehicles_cat);
        sports =  findViewById(R.id.sports_cat);
        plant_nursery =  findViewById(R.id.plant_nursery_cat);
        fashion_beauty =  findViewById(R.id.fashion_beauty_cat);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });




        organic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, Organic.class);

                startActivity(intent);
            }
        });


        plastic_bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, PlasticBottle.class);

                startActivity(intent);
            }
        });


        broken_plastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, BrokenPlastic.class);

                startActivity(intent);
            }
        });


        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, Restaurant.class);

                startActivity(intent);
            }
        });


        newspaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, Newspaper.class);

                startActivity(intent);
            }
        });


        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, Electronics.class);

                startActivity(intent);
            }
        });



        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, Clothes.class);

                startActivity(intent);
            }
        });


        furniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, Furniture.class);

                startActivity(intent);
            }
        });



        vehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, Vehicles.class);

                startActivity(intent);
            }
        });


        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, Sports.class);

                startActivity(intent);
            }
        });


        plant_nursery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, Restaurant.class);

                startActivity(intent);
            }
        });


        fashion_beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, FashionBeauty.class);

                startActivity(intent);
            }
        });
    }
}