package com.example.seansabour.mapsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;


public class DiningActivity extends ActionBarActivity implements View.OnClickListener{
    LocationMarkers lm;
    ArrayList<MyMarker> myMarkers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);

        View OE_button = findViewById(R.id.OE_button);
        OE_button.setOnClickListener(this);
        View DC_button = findViewById(R.id.DC_button);
        DC_button.setOnClickListener(this);
        View Montes_button = findViewById(R.id.Montes_button);
        Montes_button.setOnClickListener(this);
        lm = LocationMarkers.getInstance();
        myMarkers = lm.getMyMarkers();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dining, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
   public void onClick(View v) {

        if (v.getId() == R.id.OE_button) {
            startActivity(myMarkers, "Otter Express");
        } else if (v.getId() == R.id.DC_button) {
            startActivity(myMarkers, "CSUMB Dinning Commons");
        }
        else if(v.getId() == R.id.Montes_button)
        {
            startActivity(myMarkers, "University Center(Montes)");

        }
    }
    public void startActivity(ArrayList<MyMarker> markers, String searchString){
        MyMarker searchMarker = null;
        for (MyMarker m: markers){
            if (m.getName().equalsIgnoreCase(searchString)){
                searchMarker = m;
            }

        }
        double latitude = searchMarker.getmLatitude();
        double longitude = searchMarker.getmLongitude();
        String title = searchMarker.getName();



        Intent i = new Intent(this, OtterExpressActivity.class);
        i.putExtra("LONGITUDE", longitude);
        i.putExtra("LATITUDE", latitude);
        i.putExtra("TITLE", title);
        startActivity(i);
    }
}
