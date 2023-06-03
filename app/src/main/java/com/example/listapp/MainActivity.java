package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.Animation;
import com.example.listapp.model.Container;
import com.example.listapp.model.ContainerAdapter;
import com.example.listapp.model.Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        ContainerAdapter adapter;
        List<Container> containers = new ArrayList<>();
        for(int i = 0 ; i < 20 ; i++){
            containers.add(new Container(Data.images[i],Data.titls[i],Data.descs[i]));
        }
        adapter = new ContainerAdapter(this,containers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        recyclerView.setAnimation(new Animation() {
            @Override
            protected Animation clone() throws CloneNotSupportedException {
                return super.clone();
            }
        });







    }
}