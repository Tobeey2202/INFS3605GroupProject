package com.example.infs3605groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.example.infs3605groupproject.Location.PermissionUtils;
import com.example.infs3605groupproject.Routing.DirectionPointListener;
import com.example.infs3605groupproject.Routing.GetPathFromLocation;
import com.example.infs3605groupproject.objects.Plant;
import com.example.infs3605groupproject.objects.Trail;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.infs3605groupproject.databinding.ActivityGoogleMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.Manifest.permission;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;


public class GoogleMapsActivity extends AppCompatActivity implements GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {
    /**
     * Request code for location permission request.
     *
     * @see #onRequestPermissionsResult(int, String[], int[])
     */
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    /**
     * Flag indicating whether a requested permission has been denied after returning in {@link
     * #onRequestPermissionsResult(int, String[], int[])}.
     */
    private boolean permissionDenied = false;
    private GoogleMap mMap;
    private ActivityGoogleMapsBinding binding;
    private Button btnMoreInfo;
    private Switch routeSwitch;
    Polyline polylineFinal = null;
    GoogleMapOptions options = new GoogleMapOptions();

    Plant plantToView;
    ArrayList<Marker> markerList = new ArrayList<>();
    ArrayList<Plant> plantList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //binding = ActivityGoogleMapsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_google_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        routeSwitch = findViewById(R.id.routeSwitch);
        btnMoreInfo = findViewById(R.id.btnMoreInfo);

        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBtnMoreInfo();
            }
        });
    }

    //Used to link to plant detail page
    public void handleBtnMoreInfo(){
        if(plantToView ==null) {
            Toast.makeText(this, "You must select a plant first", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, PlantDetailActivity.class);
            intent.putExtra("plantID", plantToView.getPlantId());
            startActivity(intent);
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint({"MissingPermission", "PotentialBehaviorOverride"})
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        enableMyLocation();
        //For enabling userlocation on the map
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);

//        options.mapType(GoogleMap.MAP_TYPE_NORMAL)
//                .compassEnabled(true)
//                .rotateGesturesEnabled(true)
//                .tiltGesturesEnabled(true);


        // Set up plant markers on map
        LatLng plant1LatLng = new LatLng(-33.917298, 151.226410);
        Marker p1 = mMap.addMarker(new MarkerOptions().position(plant1LatLng).title("Hill's Fig"));

        LatLng plant2LatLng = new LatLng(-33.916627, 151.226242);
        Marker p2 = mMap.addMarker(new MarkerOptions().position(plant2LatLng).title("Gymea Lily"));

        LatLng plant3LatLng = new LatLng(-33.916239, 151.226673);
        Marker p3 = mMap.addMarker(new MarkerOptions().position(plant3LatLng).title("Broad-leaved Paperbark"));

        LatLng plant4LatLng = new LatLng(-33.915813, 151.226503);
        Marker p4 = mMap.addMarker(new MarkerOptions().position(plant4LatLng).title("Crimson Bottlebrush"));

        LatLng plant5LatLng = new LatLng(-33.915613, 151.226610);
        Marker p5 = mMap.addMarker(new MarkerOptions().position(plant5LatLng).title("Heath Banksia"));

        LatLng plant6LatLng = new LatLng(-33.9156603, 151.2268734);
        Marker p6 = mMap.addMarker(new MarkerOptions().position(plant6LatLng).title("Mountain Cedar Wattle"));

        LatLng plant7LatLng = new LatLng(-33.915810, 151.226889);
        Marker p7 = mMap.addMarker(new MarkerOptions().position(plant7LatLng).title("Native Mint"));

        LatLng plant8LatLng = new LatLng(-33.916137, 151.228144);
        Marker p8 = mMap.addMarker(new MarkerOptions().position(plant8LatLng).title("Tuckeroo"));

        LatLng plant9LatLng = new LatLng(-33.917090, 151.232118);
        Marker p9 = mMap.addMarker(new MarkerOptions().position(plant9LatLng).title("Prickly-leaved Tea Tree"));

        LatLng plant10LatLng = new LatLng(-33.917239, 151.232071);
        Marker p10 = mMap.addMarker(new MarkerOptions().position(plant10LatLng).title("Water Vine"));

        LatLng plant11LatLng = new LatLng(-33.917341, 151.232045);
        Marker p11 = mMap.addMarker(new MarkerOptions().position(plant11LatLng).title("Rock Lily"));

        LatLng plant12LatLng = new LatLng(-33.917481, 151.232010);
        Marker p12 = mMap.addMarker(new MarkerOptions().position(plant12LatLng).title("Sandpaper Fig"));

        LatLng plant13LatLng = new LatLng(-33.916864, 151.234317);
        Marker p13 = mMap.addMarker(new MarkerOptions().position(plant13LatLng).title("Burrawang"));

        LatLng plant14LatLng = new LatLng(-33.9164057, 151.2343634);
        Marker p14 = mMap.addMarker(new MarkerOptions().position(plant14LatLng).title("Plum Pine / Brown Pine"));

        LatLng plant15LatLng = new LatLng(-33.916681, 151.234676);
        Marker p15 = mMap.addMarker(new MarkerOptions().position(plant15LatLng).title("Tussock Grass"));

        LatLng plant16LatLng = new LatLng(-33.9168536, 151.2347782);
        Marker p16 = mMap.addMarker(new MarkerOptions().position(plant16LatLng).title("Cabbage Tree Palm"));

        LatLng plant17LatLng = new LatLng(-33.9179983, 151.2347711);
        Marker p17 = mMap.addMarker(new MarkerOptions().position(plant17LatLng).title("Bolwarra"));

        LatLng plant18LatLng = new LatLng(-33.917949, 151.234529);
        Marker p18 = mMap.addMarker(new MarkerOptions().position(plant18LatLng).title("Blue Flax Lily / Blueberry Lily"));

        LatLng plant19LatLng = new LatLng(-33.917927, 151.234285);
        Marker p19 = mMap.addMarker(new MarkerOptions().position(plant19LatLng).title("Saw Banksia / Old Man Banksia"));

        LatLng plant20LatLng = new LatLng(-33.917801, 151.232152);
        Marker p20 = mMap.addMarker(new MarkerOptions().position(plant20LatLng).title("Spiny-headed Mat-rush"));

        LatLng plant21LatLng = new LatLng(-33.917967, 151.232086);
        Marker p21 = mMap.addMarker(new MarkerOptions().position(plant21LatLng).title("Riberry"));

        LatLng plant22LatLng = new LatLng(-33.918263, 151.232022);
        Marker p22 = mMap.addMarker(new MarkerOptions().position(plant22LatLng).title("Grass Tree"));

        LatLng plant23LatLng = new LatLng(-33.917059, 151.230013);
        Marker p23 = mMap.addMarker(new MarkerOptions().position(plant23LatLng).title("Native Ginger"));

        LatLng plant24LatLng = new LatLng(-33.917237, 151.230294);
        Marker p24 =mMap.addMarker(new MarkerOptions().position(plant24LatLng).title("Illawarra Flame Tree"));

        LatLng plant25LatLng = new LatLng(-33.9173428, 151.2278755);
        Marker p25 =mMap.addMarker(new MarkerOptions().position(plant25LatLng).title("Port Jackson Fig"));

        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(plant24LatLng));

        markerList.add(p1);
        markerList.add(p2);
        markerList.add(p3);
        markerList.add(p4);
        markerList.add(p5);
        markerList.add(p6);
        markerList.add(p7);
        markerList.add(p8);
        markerList.add(p9);
        markerList.add(p10);
        markerList.add(p11);
        markerList.add(p12);
        markerList.add(p13);
        markerList.add(p14);
        markerList.add(p15);
        markerList.add(p16);
        markerList.add(p17);
        markerList.add(p18);
        markerList.add(p19);
        markerList.add(p20);
        markerList.add(p21);
        markerList.add(p22);
        markerList.add(p23);
        markerList.add(p24);
        markerList.add(p25);

        mMap.setInfoWindowAdapter(new InfoWindowAdapter(GoogleMapsActivity.this));
        plantList = Trail.generatePlantList();

        // Retrieve plant data upon user clicking marker
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker m) {
                String value = m.getTitle();
                Plant selectedPlant = new Plant();
                for(Plant p : plantList){
                    if(p.getPlantNameRegular().equals(value)){
                        selectedPlant = p;
                        break;
                    }
                }
                m.setSnippet(selectedPlant.getPlantNameScientific()+"\n"+"\n"+"Traditional Use: "+selectedPlant.getTraditionalUse());
                //Added to allow linking of map and plant
                plantToView = selectedPlant;
                return false;
            }
        });

        //Handle navigation change
        handleAutoSelectionFromPlantDetail();

        LatLng source = plant1LatLng;
        LatLng destination = plant2LatLng;

        routeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    new GetPathFromLocation(source, destination, new DirectionPointListener() {
                        @Override
                        public void onPath(PolylineOptions polyLine) {
                            showPolyline(polyLine);
                        }
                    }).execute();
                } else {
                    polylineFinal.remove();
                }
            }
        });

    }

    private void showPolyline(PolylineOptions polyLine) {
        polylineFinal = mMap.addPolyline(polyLine);
    }

    private void handleAutoSelectionFromPlantDetail(){

        //Handling linkage to the map
        Intent intent = getIntent();
        String plantName = intent.getStringExtra("plantName");
        if (intent == null) {
            System.out.println("INTENT NULL");
        }

        try{
            if(plantName != null){
                for(Marker m: markerList){
                    String value = m.getTitle();
                    if (value.equals(plantName)){
                        Plant selectedPlant = new Plant();
                        for(Plant p : plantList){
                            if(p.getPlantNameRegular().equals(value)){
                                selectedPlant = p;
                                break;
                            }
                        }
                        m.setSnippet(selectedPlant.getPlantNameScientific()+"\n"+"\n"+selectedPlant.getDescription()+"\n"+"Traditional Use: "+selectedPlant.getTraditionalUse());
                        plantToView = selectedPlant;
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(m.getPosition()));
                        m.showInfoWindow();
                    }
                }
            } else{
                System.out.println("PLANT NAME NULL");
            }
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "Plant Not Found 404", Toast.LENGTH_SHORT).show();
        }
    }

    //Location stuff - maybe move?
    @SuppressLint("MissingPermission")
    private void enableMyLocation() {
        // 1. Check if permissions are granted, if so, enable the my location layer
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            System.out.println("Location Layer Enabled");
            return;
        }

        // 2. Otherwise, request location permissions from the user.
        PermissionUtils.requestLocationPermissions(this, LOCATION_PERMISSION_REQUEST_CODE, true);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION) || PermissionUtils
                .isPermissionGranted(permissions, grantResults,
                        Manifest.permission.ACCESS_COARSE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Permission was denied. Display an error message
            // Display the missing permission error dialog when the fragments resume.
            permissionDenied = true;
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (permissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            permissionDenied = false;
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }


}