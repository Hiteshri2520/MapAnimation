package com.mapanimation.app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.mapanimation.*;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mapanimation.animationnutil.DemoClass;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    DemoClass demoClass;
    SupportMapFragment mapFragment;
    LocationManager locationManager;
   public Location loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        demoClass = new DemoClass(MainActivity.this, mMap, mapFragment);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        //


        LatLng latlong = new LatLng(21.7799324, 72.1741894);
      /*  mMap.addMarker(new
                MarkerOptions().position(TutorialsPoint).title("Tutorialspoint.com"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TutorialsPoint));*/
        demoClass = new DemoClass(MainActivity.this, mMap, mapFragment);
        demoClass.hope(latlong);

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        CameraUpdate location11 = CameraUpdateFactory.newLatLngZoom(
                new LatLng(loc.getLatitude(), loc.getLongitude()), 15);
        mMap.animateCamera(location11);

    }
}
