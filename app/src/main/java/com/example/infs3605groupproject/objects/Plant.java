package com.example.infs3605groupproject.objects;

import com.google.android.gms.maps.model.LatLng;

public class Plant {
    private String plantId;
    private String plantNameScientific;
    private String plantNameRegular;
    private String location;
    private String traditionalUse;
    private String description;
    private String geographicDistribution;
    private String imagePath;
    private LatLng latlng;
    private String distance;
    private String imagePath2;
    private String facilitiesInfo;
    private Audio audio;
    private int distanceInt;

    public Plant(String plantId, String plantNameScientific, String plantNameRegular, String location, String traditionalUse, String description, String geographicDistribution, String imagePath, String imagePath2) {
        this.plantId = plantId;
        this.plantNameScientific = plantNameScientific;
        this.plantNameRegular = plantNameRegular;
        this.location = location;
        this.traditionalUse = traditionalUse;
        this.description = description;
        this.geographicDistribution = geographicDistribution;
        this.imagePath = imagePath;
        this.imagePath2 = imagePath2;
    }

    public Plant(){

    }

    //Standard Getters and Setters
    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getPlantNameScientific() {
        return plantNameScientific;
    }

    public void setPlantNameScientific(String plantNameScientific) {
        this.plantNameScientific = plantNameScientific;
    }

    public String getPlantNameRegular() {
        return plantNameRegular;
    }

    public void setPlantNameRegular(String plantNameRegular) {
        this.plantNameRegular = plantNameRegular;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTraditionalUse() {
        return traditionalUse;
    }

    public void setTraditionalUse(String traditionalUse) {
        this.traditionalUse = traditionalUse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGeographicDistribution() {
        return geographicDistribution;
    }

    public void setGeographicDistribution(String geographicDistribution) {
        this.geographicDistribution = geographicDistribution;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath2() {
        return imagePath2;
    }

    public void setImagePath2(String imagePath2) {
        this.imagePath2 = imagePath2;
    }

    public LatLng getLatlng() {
        return latlng;
    }

    public void setLatlng(LatLng latlng) {
        this.latlng = latlng;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFacilitiesInfo() {
        return facilitiesInfo;
    }

    public void setFacilitiesInfo(String facilitiesInfo) {
        this.facilitiesInfo = facilitiesInfo;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public int getDistanceInt() {
        return distanceInt;
    }

    public void setDistanceInt(int distanceInt) {
        this.distanceInt = distanceInt;
    }
}
