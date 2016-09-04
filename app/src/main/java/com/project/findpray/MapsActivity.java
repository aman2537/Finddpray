package com.project.findpray;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.maps.MapFragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.app.Dialog;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;

import java.util.ArrayList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap mMap;
    private Button mReserve;
    private Double Latitude  = 0.00;
    private Double Longitude  = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Latitude = 13.1196647;
        Longitude = 100.9185479;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

/*mMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(MapsActivity.this, ReserveActivity.class);
        startActivity(intent);
    }
});*/

        mMap = ((SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();


        mMap.setOnMapClickListener(new OnMapClickListener() {
            public void onMapClick(LatLng arg0) {

                mMap.addMarker(new MarkerOptions().position(arg0)
                        .title(String.valueOf(arg0.latitude)
                                + ", " + String.valueOf(arg0.longitude)));

            }
        });

        mMap.setOnMarkerClickListener(new OnMarkerClickListener() {
            public boolean onMarkerClick(Marker arg0) {

                arg0.remove();
                Toast.makeText(getApplicationContext()
                        , "Remove Marker " + String.valueOf(arg0.getId())
                        , Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        mMap.addMarker(new MarkerOptions().position(
                new LatLng(Latitude,  Longitude))
                .title("Kasetsart University Sri Racha Campus")
                .snippet("มหาวิทยาลัย"));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(Latitude,  Longitude), 15));

        mReserve = (Button) findViewById(R.id.btreserve);
        mReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                LatLng Location = new LatLng(Latitude, Longitude);
                args.putParcelable("Location", Location);
                Intent intent = new Intent(getApplicationContext(), ReserveActivity.class);
                intent.putExtra("location",args);
                startActivity(intent);
            }
        });
        /*mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker arg0) {
                Intent intent = new Intent(getBaseContext(), ReserveActivity.class);

                String reference = mMarkerPlaceLink.get(arg0.getId());
                intent.putExtra("reference", reference);

                // Starting the  Activity
                startActivity(intent);
                Log.d("mGoogleMap1", "Activity_Calling");
            }
        });*/
    }

   /* public void onConfirmClicked2 (View v){

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("Latitude",Latitude.toString());
        i.putExtra("Longitude",Longitude.toString());
        startActivity(i);

    }*/

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Do something with Google Map
    }

    }

