package com.example.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorder.Adapters.foodAdapter;
import com.example.foodorder.Models.foodModels;
import com.example.foodorder.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 ArrayList<foodModels>list;
 foodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        list.add(new foodModels(R.drawable.burger,"30","Burger","this is Burger"));
        list.add(new foodModels(R.drawable.food1,"50","noodels","this is noodels"));
        list.add(new foodModels(R.drawable.food2,"20","biscuites","this is biscuites this is biscuites this is Burger this is Burger"));
        list.add(new foodModels(R.drawable.food3,"80","chicken momo","this is chicken momo"));
        list.add(new foodModels(R.drawable.pizza,"70","momo","this is momo"));
        list.add(new foodModels(R.drawable.priza_burger,"300","Burger","this is Burger"));

        adapter = new foodAdapter(list,this);
        binding.foodRecycler.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.foodRecycler.setLayoutManager(linearLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.yourOrders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}