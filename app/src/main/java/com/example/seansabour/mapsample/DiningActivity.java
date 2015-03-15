package com.example.seansabour.mapsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class DiningActivity extends ActionBarActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dining);

        View OE_button = findViewById(R.id.OE_button);
        OE_button.setOnClickListener(this);
        View DC_button = findViewById(R.id.DC_button);
        DC_button.setOnClickListener(this);
        View Montes_button = findViewById(R.id.Montes_button);
        Montes_button.setOnClickListener(this);
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
            Intent i = new Intent(this, OtterExpressActivity.class);
            startActivity(i);
        } /*else if (v.getId() == R.id.DC_button) {
            Intent i = new Intent(this, DiningCommonsActivity.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.Montes_button)
        {
            Intent i = new Intent(this, MontesActivity.class);
            startActivity(i);

        }*/
    }
}
