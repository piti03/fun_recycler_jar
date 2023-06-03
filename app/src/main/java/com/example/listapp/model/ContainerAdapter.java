package com.example.listapp.model;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listapp.R;
import com.example.listapp.ScrollingActivity;

import java.util.ArrayList;
import java.util.List;

public class ContainerAdapter extends RecyclerView.Adapter<ContainerAdapter.MyViewHolder> {
public List<Container> containerList;
private Context context;
private long Duration = 500;
private boolean on_attach = true;
public ContainerAdapter(Context context,List<Container> containers){
   this.containerList=(containers ==null)?new ArrayList<>():containers;
   this.context = context;
}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemView =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_container,parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(containerList.get(position));
        setAnimation(holder.itemView,position);
        holder.itemView.setOnClickListener( view -> {
           Intent navigator = new Intent(context,ScrollingActivity.class);
           navigator.putExtra("image",containerList.get(position).getImageId());
           navigator.putExtra("title" , holder.textTitle.getText());
           navigator.putExtra("desc" , holder.textDesc.getText());
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
             (Activity) context,holder.imageView,"Transition");
            ActivityCompat.startActivity(context,navigator,optionsCompat.toBundle());

        });
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            on_attach =false;
            super.onScrollStateChanged(recyclerView, newState);
        }
    });
        super.onAttachedToRecyclerView(recyclerView);
    }

    private void setAnimation(View itemView, int position) {
    if (!on_attach){
        position = -1;
    }
    boolean isNotFirstItem = position == -1;
    position ++;
    itemView.setAlpha(0.f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofFloat(itemView,"alpha",0.f,.5f,1.f);
        ObjectAnimator.ofFloat(itemView,"alpha",0.f).start();
        animator.setStartDelay(isNotFirstItem ? Duration /2  :(position * Duration /3 ));
        animator.setDuration(500);
        animatorSet.playTogether(animator);
        animatorSet.start();
    }
    /*

    private void FromLeftToRight(View itemView, int position) {


        if(!on_attach){
            position = -1;
        }
        boolean not_first_item = position == -1;
        position += 1;
        itemView.setTranslationX(-400f);
        itemView.setAlpha(0.f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(itemView, "translationX", -400f, 0);
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(itemView, "alpha", 1.f);
        ObjectAnimator.ofFloat(itemView, "alpha", 0.f).start();
        animatorTranslateY.setStartDelay(not_first_item ? Duration /2 : (position * Duration/2));
        animatorTranslateY.setDuration((not_first_item ? 2 : 1) * Duration/2);
        animatorSet.playTogether(animatorTranslateY, animatorAlpha);
        animatorSet.start();
    }

     */

    @Override
    public int getItemCount() {
        return containerList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
       ImageView imageView;
       TextView textTitle;
       TextView textDesc;
        MyViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.container_image);
            textTitle = itemView.findViewById(R.id.title_container);
            textDesc = itemView.findViewById(R.id.description_container);
        }
        public void bind(Container container){
            imageView.setImageResource(container.getImageId());
            textTitle.setText(container.getTitle());
            textDesc.setText(container.getDescription());
        }
    }

}


