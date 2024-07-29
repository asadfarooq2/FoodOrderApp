package com.android.myapporder;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.myapporder.databinding.ActivityDetailBinding;
import com.android.myapporder.databinding.ActivityOrderBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int image = getIntent().getIntExtra("image", 0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("desc");

        binding.detailImg.setImageResource(image);
        binding.priceLbl.setText(String.format("%d", price));
        binding.foodName.setText(name);
        binding.detailDescription.setText(description);

        final DBHelper helper = new DBHelper(this);

        binding.insertOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = helper.insertOrder(
                        binding.detailName.getText().toString(),
                        binding.detailNumber.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        Integer.parseInt(binding.quan.getText().toString())
                );
                if(isInserted)
                    Toast.makeText(DetailActivity.this,"Data Success",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DetailActivity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }}