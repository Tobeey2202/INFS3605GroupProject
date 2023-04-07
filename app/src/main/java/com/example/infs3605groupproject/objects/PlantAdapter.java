package com.example.infs3605groupproject.objects;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.example.infs3605groupproject.R;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.MyViewHolder> {

    private List<Plant> plantList;
    private PlantRecyclerViewInterface mInterface;
    private Context context;

    public PlantAdapter(List<Plant> plantList, PlantRecyclerViewInterface plantInterface, Context context){
        this.plantList = plantList;
        this.mInterface = plantInterface;
        this.context = context;
    }

    @NonNull
    @Override
    public PlantAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantAdapter.MyViewHolder holder, int position) {
        Plant plant = plantList.get(position);
        holder.txtScientificName.setText(plant.getPlantNameScientific());
        holder.txtName.setText(plant.getPlantNameRegular());
        holder.itemView.setTag(plant.getPlantId());

        if(plant.getDistance() != null){
            holder.distance.setVisibility(View.VISIBLE);
            holder.distance.setText("Distance: " + plant.getDistance());
        } else{
            holder.distance.setVisibility(View.INVISIBLE);
        }

        Glide.with(context)
        .load(context.getResources()
        .getIdentifier(plant.getImagePath(), "drawable", context.getPackageName()))
        .circleCrop()
        .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtScientificName, distance;
        private ImageView imgView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtViewPlantNameRecyclerView);
            txtScientificName = itemView.findViewById(R.id.txtViewPlantNameScientificRecyclerView);
            imgView = itemView.findViewById(R.id.plantImageRecyclerView);
            distance = itemView.findViewById(R.id.txtViewDistance);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mInterface.onPlantClick((String) itemView.getTag());
                }
            });
        }
    }

    public interface PlantRecyclerViewInterface{
        void onPlantClick(String plantID);
    }


    public void updateAdapter(List<Plant> newPlantList){
        plantList.clear();
        plantList.addAll(newPlantList);
        notifyDataSetChanged();
    }
}
