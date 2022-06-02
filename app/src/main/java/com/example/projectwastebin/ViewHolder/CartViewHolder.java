package com.example.projectwastebin.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectwastebin.Interface.ItemClickListner;
import com.example.projectwastebin.R;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView txtProductName, txtProductPrice, txtProductQuantity, txtSellerName, txtSellerPhone, txtSellerAddress, txtSellerEmail;
    private ItemClickListner itemClickListner;

    public CartViewHolder(View itemView){
        super(itemView);


        txtProductName= itemView.findViewById(R.id.cart_product_name);
        txtProductPrice= itemView.findViewById(R.id.cart_product_price);

        txtSellerName= itemView.findViewById(R.id.seller_name_admin);
        txtSellerPhone= itemView.findViewById(R.id.seller_phone_admin);

        txtSellerAddress= itemView.findViewById(R.id.seller_address_admin);

        txtSellerEmail= itemView.findViewById(R.id.seller_email_admin);
       // txtProductQuantity= itemView.findViewById(R.id.cart_product_quantity);

    }

    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view, getAdapterPosition(), false);
    }

    public  void  setItemClickListner(ItemClickListner itemClickListner){
        this.itemClickListner = itemClickListner;
    }
}
