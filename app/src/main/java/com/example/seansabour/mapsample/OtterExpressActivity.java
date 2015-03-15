package com.example.seansabour.mapsample;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class OtterExpressActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private double latitude;
    private double longitude;
    private String titleString;
    private TextView title;
    private TextView description;
    private String descriptionString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otter_express);

        Bundle b = getIntent().getExtras();
        latitude = b.getDouble("LATITUDE");
        longitude = b.getDouble("LONGITUDE");
        titleString = b.getString("TITLE");
        descriptionString = "Store Hours: Monday - Friday: 11:00 a.m. - Midnight  \n" +
                "Weekends: 2:00 p.m. - Midnight";
        Log.i("LATITUDE", ""+latitude);
        Log.i("LONGITUDE", ""+longitude);
//        title = (TextView) findViewById(R.id.marker_label);
//        title.setText(titleString);
//        description = (TextView) findViewById(R.id.hours);
//        description.setText();
        setUpMapIfNeeded();
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
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude,longitude))
                .title("OtterExpress"));
        mMap.setInfoWindowAdapter(new OEInfoWindowAdapter());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,longitude), 19));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMyLocationEnabled(true);
    }


    private class OEInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
        OEInfoWindowAdapter(){
        }
        @Override
        public View getInfoWindow(Marker marker) {
            View v  = getLayoutInflater().inflate(R.layout.oe_window_adapter, null);
            TextView anotherLabel = (TextView)v.findViewById(R.id.marker_label);
            anotherLabel.setText(titleString);
            return v;
        }

        @Override
        public View getInfoContents(Marker marker) {
            return null;
        }
    }
}
