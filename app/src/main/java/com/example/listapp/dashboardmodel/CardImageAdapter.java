package com.example.listapp.dashboardmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listapp.R;
import java.util.ArrayList;
import java.util.List;

public class CardImageAdapter extends RecyclerView.Adapter<CardImageAdapter.MyViewHolder> {
  List<CardImageModel> cardImageModels;
    public CardImageAdapter(List<CardImageModel> cardImageModels){
        this.cardImageModels =(cardImageModels == null)? new ArrayList<>() : cardImageModels;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemView =   LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_image_card,parent,false);
           return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(cardImageModels.get(position));

    }

    @Override
    public int getItemCount() {
        return cardImageModels.size();
    }

   static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView myImage;
        TextView myTextTitle,myTextDesc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myImage = itemView.findViewById(R.id.card_list_image);
            myTextTitle = itemView.findViewById(R.id.card_list_title);
            myTextDesc = itemView.findViewById(R.id.card_list_desc);

        }
        public void bind(CardImageModel cardImageModel){
            myImage.setImageResource(cardImageModel.getCardListImage());
            myTextTitle.setText(cardImageModel.getCardListTitle());
            myTextDesc.setText(cardImageModel.getCardListDescription());

        }

    }

}
