package com.example.listapp;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.listapp.databinding.ActivityScrollingBinding;
import com.google.android.material.transition.MaterialContainerTransform;

public class ScrollingActivity extends AppCompatActivity {

    private ActivityScrollingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    Window window = getWindow();
    window.setStatusBarColor(getResources().getColor(R.color.grey));




        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
       CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        FloatingActionButton fab = binding.fab;
        Bundle bundle = getIntent().getExtras();
        binding.imageTool.setImageResource(bundle.getInt("image"));
        binding.textTool.setText(bundle.getString("title"));






    }
}