package com.example.seansabour.mapsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by maritzaabzun on 3/14/15.
 */public class MenuActivity extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);

        View map_button = findViewById(R.id.map_button);
        map_button.setOnClickListener(this);
        View dining_button = findViewById(R.id.dining_button);
        dining_button.setOnClickListener(this);
        View parking_button = findViewById(R.id.parking_button);
        parking_button.setOnClickListener(this);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.map_button) {
            Intent i = new Intent(this, MapsActivity.class);
            startActivity(i);

        }
        else if(v.getId() == R.id.dining_button)
        {
            Intent i = new Intent(this, DiningActivity.class);
            startActivity(i);

        }
    }
}
