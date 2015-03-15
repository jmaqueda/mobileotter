package com.example.seansabour.mapsample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;


public class MapsActivity extends FragmentActivity {
   private HashMap<Marker,MyMarker> mMarkersHashMap = mMarkersHashMap = new HashMap<Marker,MyMarker>();
    private ArrayList<MyMarker> mMyMarkersArray= new ArrayList<MyMarker>();
   private GoogleMap mMap; // Might be null if Google Play services APK is not available.
   private Marker currentMarker;
   private static double latitude;
   private static double longitude;
   private static GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Update current location of device
        gps = new GPSTracker(this);
        gps.updateGPSCoordinates();
        latitude = gps.getLatitude();
        longitude = gps.getLongitude();

        // Create Markers
        createMarkers();

        //
        setUpMapIfNeeded();
        plotMarkers(mMyMarkersArray);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker) {
                marker.showInfoWindow();
                return true;
                }
            });

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(36.6540659,-121.7999387), 17));
        mMap.setMyLocationEnabled(true);
        mMap.setBuildingsEnabled(true);
    }

    private void plotMarkers(ArrayList<MyMarker> markers){
        if(markers.size() > 0) {
            for( MyMarker myMarker: markers) {

                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(),myMarker.getmLongitude()));
                currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker,myMarker);

                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
            }
        }
    }

    private void createMarkers() {
        mMyMarkersArray.add(new MyMarker("Aquatic Center",Double.parseDouble("36.651461"),Double.parseDouble("-121.807472")));
        mMyMarkersArray.add(new MyMarker("Otter Sports Complex",Double.parseDouble("36.654419"),Double.parseDouble("-121.808296")));
        mMyMarkersArray.add(new MyMarker("Ocean Hall",Double.parseDouble("36.655620"),Double.parseDouble("-121.807188")));
        mMyMarkersArray.add(new MyMarker("Mountain Hall",Double.parseDouble("36.655415"),Double.parseDouble("-121.806263")));
        mMyMarkersArray.add(new MyMarker("Valley Hall",Double.parseDouble("36.655388"),Double.parseDouble("-121.804368")));
        mMyMarkersArray.add(new MyMarker("Black Box Cabaret",Double.parseDouble("36.655748"),Double.parseDouble("-121.803672")));
        mMyMarkersArray.add(new MyMarker("Health & Wellness Services",Double.parseDouble("36.655575"),Double.parseDouble("-121.803177")));
        mMyMarkersArray.add(new MyMarker("Alunmi & Visitors Center",Double.parseDouble("36.654446"),Double.parseDouble("-121.801787")));
        mMyMarkersArray.add(new MyMarker("Meeting House",Double.parseDouble("36.6532752"),Double.parseDouble("-121.8015193")));
        mMyMarkersArray.add(new MyMarker("Tide Hall",Double.parseDouble("36.652632"),Double.parseDouble("-121.800238")));
        mMyMarkersArray.add(new MyMarker("Beach Hall",Double.parseDouble("36.652631"),Double.parseDouble("-121.799177")));
        mMyMarkersArray.add(new MyMarker("Media Learning Center",Double.parseDouble("36.654248"),Double.parseDouble("-121.799848")));
        mMyMarkersArray.add(new MyMarker("CSUMB Dining Commons",Double.parseDouble("36.6541828"),Double.parseDouble("-121.7988633")));
        mMyMarkersArray.add(new MyMarker("Otter Express",Double.parseDouble("36.654212"),Double.parseDouble("-121.798234")));
        mMyMarkersArray.add(new MyMarker("Student Center",Double.parseDouble("36.654151"),Double.parseDouble("-121.797485")));
        mMyMarkersArray.add(new MyMarker("College of Professional Studies",Double.parseDouble("36.6530531"),Double.parseDouble("-121.7981156")));
        mMyMarkersArray.add(new MyMarker("Institutional Assessment and Research",Double.parseDouble("36.653569"),Double.parseDouble("-121.7973364")));
        mMyMarkersArray.add(new MyMarker("Starbucks",Double.parseDouble("36.6542463"),Double.parseDouble("-121.7974028")));
        mMyMarkersArray.add(new MyMarker("Journalism and Media Studies",Double.parseDouble("36.653584"),Double.parseDouble("-121.796068")));
        mMyMarkersArray.add(new MyMarker("Visual and Public Art (VPA) West",Double.parseDouble("36.6553447"),Double.parseDouble("-121.7959571")));
        mMyMarkersArray.add(new MyMarker("Visual and Public Art",Double.parseDouble("36.6553109"),Double.parseDouble("-121.7956232")));
        mMyMarkersArray.add(new MyMarker("Visual and Public Art (VPA) East",Double.parseDouble("36.6553404"),Double.parseDouble("-121.7952671")));
        mMyMarkersArray.add(new MyMarker("CSUMB Library",Double.parseDouble("36.6523091"),Double.parseDouble("-121.7961904")));
        mMyMarkersArray.add(new MyMarker("Chapman Science Academic Center",Double.parseDouble("36.653323"),Double.parseDouble("-121.794764")));
        mMyMarkersArray.add(new MyMarker("University Corporation",Double.parseDouble("36.654399"),Double.parseDouble("-121.792962")));
        mMyMarkersArray.add(new MyMarker("Science Instructional Lab Annex",Double.parseDouble("36.6530445"),Double.parseDouble("-121.7927753")));
        mMyMarkersArray.add(new MyMarker("Oaks Hall",Double.parseDouble("36.654970"),Double.parseDouble("-121.792147")));
        mMyMarkersArray.add(new MyMarker("Science Research Lab Annex",Double.parseDouble("36.6526254"),Double.parseDouble("-121.793932")));
        mMyMarkersArray.add(new MyMarker("World Languages and Cultures - North Building",Double.parseDouble("36.6525662"),Double.parseDouble("-121.792597")));
        mMyMarkersArray.add(new MyMarker("Reading Center",Double.parseDouble("36.652550"),Double.parseDouble("-121.790589")));
        mMyMarkersArray.add(new MyMarker("Green Hall",Double.parseDouble("36.652071"),Double.parseDouble("-121.790506")));
        mMyMarkersArray.add(new MyMarker("World Languages and Cultures - South",Double.parseDouble("36.6520842"),Double.parseDouble("-121.7926861")));
        mMyMarkersArray.add(new MyMarker("Cinematic Arts and Technology Building",Double.parseDouble("36.65184"),Double.parseDouble("-121.793867")));
        mMyMarkersArray.add(new MyMarker("Student Services Building",Double.parseDouble("36.6516253"),Double.parseDouble("-121.792953")));
        mMyMarkersArray.add(new MyMarker("College of Arts, Humanities, and Social Sciences Building",Double.parseDouble("36.6511438"),Double.parseDouble("-121.7930422")));
        mMyMarkersArray.add(new MyMarker("World Theater",Double.parseDouble("36.6508797"),Double.parseDouble("-121.793932")));
        mMyMarkersArray.add(new MyMarker("Coast Hall",Double.parseDouble("36.6506876"),Double.parseDouble("-121.7931093")));
        mMyMarkersArray.add(new MyMarker("Pacific Hall",Double.parseDouble("36.6502615"),Double.parseDouble("-121.7927532")));
        mMyMarkersArray.add(new MyMarker("University Center(Montes)",Double.parseDouble("36.6499899"),Double.parseDouble("-121.7942438")));
        mMyMarkersArray.add(new MyMarker("CSUMB Book Store",Double.parseDouble("36.6498828"),Double.parseDouble("-121.7939401")));
        mMyMarkersArray.add(new MyMarker("Watershed Institute",Double.parseDouble("36.649820"),Double.parseDouble("-121.792586")));
        mMyMarkersArray.add(new MyMarker("Camp SEA Lab",Double.parseDouble("36.6496057"),Double.parseDouble("-121.792772")));
        mMyMarkersArray.add(new MyMarker("IT Services",Double.parseDouble("36.6492959"),Double.parseDouble("-121.7931314")));
        mMyMarkersArray.add(new MyMarker("Music Hall",Double.parseDouble("36.6479127"),Double.parseDouble("-121.7944665")));
        mMyMarkersArray.add(new MyMarker("Sand Hall",Double.parseDouble("36.653509"),Double.parseDouble("-121.799320")));
        mMyMarkersArray.add(new MyMarker("Facilities Services and Operations",Double.parseDouble("36.648980"),Double.parseDouble("-121.787847")));
        mMyMarkersArray.add(new MyMarker("Dunes Hall",Double.parseDouble("36.653669"),Double.parseDouble("-121.800662")));
    }

    private class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
        public MarkerInfoWindowAdapter() {        }

        @Override
        public View getInfoWindow(Marker marker) {
            View v  = getLayoutInflater().inflate(R.layout.infowindow_layout, null);
            Button button = (Button) v.findViewById(R.id.button_send);
            final Marker m = marker;

            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    handleMarkerClick(m);
                }
            });


            MyMarker myMarker = mMarkersHashMap.get(marker);

            TextView markerLabel = (TextView)v.findViewById(R.id.marker_label);
            String buildName = myMarker.getName();
            TextView anotherLabel = (TextView)v.findViewById(R.id.another_label);
            anotherLabel.setText(buildName);
            return v;

        }

        @Override
        public View getInfoContents(Marker marker)
        {
            return null;
        }
    }

    public void handleMarkerClick(Marker marker) {

        //get location from marker that was clicked...
        LatLng latlng = marker.getPosition();
        String goToLatitude = latlng.latitude+"";
        String goToLongitude = latlng.longitude+"";

        //get devices current location...
        String comeFromLatitude = ""+latitude;
        String comeFromLongitude = ""+longitude;

        View v  = getLayoutInflater().inflate(R.layout.infowindow_layout, null);
        try{

            Uri uri = Uri.parse("http://maps.google.com/maps?saddr=" + comeFromLatitude + "," + comeFromLongitude + "&daddr=" + goToLatitude  + "," + goToLongitude);
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }catch(Exception e){

            //log exception...

        }

    }

}
