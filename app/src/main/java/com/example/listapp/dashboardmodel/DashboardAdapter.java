package com.example.listapp.dashboardmodel;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listapp.R;
import java.util.ArrayList;
import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder> {
  private List<DashModel> dashModels;
  private Context context;
  public DashboardAdapter(Context context,List<DashModel> dashModels){
      this.dashModels =(dashModels==null)? new ArrayList<>() : dashModels;
      this.context = context;
  }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.doashboard_list_layout,parent,false);
        return new DashboardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
                holder.bind(dashModels.get(position));
                holder.itemView.setOnClickListener(view -> {
                    Toast.makeText(context, dashModels.get(position).getImageTX(), Toast.LENGTH_SHORT).show();
                });
    }

    @Override
    public int getItemCount() {
        return dashModels.size();
    }

    static class DashboardViewHolder extends RecyclerView.ViewHolder{
           ImageView myCard;
           ImageView myImage;
           TextView txCard;

        public DashboardViewHolder( View itemView) {
            super(itemView);
            myCard = itemView.findViewById(R.id.card_dash_item);
            myImage = itemView.findViewById(R.id.image_dash_item);
            txCard = itemView.findViewById(R.id.text_dash_item);

        }
        public void bind(DashModel dashModel){
            myCard.setImageResource(dashModel.getCard_color());
            myImage.setImageResource(dashModel.getImage_id());
            txCard.setText(dashModel.getImageTX());
        }

    }
}
