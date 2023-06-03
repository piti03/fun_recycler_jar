package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.listapp.dashboardmodel.CardImageAdapter;
import com.example.listapp.dashboardmodel.CardImageModel;
import com.example.listapp.dashboardmodel.CardListData;
import com.example.listapp.dashboardmodel.DashData;
import com.example.listapp.dashboardmodel.DashModel;
import com.example.listapp.dashboardmodel.DashboardAdapter;
import com.example.listapp.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
 private ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listImageCard();
        listData();
        binding.pushButton.setOnClickListener(view ->naveUp());

    }

    private void listImageCard() {
        List<CardImageModel> cardImageModelList = new ArrayList<>();
        for (int counter = 0; counter < 9 ; counter ++){
            cardImageModelList.add(new CardImageModel(CardListData.card_image_id[counter],
                                                  CardListData.card_image_title[counter] ,
                                                  CardListData.card_image_desc[counter]));
            CardImageAdapter cardImageAdapter = new CardImageAdapter(cardImageModelList);
            binding.imageRecycler.setLayoutManager(new LinearLayoutManager(
                    this,LinearLayoutManager.HORIZONTAL,false));
            binding.imageRecycler.setAdapter(cardImageAdapter);
        }

    }

    private void listData() {
        List<DashModel> dashModelList = new ArrayList<>();
        for (int j=0 ; j < 8 ; j++){
            dashModelList.add(new DashModel(DashData.card_color[j],
                    DashData.image_res[j],
                    DashData.text_dash[j]));
        }
        DashboardAdapter dashboardAdapter = new DashboardAdapter(this,dashModelList);
        binding.myRecycler.setLayoutManager(new LinearLayoutManager(
                this,LinearLayoutManager.HORIZONTAL,false));
        binding.myRecycler.setAdapter(dashboardAdapter);

    }
private void naveUp(){
    Intent intent = new Intent(this,MainActivity.class);
    startActivity(intent);
}
}
