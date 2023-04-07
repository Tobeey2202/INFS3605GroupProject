package com.example.infs3605groupproject.DistanceMatrix;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class ResultDistance {

    @SerializedName("destination_addresses")
    @Expose
    private List<String> destinationAddresses;
    @SerializedName("origin_addresses")
    @Expose
    private List<String> originAddresses;
    @SerializedName("rows")
    @Expose
    private List<Row> rows;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResultDistance() {
    }

    /**
     *
     * @param originAddresses
     * @param destinationAddresses
     * @param rows
     * @param status
     */
    public ResultDistance(List<String> destinationAddresses, List<String> originAddresses, List<Row> rows, String status) {
        super();
        this.destinationAddresses = destinationAddresses;
        this.originAddresses = originAddresses;
        this.rows = rows;
        this.status = status;
    }

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public List<String> getOriginAddresses() {
        return originAddresses;
    }

    public void setOriginAddresses(List<String> originAddresses) {
        this.originAddresses = originAddresses;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}