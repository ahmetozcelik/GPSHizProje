package com.example.ahmet.gpsprojeodevi;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

    public class LocationActivity extends Activity implements LocationListener{

        private TextView enlem;
        private TextView boylam;
        private LocationManager locationManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_gps);

            enlem = (TextView) findViewById(R.id.TextView02);
            boylam = (TextView) findViewById(R.id.TextView04);

            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            Criteria criteria = new Criteria();
            String provider = locationManager.getBestProvider(criteria, false);
            Location location = locationManager.getLastKnownLocation(provider);
            if (location != null) {

                onLocationChanged(location);
            } else {
                enlem.setText("--");
                boylam.setText("--");

            }

        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
        @Override
        public void onLocationChanged(Location location) {
            // TODO Auto-generated method stub
            int lat = (int) (location.getLatitude());
            int lng = (int) (location.getLongitude());
            enlem.setText(String.valueOf(lat));
            boylam.setText(String.valueOf(lng));
        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }



    }
