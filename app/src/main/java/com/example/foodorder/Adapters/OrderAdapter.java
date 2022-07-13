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
import com.example.foodorder.Models.OrderModels;
import com.example.foodorder.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {
    ArrayList<OrderModels>list;
    Context context;

    public OrderAdapter(ArrayList<OrderModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
      final OrderModels models = list.get(position);

//      holder.orderimage.setImageResource(models.getOrderfoodimage());
      Picasso.get().load(models.getOrderfoodimage()).into(holder.orderimage);
      holder.ordername.setText(models.getFoodname());
      holder.ordernumber.setText(models.getOrderNumber());
      holder.orderprice.setText(models.getOrderprice());

      holder.itemView.setOnClickListener(v->{
          Intent intent = new Intent(context, DetailsPage.class);
          intent.putExtra("orderno",Integer.parseInt(models.getOrderNumber()));
          intent.putExtra("foodimage",models.getOrderfoodimage());
          intent.putExtra("type","update");
          intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          context.startActivity(intent);
      });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class OrderHolder extends RecyclerView.ViewHolder{
      ImageView orderimage;
      TextView orderprice,ordername,ordernumber;
        public OrderHolder(@NonNull View itemView) {
            super(itemView);
            orderimage = itemView.findViewById(R.id.orderimage);
            ordername = itemView.findViewById(R.id.ordername);
            ordernumber = itemView.findViewById(R.id.ordernumber);
            orderprice= itemView.findViewById(R.id.orderprice);
        }
    }
}
