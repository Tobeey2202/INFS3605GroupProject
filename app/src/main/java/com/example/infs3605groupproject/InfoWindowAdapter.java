package com.example.infs3605groupproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter{

    private final View mWindow;
    private Context mContext;

    public InfoWindowAdapter (Context context) {
        mContext = context;
        mWindow = LayoutInflater.from(context).inflate(R.layout.info_window, null);
    }

    private void setWindowText(Marker marker, View view) {
        String title = marker.getTitle();
        TextView titleTv = (TextView) view.findViewById(R.id.title);
        titleTv.setText(title);
        String snippet = marker.getSnippet();
        TextView snippetTv = (TextView) view.findViewById(R.id.snippet);
        snippetTv.setText(snippet);
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        setWindowText(marker, mWindow);
        return mWindow;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        setWindowText(marker, mWindow);
        return null;
    }


}
