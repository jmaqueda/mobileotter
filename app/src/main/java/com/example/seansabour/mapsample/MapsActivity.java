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
   private ArrayList<MyMarker> mMyMarkersArray;
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
        //createMarkers();
        LocationMarkers lm = LocationMarkers.getInstance();
        mMyMarkersArray = lm.getMyMarkers();

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
