package com.example.infs3605groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.infs3605groupproject.objects.Plant;
import com.example.infs3605groupproject.objects.PlantAdapter;
import com.example.infs3605groupproject.objects.Trail;

import java.util.ArrayList;
import java.util.List;

public class PlantListActivity extends AppCompatActivity implements PlantAdapter.PlantRecyclerViewInterface {
    RecyclerView mRecyclerView;
    private List<Plant> plantList = new ArrayList<>();
    private PlantAdapter plantAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);
        mRecyclerView = findViewById(R.id.rvPlantList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        plantList = Trail.generatePlantList();
        plantAdapter = new PlantAdapter(plantList, this, this);

        mRecyclerView.setAdapter(plantAdapter);

    }

    @Override
    public void onPlantClick(String plantID){
        Intent intent = new Intent(this, PlantDetailActivity.class);
        intent.putExtra("plantID", plantID);
        startActivity(intent);
    }
}