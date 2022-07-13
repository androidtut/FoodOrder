package com.example.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.foodorder.Adapters.OrderAdapter;
import com.example.foodorder.Models.OrderModels;
import com.example.foodorder.databinding.ActivityOrderBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
private ArrayList<OrderModels>list;
private OrderAdapter adapter;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOrderBinding bindings = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(bindings.getRoot());

        getSupportActionBar().setTitle("Your Orders");

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("UserOrders");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
              for(DataSnapshot snapshot1:snapshot.getChildren()){
                  OrderModels models = snapshot1.getValue(OrderModels.class);
                  list.add(models);
              }
                adapter = new OrderAdapter(list,getApplicationContext());
                bindings.OrderRecycler.setAdapter(adapter);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                bindings.OrderRecycler.setLayoutManager(linearLayoutManager);

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(OrderActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
      }
}