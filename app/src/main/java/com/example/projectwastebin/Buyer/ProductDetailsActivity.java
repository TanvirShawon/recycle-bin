package com.example.projectwastebin.Buyer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.projectwastebin.Model.Products;
import com.example.projectwastebin.Prevalent.Prevalent;
import com.example.projectwastebin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ProductDetailsActivity extends AppCompatActivity {

    private FloatingActionButton addToCart;
    private ImageView productImage;
    private ElegantNumberButton numberButton;
    private TextView productPrice, productDescription, productName, productTime, productDate, productLocation, productDistrict, sellerName, sellerPhone, sellerEmail;
    private String productID= "", state="Normal";
    private Button addToCartbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productID= getIntent().getStringExtra("pid");


       addToCart= findViewById(R.id.add_product_to_cart_btn);
      //  numberButton= findViewById(R.id.number_btn);
        productImage= findViewById(R.id.product_image_details);
        productName= findViewById(R.id.product_name_details);
        productDescription= findViewById(R.id.product_description_details);
        productPrice= findViewById(R.id.product_price_details);
        productTime= findViewById(R.id.product_time_details);
        productLocation= findViewById(R.id.product_location_details);
        sellerName= findViewById(R.id.product_seller_name_details);
        sellerPhone= findViewById(R.id.product_seller_phone_details);
        sellerEmail= findViewById(R.id.product_seller_email_details);
        productDate= findViewById(R.id.product_date_details);
        productDistrict= findViewById(R.id.product_district_details);



        addToCartbutton= findViewById(R.id.pd_add_to_cart_button);
        getProductDetails(productID);

        addToCartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (state.equals("Order Placed") || state.equals("Order Shipped")){
                    addingToCartList();
                    Toast.makeText(ProductDetailsActivity.this, "Your Cart List Updated, You Can Change Your Shipment Details If You Want", Toast.LENGTH_LONG).show();
                }
                else {
                    addingToCartList();
                }
            }


        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        CheckOrderState();
    }

    private void addingToCartList() {
        String saveCurrentTime, saveCurrentDate;

        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentDate.format(calForDate.getTime());

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart List");
        final HashMap<String, Object> cartMap = new HashMap<>();
        cartMap.put("pid", productID);
        cartMap.put("pname", productName.getText().toString());
        cartMap.put("price",  productPrice.getText().toString());
        cartMap.put("date", saveCurrentDate);
        cartMap.put("time", saveCurrentTime);
        cartMap.put("date",  productDate.getText().toString());
        cartMap.put("time",  productTime.getText().toString());
        cartMap.put("pdistrict",  productDistrict.getText().toString());


        cartMap.put("paddress",  productLocation.getText().toString());
        cartMap.put("sellerName",  sellerName.getText().toString());
        cartMap.put("sellerPhone",  sellerPhone.getText().toString());
        cartMap.put("sellerEmail",  sellerEmail.getText().toString());

       // cartMap.put("quantity", numberButton.getNumber());
        // cartMap.put("Shipping Time", Productshippingtime.getText().toString());
        cartMap.put("discount", "");

        cartListRef.child("User View").child(Prevalent.currentOnlineUser.getPhone())
                .child("Products").child(productID)
                .updateChildren(cartMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            cartListRef.child("Admin View").child(Prevalent.currentOnlineUser.getPhone())
                                    .child("Products").child(productID)
                                    .updateChildren(cartMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(ProductDetailsActivity.this, "Added to cart list.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(ProductDetailsActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                }
                            });

                        }
                    }
                });
    }





    private void getProductDetails(String productID){
        DatabaseReference productRef= FirebaseDatabase.getInstance().getReference().child("Products");

        productRef.child(productID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    Products products= dataSnapshot.getValue(Products.class);

                    productName.setText(products.getPname());
                    productPrice.setText(products.getPrice());
                    productDescription.setText(products.getDescription());

                    productDate.setText(products.getDate() );
                    productTime.setText(products.getTime() );
                    productLocation.setText(products.getPaddress());

                    sellerName.setText(products.getSellerName() );
                    sellerPhone.setText(products.getSellerPhone() );
                    sellerEmail.setText(products.getSellerEmail() );
                    productDistrict.setText(products.getPdistrict());
                    Picasso.get().load(products.getImage()).into(productImage);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void CheckOrderState(){
        DatabaseReference orderRef;
        orderRef= FirebaseDatabase.getInstance().getReference().child("Orders").child(Prevalent.currentOnlineUser.getPhone());

        orderRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String shippingState = dataSnapshot.child("state").getValue().toString();


                    if (shippingState.equals("shipped")){
                        state= "Order Shipped";
                    }
                    else if (shippingState.equals("not shipped")){
                        state= "Order Placed";
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}