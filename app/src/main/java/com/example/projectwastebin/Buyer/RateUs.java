package com.example.projectwastebin.Buyer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.projectwastebin.Prevalent.Prevalent;
import com.example.projectwastebin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RateUs extends AppCompatActivity {

    RatingBar ratingBar;
    Button ratebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);


        ratingBar=findViewById(R.id.rating_bar);
        ratebtn= findViewById(R.id.rate_btn);


        ratebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String star= String.valueOf(ratingBar.getRating());

                final DatabaseReference orderRef= FirebaseDatabase.getInstance().getReference()
                        .child("Ratings")
                        .child(Prevalent.currentOnlineUser.getPhone());

                HashMap<String, Object> ordersMap = new HashMap<>();

                ordersMap.put("rating number", star);


                orderRef.updateChildren(ordersMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){
                            startActivity(new Intent(RateUs.this, HomeActivity.class));
                            Toast.makeText(RateUs.this, "Thank You For Rating Us", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }
                });


            }
        });
    }
}