package com.example.foodorder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.foodorder.databinding.ActivityDetailsPageBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailsPage extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference,userid;
    String name,phone,fooddesc,foodprice,foodname;
    ActivityDetailsPageBinding binding;
    int id,foodimage,quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("UserOrders");

        if (getIntent().getStringExtra("type").equals("insert")) {
            id = getIntent().getIntExtra("id",1);
            foodimage = getIntent().getIntExtra("foodimage",0);
            fooddesc = getIntent().getStringExtra("fooddesc");
            foodname = getIntent().getStringExtra("foodname");
            foodprice = getIntent().getStringExtra("foodprice");
            quantity = 1;

            binding.fooditemimage.setImageResource(foodimage);
            binding.fooditemsname.setText(foodname);
            binding.fooditemsdesc.setText(fooddesc);
            binding.checkoutprice.setText(foodprice);

            binding.checkoutbtn.setOnClickListener(v->{
            name = binding.name.getText().toString();
            phone = binding.phonenumber.getText().toString();

        if(name.isEmpty()){
            Toast.makeText(this, "Name most be Required", Toast.LENGTH_SHORT).show();
        }else if(phone.isEmpty()){
            Toast.makeText(this, "phone number most be Required", Toast.LENGTH_SHORT).show();
        }else {
                userid = databaseReference.push();
//                two way to insert data from firebase database using constructor and child
//                userid.child("solditemName").setValue(name);
//                userid.child("orderNumber").setValue(phone);
//                userid.child("orderfoodimage").setValue(foodimage);
//                userid.child("Orderprice").setValue(foodprice);
//                userid.child("foodname").setValue(foodname);
//                userid.child("desc").setValue(fooddesc);
//                userid.child("quantity").setValue(quantity);

                 Orders order = new Orders(foodprice,fooddesc,foodname,name,phone,foodimage,quantity);
                 userid.setValue(order).addOnSuccessListener(new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void unused) {
                         Toast.makeText(DetailsPage.this, "Order submit", Toast.LENGTH_SHORT).show();
                     }
                 });

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(5000);
                            Snackbar snackbar = Snackbar.make(binding.textView, "Your order has be send", Snackbar.LENGTH_SHORT);
                            snackbar.show();
                            startActivity(new Intent(DetailsPage.this, OrderActivity.class));
                        } catch (Exception e) {
                            Toast.makeText(DetailsPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                thread.start();
            }
        });
        }else{

           }
    }

//        if(id == 0){
//            binding.fooditemimage.setImageResource(R.drawable.food2);
//            }else if(id == 1){
//            binding.fooditemimage.setImageResource(R.drawable.food1);
//           }else if(id == 2){
//            binding.fooditemimage.setImageResource(R.drawable.food3);
//            }

//        Picasso.get().load(foodimage).into(binding.fooditemimage);


}