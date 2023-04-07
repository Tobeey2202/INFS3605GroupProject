package com.example.infs3605groupproject.DistanceMatrix;

import com.google.gson.Gson;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



//@Generated("jsonschema2pojo")
public class Distance {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("value")
    @Expose
    private Integer value;

    /**
     * No args constructor for use in serialization
     *
     */
    public Distance() {
    }

    /**
     *
     * @param text
     * @param value
     */
    public Distance(String text, Integer value) {
        super();
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
