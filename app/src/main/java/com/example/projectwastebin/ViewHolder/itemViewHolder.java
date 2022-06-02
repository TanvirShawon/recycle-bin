package com.example.projectwastebin.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectwastebin.Interface.ItemClickListner;
import com.example.projectwastebin.R;



public class itemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtProductName, txtProductDescription, txtProductPrice, getTxtProductStatus;
    public ImageView imageView;
    public ItemClickListner listner;


    public itemViewHolder(View itemView)
    {
        super(itemView);


        imageView = (ImageView) itemView.findViewById(R.id.product_seller_image);
        txtProductName = (TextView) itemView.findViewById(R.id.product_seller_name);
        txtProductDescription = (TextView) itemView.findViewById(R.id.product_seller_description);
        txtProductPrice = (TextView) itemView.findViewById(R.id.product_seller_price);
        getTxtProductStatus = (TextView) itemView.findViewById(R.id.product_seller_state);
    }

    public void setItemClickListner(ItemClickListner listner)

    {
        this.listner = listner;
    }

    @Override
    public void onClick(View view)

    {
        listner.onClick(view, getAdapterPosition(), false);
    }
}
