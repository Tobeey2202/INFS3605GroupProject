package com.example.infs3605groupproject.objects;

public class Plant {
    private String plantId;
    private String plantNameScientific;
    private String plantNameRegular;
    private String location;
    private String locationID;
    private String description;
    private String geographicDistribution;

    public Plant(String plantId, String plantNameScientific, String plantNameRegular, String location, String locationID, String description, String geographicDistribution) {
        this.plantId = plantId;
        this.plantNameScientific = plantNameScientific;
        this.plantNameRegular = plantNameRegular;
        this.location = location;
        this.locationID = locationID;
        this.description = description;
        this.geographicDistribution = geographicDistribution;
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

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
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
}
