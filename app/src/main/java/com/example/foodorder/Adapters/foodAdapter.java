package com.example.foodorder.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.DetailsPage;
import com.example.foodorder.Models.foodModels;
import com.example.foodorder.R;

import java.util.ArrayList;

public class foodAdapter extends RecyclerView.Adapter<foodAdapter.ViewHolder> {
   ArrayList<foodModels>list;
   Context context;

    public foodAdapter(ArrayList<foodModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public foodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_foodlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull foodAdapter.ViewHolder holder, int position) {
    final foodModels models = list.get(position);
    holder.foodimage.setImageResource(models.getImage());
    holder.foodname.setText(models.getFoodname());
    holder.price.setText(models.getPrice());
    holder.fooddesc.setText(models.getFooddesc());

    holder.itemView.setOnClickListener(v->{
        Intent intent = new Intent(context, DetailsPage.class);
        intent.putExtra("id",position);
        intent.putExtra("foodname",models.getFoodname());
        intent.putExtra("foodimage",models.getImage());
        intent.putExtra("fooddesc",models.getFooddesc());
        intent.putExtra("foodprice",models.getPrice());
        intent.putExtra("type","insert");
        context.startActivity(intent);
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       ImageView foodimage;
       TextView foodname,price,fooddesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodimage = itemView.findViewById(R.id.foodimage);
            foodname = itemView.findViewById(R.id.foodname);
            fooddesc = itemView.findViewById(R.id.fooddesc);
            price= itemView.findViewById(R.id.price);
        }
    }

}
