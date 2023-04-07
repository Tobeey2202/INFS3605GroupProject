package com.example.infs3605groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;

import com.example.infs3605groupproject.DistanceMatrix.DistanceService;
import com.example.infs3605groupproject.DistanceMatrix.Element;
import com.example.infs3605groupproject.DistanceMatrix.ResultDistance;
import com.example.infs3605groupproject.DistanceMatrix.Row;
import com.example.infs3605groupproject.objects.Plant;
import com.example.infs3605groupproject.objects.PlantAdapter;
import com.example.infs3605groupproject.objects.Trail;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlantListActivity extends AppCompatActivity implements PlantAdapter.PlantRecyclerViewInterface {
    RecyclerView mRecyclerView;
    private List<Plant> plantList = new ArrayList<>();
    private PlantAdapter plantAdapter;
    private LatLng currentLocation;
    private String distance;

    FusedLocationProviderClient mFusedLocationClient;
    int PERMISSION_ID = 44;


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

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // method to get the location
        getLastLocation();


        //System.out.println("Testing Gson" + getPlantDistanceFake());
        //gsontest();



    }

    public void gsontest(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String sourceLatLng = "-33.915813, 151.216503";
        String destinationLatLng = "-33.915813, 151.226503";



        DistanceService service = retrofit.create(DistanceService.class);
        String API_KEY = "AIzaSyBK_AP1PzxvFOgjbAMH7IwKYno03JGpZ_U";
        Call<ResultDistance> responseCall = service.getDistance(API_KEY, sourceLatLng, destinationLatLng);

        System.out.println("https://maps.googleapis.com/" + "maps/api/distancematrix/" + "json?origins="+sourceLatLng+"&destinations="+destinationLatLng+"&key="+ API_KEY);
        responseCall.enqueue(new Callback<ResultDistance>() {
            @Override
            public void onResponse(Call<ResultDistance> call, Response<ResultDistance> response) {
                ResultDistance myData = response.body();
                if("OK".equalsIgnoreCase(myData.getStatus())){
                    List<Row> row = response.body().getRows();
                    Element element = row.get(0).getElements().get(0);
                    String distance = element.getDistance().getText();
                    System.out.println("Gson retrofit Test " + distance);
                }


            }

            @Override
            public void onFailure(Call<ResultDistance> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Oops something went wrong with the API call", Toast.LENGTH_SHORT);
            }
        });
    }


    public static String getPlantDistanceFake(){
        Gson gson = new Gson();
        String jsonResponse = "{ \"destination_addresses\" : [ \"International House, Kensington NSW 2052, Australia\" ], \"origin_addresses\" : [ \"Village Green, University Mall, UNSW Sydney, Kensington NSW 2052, Australia\" ], \"rows\" : [ { \"elements\" : [ { \"distance\" : { \"text\" : \"1.6 km\", \"value\" : 1648 }, \"duration\" : { \"text\" : \"7 mins\", \"value\" : 444 }, \"status\" : \"OK\" } ] } ], \"status\" : \"OK\" }";
        ResultDistance response = gson.fromJson(jsonResponse, ResultDistance.class);

        List<Row> row = response.getRows();
        Element element = row.get(0).getElements().get(0);
        String distance = element.getDistance().getText();
        return distance;
    }

    @Override
    public void onPlantClick(String plantID){
        Intent intent = new Intent(this, PlantDetailActivity.class);
        intent.putExtra("plantID", plantID);
        startActivity(intent);
    }


    //---------------------------------------------
    //Location Stuff Adapted from: https://www.geeksforgeeks.org/how-to-get-user-location-in-android/
    //---------------------------------------------
    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        // check if permissions are given
        if (checkPermissions()) {

            // check if location is enabled
            if (isLocationEnabled()) {

                // getting last
                // location from
                // FusedLocationClient
                // object
                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {
//                            latitudeTextView.setText(location.getLatitude() + "");
//                            longitTextView.setText(location.getLongitude() + "");
                            printLocation(location.getLatitude(), location.getLongitude());
                        }
                    }
                });
            } else {
                Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            // if permissions aren't available,
            // request for permissions
            requestPermissions();
        }
    }

    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }

    private LocationCallback mLocationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
//            latitudeTextView.setText("Latitude: " + mLastLocation.getLatitude() + "");
//            longitTextView.setText("Longitude: " + mLastLocation.getLongitude() + "");
            printLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude());


        }
    };

    private void printLocation(Double lat, Double longt) {
        String message = lat + " " + longt;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        currentLocation = new LatLng(lat, longt);
        System.out.println("location printed");
        getDistances();
    }

    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        // If we want background location
        // on Android 10.0 and higher,
        // use:
        // ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    // method to request for permissions
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    // If everything is alright then
    @Override
    public void
    onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }
    }

    //Iterate through the list and update all items with the distance
    public void getDistances(){

        System.out.println("Attempting to get distances");
        Plant selectedPlant;
        String destinationList =  "";
        LatLng source = currentLocation;
        for(int i = 0; i< plantList.size(); i++){
            selectedPlant = plantList.get(i);
            LatLng destination = selectedPlant.getLatlng();
            String destinationLatLng = destination.toString().replaceAll(" ", "")
                    .replaceAll("[(){}]", "")
                    .replaceAll("lat/lng", "")
                    .replaceAll(":", "");
            if(destinationList.equals("")){
                destinationList = destinationList + destinationLatLng;
            } else {
                destinationList = destinationList +"|" + destinationLatLng;
            }
        }

        callDirection(source, destinationList);
    }

    public void callDirection(LatLng source, String destination){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String sourceLatLng = source.toString().replaceAll(" ", "")
                .replaceAll("[(){}]", "")
                .replaceAll("lat/lng", "")
                .replaceAll(":", "");
//        String destinationLatLng = destination.toString().replaceAll(" ", "")
//                .replaceAll("[(){}]", "")
//                .replaceAll("lat/lng", "")
//                .replaceAll(":", "");



        DistanceService service = retrofit.create(DistanceService.class);
        String API_KEY = "AIzaSyBK_AP1PzxvFOgjbAMH7IwKYno03JGpZ_U";
        Call<ResultDistance> responseCall = service.getDistance(API_KEY, sourceLatLng, destination);

        System.out.println("https://maps.googleapis.com/" + "maps/api/distancematrix/" + "json?origins="+sourceLatLng+"&destinations="+destination+"&key="+ API_KEY);
        responseCall.enqueue(new Callback<ResultDistance>() {
            @Override
            public void onResponse(Call<ResultDistance> call, Response<ResultDistance> response) {
                plantList = Trail.generatePlantList();
                ResultDistance myData = response.body();
                if("OK".equalsIgnoreCase(myData.getStatus())){
                    List<Row> row = response.body().getRows();
                    List<Element> elements = row.get(0).getElements();
                    System.out.println("Element Size: " + elements.size());
                    for(int i = 0; i <elements.size(); i++){
                        Element selectedElement = elements.get(i);
                        String distance = selectedElement.getDistance().getText();
                        try{
                            plantList.get(i).setDistance(distance);
                        } catch (Exception e){
                            System.out.println("Index Error for----------" + i);
                        }

                        System.out.println("Actual Distance" + distance);
                    }

                    plantAdapter.updateAdapter(plantList);


                }


            }

            @Override
            public void onFailure(Call<ResultDistance> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Oops something went wrong with the API call", Toast.LENGTH_SHORT);
            }
        });
    }



}