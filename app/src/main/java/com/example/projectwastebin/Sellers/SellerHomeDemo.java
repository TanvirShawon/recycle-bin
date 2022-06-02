package com.example.projectwastebin.Sellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectwastebin.Admin.AdminCheckNewProductsActivity;
import com.example.projectwastebin.Model.Products;
import com.example.projectwastebin.R;
import com.example.projectwastebin.ViewHolder.itemViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class SellerHomeDemo extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private DatabaseReference unverifiedProductsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home_demo);



        unverifiedProductsRef= FirebaseDatabase.getInstance().getReference().child("Products");


        recyclerView= findViewById(R.id.seller_home_recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Products> options=
                new FirebaseRecyclerOptions.Builder<Products>().
                setQuery(unverifiedProductsRef.orderByChild("sid").
                        equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid()), Products.class).build();


        FirebaseRecyclerAdapter<Products, itemViewHolder> adapter=
                new FirebaseRecyclerAdapter<Products, itemViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull itemViewHolder holder, int i, @NonNull Products model) {

                        holder.txtProductName.setText(model.getPname());
                        holder.txtProductDescription.setText(model.getDescription());
                        holder.getTxtProductStatus.setText("State: "+ model.getProductState());
                        holder.txtProductPrice.setText("Price = " + model.getPrice() + "Tk");
                        Picasso.get().load(model.getImage()).into(holder.imageView);

                        final  Products itemClick = model;

                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                final String productID = model.getPid();

                                CharSequence options[]= new CharSequence[]
                                        {
                                                "Yes",
                                                "No"
                                        };

                                AlertDialog.Builder builder= new AlertDialog.Builder(SellerHomeDemo.this);
                                builder.setTitle("Do you want to Delete this product. Are you sure?");
                                builder.setItems(options, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int position) {
                                        if (position == 0){
                                            DeleteProduct(productID);

                                        }
                                        if (position == 1) {

                                        }
                                    }
                                });
                                builder.show();
                            }
                        });

                    }

                    @NonNull
                    @Override
                    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_item_view, parent, false);
                        itemViewHolder holder = new itemViewHolder(view);
                        return holder;
                    }
                };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    private void DeleteProduct(String productID) {
        unverifiedProductsRef.child(productID)
                .removeValue()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(SellerHomeDemo.this, "Item has been deleted", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}