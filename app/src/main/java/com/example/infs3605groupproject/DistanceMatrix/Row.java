package com.example.infs3605groupproject.DistanceMatrix;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Row {

    @SerializedName("elements")
    @Expose
    private List<Element> elements;

    /**
     * No args constructor for use in serialization
     *
     */
    public Row() {
    }

    /**
     *
     * @param elements
     */
    public Row(List<Element> elements) {
        super();
        this.elements = elements;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

}
