package com.example.infs3605groupproject.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.infs3605groupproject.GoogleMapsActivity;
import com.example.infs3605groupproject.MainActivity;
import com.example.infs3605groupproject.ProfileActivity;
import com.example.infs3605groupproject.QrScannerActivity;
import com.example.infs3605groupproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageButton homeButton, mapButton, codeButton, profileButton;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blank, container, false);
        homeButton = view.findViewById(R.id.detailHomeButton2);

        mapButton = view.findViewById(R.id.detailMapButton2);

        codeButton = view.findViewById(R.id.detailCodeButton2);

        profileButton = view.findViewById(R.id.detailProfileButton2);




        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {clickedOnHomePage();}
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {clickedOnMapPage();}
        });

        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {clickedOnCodePage();}
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {clickedOnProfilePage();}
        });


        return view;
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