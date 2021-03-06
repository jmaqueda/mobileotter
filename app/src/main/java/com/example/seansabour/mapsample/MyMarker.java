package com.example.seansabour.mapsample;

/**
 * Created by seansabour on 3/14/15.
 */
public class MyMarker {
    private String name;
    private Double mLatitude;
    private Double mLongitude;
    private String id;

    public MyMarker(String name, Double mLatitude, Double mLongitude, String id){//, Integer id) {
        this.name = name;
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public Double getmLatitude() {
        return mLatitude;
    }

    public Double getmLongitude() {
        return mLongitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setmLatitude(Double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public void setmLongitude(Double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
