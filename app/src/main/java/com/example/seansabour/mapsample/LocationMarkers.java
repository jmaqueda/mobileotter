package com.example.seansabour.mapsample;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by seansabour on 3/14/15.
 */
public class LocationMarkers {
    private HashMap<Marker,MyMarker> mMarkersHashMap = mMarkersHashMap = new HashMap<Marker,MyMarker>();
    private static LocationMarkers uniqueInstance;
    private ArrayList<MyMarker> mMyMarkersArray;

    public static LocationMarkers getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new LocationMarkers();
            return uniqueInstance;
        } else
            return uniqueInstance;
    }

    LocationMarkers(){
        mMyMarkersArray = new ArrayList<MyMarker>();
        mMyMarkersArray.add(new MyMarker("Aquatic Center",Double.parseDouble("36.651461"),Double.parseDouble("-121.807472"),"100"));
        mMyMarkersArray.add(new MyMarker("Otter Sports Complex",Double.parseDouble("36.654419"),Double.parseDouble("-121.808296"),"90"));
        mMyMarkersArray.add(new MyMarker("Ocean Hall",Double.parseDouble("36.655620"),Double.parseDouble("-121.807188"),"86"));
        mMyMarkersArray.add(new MyMarker("Mountain Hall",Double.parseDouble("36.655415"),Double.parseDouble("-121.806263"),"84"));
        mMyMarkersArray.add(new MyMarker("Valley Hall Police Department",Double.parseDouble("36.655388"),Double.parseDouble("-121.804368"),"82"));
        mMyMarkersArray.add(new MyMarker("Black Box Cabaret",Double.parseDouble("36.655748"),Double.parseDouble("-121.803672"),"81"));
        mMyMarkersArray.add(new MyMarker("Health & Wellness Services",Double.parseDouble("36.655575"),Double.parseDouble("-121.803177"),"80"));
        mMyMarkersArray.add(new MyMarker("Alunmi & Visitors Center",Double.parseDouble("36.654446"),Double.parseDouble("-121.801787"),"97"));
        mMyMarkersArray.add(new MyMarker("Meeting House",Double.parseDouble("36.6532752"),Double.parseDouble("-121.8015193"),"100"));
        mMyMarkersArray.add(new MyMarker("Tide Hall",Double.parseDouble("36.652632"),Double.parseDouble("-121.800238"),"23"));
        mMyMarkersArray.add(new MyMarker("Beach Hall",Double.parseDouble("36.652631"),Double.parseDouble("-121.799177"),"21"));
        mMyMarkersArray.add(new MyMarker("Media Learning Center",Double.parseDouble("36.654248"),Double.parseDouble("-121.799848"),"18"));
        mMyMarkersArray.add(new MyMarker("CSUMB Dinning Commons",Double.parseDouble("36.6541828"),Double.parseDouble("-121.7988633"),"16"));
        mMyMarkersArray.add(new MyMarker("Otter Express",Double.parseDouble("36.654212"),Double.parseDouble("-121.798234"),"14"));
        mMyMarkersArray.add(new MyMarker("Student Center",Double.parseDouble("36.654151"),Double.parseDouble("-121.797485"),"12"));
        mMyMarkersArray.add(new MyMarker("College of Professional Studies",Double.parseDouble("36.6530531"),Double.parseDouble("-121.7981156"),"3"));
        mMyMarkersArray.add(new MyMarker("Institutional Assessment and Research Surf Hall",Double.parseDouble("36.653569"),Double.parseDouble("-121.7973364"),"6"));
        mMyMarkersArray.add(new MyMarker("Starbucks",Double.parseDouble("36.6542463"),Double.parseDouble("-121.7974028"),"12"));
        mMyMarkersArray.add(new MyMarker("Journalism and Media Studies Wave Hall",Double.parseDouble("36.653584"),Double.parseDouble("-121.796068"),"4"));
        mMyMarkersArray.add(new MyMarker("Visual and Public Art (VPA) West",Double.parseDouble("36.6553447"),Double.parseDouble("-121.7959571"),"73"));
        mMyMarkersArray.add(new MyMarker("Visual and Public Art",Double.parseDouble("36.6553109"),Double.parseDouble("-121.7956232"),"72"));
        mMyMarkersArray.add(new MyMarker("Visual and Public Art (VPA) East",Double.parseDouble("36.6553404"),Double.parseDouble("-121.7952671"),"71"));
        mMyMarkersArray.add(new MyMarker("CSUMB Library",Double.parseDouble("36.6523091"),Double.parseDouble("-121.7961904"),"508"));
        mMyMarkersArray.add(new MyMarker("Chapman Science Academic Center",Double.parseDouble("36.653323"),Double.parseDouble("-121.794764"),"53"));
        mMyMarkersArray.add(new MyMarker("University Corporation",Double.parseDouble("36.654399"),Double.parseDouble("-121.792962"),"201"));
        mMyMarkersArray.add(new MyMarker("Science Instructional Lab Annex",Double.parseDouble("36.6530445"),Double.parseDouble("-121.7927753"),"50"));
        mMyMarkersArray.add(new MyMarker("Oaks Hall",Double.parseDouble("36.654970"),Double.parseDouble("-121.792147"),"490"));
        mMyMarkersArray.add(new MyMarker("Science Research Lab Annex",Double.parseDouble("36.6526254"),Double.parseDouble("-121.793932"),"13"));
        mMyMarkersArray.add(new MyMarker("World Languages and Cultures - North Building",Double.parseDouble("36.6525662"),Double.parseDouble("-121.792597"),"49"));
        mMyMarkersArray.add(new MyMarker("Reading Center",Double.parseDouble("36.652550"),Double.parseDouble("-121.790589"),"59"));
        mMyMarkersArray.add(new MyMarker("Green Hall",Double.parseDouble("36.652071"),Double.parseDouble("-121.790506"),"58"));
        mMyMarkersArray.add(new MyMarker("World Languages and Cultures - South",Double.parseDouble("36.6520842"),Double.parseDouble("-121.7926861"),"48"));
        mMyMarkersArray.add(new MyMarker("Cinematic Arts and Technology Building",Double.parseDouble("36.65184"),Double.parseDouble("-121.793867"),"27"));
        mMyMarkersArray.add(new MyMarker("Student Services Building",Double.parseDouble("36.6516253"),Double.parseDouble("-121.792953"),"47"));
        mMyMarkersArray.add(new MyMarker("College of Arts, Humanities, and Social Sciences Building Harbor Hall",Double.parseDouble("36.6511438"),Double.parseDouble("-121.7930422"),"46"));
        mMyMarkersArray.add(new MyMarker("World Theater",Double.parseDouble("36.6508797"),Double.parseDouble("-121.793932"),"28"));
        mMyMarkersArray.add(new MyMarker("Coast Hall",Double.parseDouble("36.6506876"),Double.parseDouble("-121.7931093"),"45"));
        mMyMarkersArray.add(new MyMarker("Pacific Hall",Double.parseDouble("36.6502615"),Double.parseDouble("-121.7927532"),"44"));
        mMyMarkersArray.add(new MyMarker("University Center(Montes)",Double.parseDouble("36.6499899"),Double.parseDouble("-121.7942438"),"29"));
        mMyMarkersArray.add(new MyMarker("CSUMB Book Store",Double.parseDouble("36.6498828"),Double.parseDouble("-121.7939401"),"29"));
        mMyMarkersArray.add(new MyMarker("Watershed Institute",Double.parseDouble("36.649820"),Double.parseDouble("-121.792586"),"42"));
        mMyMarkersArray.add(new MyMarker("Camp SEA Lab",Double.parseDouble("36.6496057"),Double.parseDouble("-121.792772"),"42"));
        mMyMarkersArray.add(new MyMarker("IT Services",Double.parseDouble("36.6492959"),Double.parseDouble("-121.7931314"),"43"));
        mMyMarkersArray.add(new MyMarker("Music Hall",Double.parseDouble("36.6479127"),Double.parseDouble("-121.7944665"),"30"));
        mMyMarkersArray.add(new MyMarker("Sand Hall",Double.parseDouble("36.653509"),Double.parseDouble("-121.799320"),"8"));
        mMyMarkersArray.add(new MyMarker("Facilities Services and Operations",Double.parseDouble("36.648980"),Double.parseDouble("-121.787847"),"37"));
        mMyMarkersArray.add(new MyMarker("Dunes Hall",Double.parseDouble("36.653669"),Double.parseDouble("-121.800662"),"10"));

//        if(mMyMarkersArray.size() > 0) {
//            for( MyMarker myMarker: mMyMarkersArray) {
//
//                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(),myMarker.getmLongitude(),""));
//                currentMarker = mMap.addMarker(markerOption);
//                mMarkersHashMap.put(currentMarker,myMarker);
//
//                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
//            }
//        }

    }

    public ArrayList<MyMarker> getMyMarkers(){
        return mMyMarkersArray;
    }

}
