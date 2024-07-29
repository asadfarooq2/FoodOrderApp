package com.android.myapporder;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.myapporder.Adapters.MainAdapter;
import com.android.myapporder.Models.MainModel;
import com.android.myapporder.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();

        list.add(new MainModel(R.drawable.burger1,"Burger","5","This is a Burger"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","10","This is a Pizza"));
        list.add(new MainModel(R.drawable.fries1,"Fries","3","This is Potato Fries"));
        list.add(new MainModel(R.drawable.ice_cream,"IceCream","6","This is an Ice Cream"));
        list.add(new MainModel(R.drawable.sandwich1,"Sandwich","4","This is a Sandwich"));

        MainAdapter adapter=new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);


}}
