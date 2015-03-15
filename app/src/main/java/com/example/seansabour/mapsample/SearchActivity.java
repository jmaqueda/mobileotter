package com.example.seansabour.mapsample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class SearchActivity extends ActionBarActivity implements View.OnClickListener{

    LocationMarkers lm;
    ArrayList<MyMarker> myMarkers;
    private EditText search_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search);

        View search_button = findViewById(R.id.search_button);
        search_button.setOnClickListener(this);
        search_input = (EditText)findViewById(R.id.cinput_building);
        lm = LocationMarkers.getInstance();
        myMarkers = lm.getMyMarkers();
//        search_input.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.i("TEXT", s.toString());
//                for(MyMarker m : myMarkers){
//                    if(m.getName().contains(s.toString())){
//                        search_input.setText(m.getName());
//                    }
//
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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
         if (v.getId() == R.id.search_button) {

             String input = search_input.getText().toString();
            //hide keyboard

            input = input.trim();
            startActivity(myMarkers, input);
        }
    }



        public void startActivity(ArrayList<MyMarker> markers, String searchString){
            MyMarker searchMarker = null;
            searchString = searchString.substring(0, 1).toUpperCase() + searchString.substring(1);
            try {
                for (MyMarker m : markers) {
                    if (m.getName().contains(searchString) || m.getId().contains(searchString)) {
                        searchMarker = m;
                    }
                }
            } catch(Exception e) {  }

            if(searchMarker != null) {
                double latitude = searchMarker.getmLatitude();
                double longitude = searchMarker.getmLongitude();
                String title = searchMarker.getName();

                Intent i = new Intent(this, OtterExpressActivity.class);
                i.putExtra("LONGITUDE", longitude);
                i.putExtra("LATITUDE", latitude);
                i.putExtra("TITLE", title);
                startActivity(i);
            } else
                Toast.makeText(getApplicationContext(), "No building was found. Try again", Toast.LENGTH_LONG).show();
        }

}
