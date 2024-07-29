package com.android.myapporder;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.myapporder.Adapters.OrderAdapter;
import com.android.myapporder.Models.OrderModel;
import com.android.myapporder.databinding.ActivityMainBinding;
import com.android.myapporder.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrderModel> list=new ArrayList<>();
        list.add(new OrderModel(R.drawable.burger1,"Beef Burger","5","102913"));
        list.add(new OrderModel(R.drawable.burger1,"Beef Burger","5","102913"));
        list.add(new OrderModel(R.drawable.burger1,"Beef Burger","5","102913"));
        list.add(new OrderModel(R.drawable.burger1,"Beef Burger","5","102913"));
        list.add(new OrderModel(R.drawable.burger1,"Beef Burger","5","102913"));
        list.add(new OrderModel(R.drawable.burger1,"Beef Burger","5","102913"));
        list.add(new OrderModel(R.drawable.burger1,"Beef Burger","5","102913"));

        OrderAdapter adapter=new OrderAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);

    }
}