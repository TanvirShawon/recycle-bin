package com.example.projectwastebin.Buyer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.projectwastebin.Model.Products;
import com.example.projectwastebin.R;
import com.example.projectwastebin.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class SearchProductsActivity extends AppCompatActivity {

    private Button searchBtn;
    private EditText inputText;
    private RecyclerView searchList;
    private  String searchInput;
    private ImageView filter, notfilter;

    private String parentFiName = "filter";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_products);

        inputText= findViewById(R.id.search_product_name);
        searchBtn= findViewById(R.id.search_btn);

        searchList= findViewById(R.id.search_list);
        searchList.setLayoutManager(new LinearLayoutManager(SearchProductsActivity.this));

        filter= findViewById(R.id.filter);
        notfilter= findViewById(R.id.filter_not);


        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setHint("Product Name");
                inputText.setText("");
                filter.setVisibility(View.INVISIBLE);
                notfilter.setVisibility(View.VISIBLE);
                parentFiName = "Filter";
            }
        });

        notfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setHint("Address");
                inputText.setText("");
                filter.setVisibility(View.VISIBLE);
                notfilter.setVisibility(View.INVISIBLE);
                parentFiName = "NoFilter";
            }
        });



        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput= inputText.getText().toString();

                onStart();
            }
        });






    }

    @Override
    protected void onStart() {
        super.onStart();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Products");



        if (parentFiName.equals("Filter")){
            FirebaseRecyclerOptions<Products> options=
                    new FirebaseRecyclerOptions.Builder<Products>()
                            .setQuery(reference.orderByChild("pname").startAt(searchInput), Products.class)
                            .build();

            FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter=
                    new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                        @Override
                        protected void onBindViewHolder(@NonNull ProductViewHolder holder, int i, @NonNull Products model) {
                            holder.txtProductName.setText(model.getPname());
                            holder.txtProductDescription.setText(model.getDescription());
                            holder.txtProductPrice.setText("Price = " + model.getPrice() + "Tk");
                            Picasso.get().load(model.getImage()).into(holder.imageView);

                            holder.itemView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent= new Intent(SearchProductsActivity.this, ProductDetailsActivity.class);
                                    intent.putExtra("pid", model.getPid());
                                    startActivity(intent);
                                }
                            });
                        }

                        @NonNull
                        @Override
                        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent, false);
                            ProductViewHolder holder = new ProductViewHolder(view);
                            return holder;
                        }
                    };
            searchList.setAdapter(adapter);
            adapter.startListening();
        }
        else if(parentFiName.equals("NoFilter")){
            FirebaseRecyclerOptions<Products> options=
                    new FirebaseRecyclerOptions.Builder<Products>()
                            .setQuery(reference.orderByChild("paddress").startAt(searchInput).endAt(searchInput), Products.class)
                            .build();

            FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter=
                    new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                        @Override
                        protected void onBindViewHolder(@NonNull ProductViewHolder holder, int i, @NonNull Products model) {
                            holder.txtProductName.setText(model.getPname());
                            holder.txtProductDescription.setText(model.getDescription());
                            holder.txtProductPrice.setText("Price = " + model.getPrice() + "Tk");
                            Picasso.get().load(model.getImage()).into(holder.imageView);

                            holder.itemView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent= new Intent(SearchProductsActivity.this, ProductDetailsActivity.class);
                                    intent.putExtra("pid", model.getPid());
                                    startActivity(intent);
                                }
                            });
                        }

                        @NonNull
                        @Override
                        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent, false);
                            ProductViewHolder holder = new ProductViewHolder(view);
                            return holder;
                        }
                    };
            searchList.setAdapter(adapter);
            adapter.startListening();
        }


        else {
            FirebaseRecyclerOptions<Products> options=
                    new FirebaseRecyclerOptions.Builder<Products>()
                            .setQuery(reference.orderByChild("pname").startAt(searchInput), Products.class)
                            .build();

            FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter=
                    new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                        @Override
                        protected void onBindViewHolder(@NonNull ProductViewHolder holder, int i, @NonNull Products model) {
                            holder.txtProductName.setText(model.getPname());
                            holder.txtProductDescription.setText(model.getDescription());
                            holder.txtProductPrice.setText("Price = " + model.getPrice() + "Tk");
                            Picasso.get().load(model.getImage()).into(holder.imageView);

                            holder.itemView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent= new Intent(SearchProductsActivity.this, ProductDetailsActivity.class);
                                    intent.putExtra("pid", model.getPid());
                                    startActivity(intent);
                                }
                            });
                        }

                        @NonNull
                        @Override
                        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent, false);
                            ProductViewHolder holder = new ProductViewHolder(view);
                            return holder;
                        }
                    };
            searchList.setAdapter(adapter);
            adapter.startListening();


        }



    }
}