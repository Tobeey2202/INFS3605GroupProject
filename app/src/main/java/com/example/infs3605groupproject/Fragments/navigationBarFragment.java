package com.example.infs3605groupproject.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.infs3605groupproject.GoogleMapsActivity;
import com.example.infs3605groupproject.MainActivity;
import com.example.infs3605groupproject.ProfileActivity;
import com.example.infs3605groupproject.QrScannerActivity;
import com.example.infs3605groupproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link navigationBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class navigationBarFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String menuIconToSelect = "param1";
    private static final String ARG_PARAM2 = "param2";
    private BottomNavigationView bottomNavigationView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public navigationBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment navigationBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static navigationBarFragment newInstance(String param1, String param2) {
        navigationBarFragment fragment = new navigationBarFragment();
        Bundle args = new Bundle();
        args.putString(menuIconToSelect, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(menuIconToSelect);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_navigation_bar, container, false);
        bottomNavigationView = view.findViewById(R.id.navigationBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuProfile:
                clickedOnProfilePage();
                return true;

            case R.id.menuHome:
                clickedOnHomePage();
                return true;

            case R.id.menuMap:
                clickedOnMapPage();
                return true;
            case R.id.menuQRCode:
                clickedOnCodePage();
                return true;
        }
        return false;
    }


    public void clickedOnHomePage(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    public void clickedOnMapPage(){
        Intent intent = new Intent(getActivity(), GoogleMapsActivity.class);
        startActivity(intent);
        System.out.print("map page works");
    }

    public void clickedOnCodePage(){
        Intent intent = new Intent(getActivity(), QrScannerActivity.class);
        startActivity(intent);
    }

    public void clickedOnProfilePage(){
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        startActivity(intent);
    }
}