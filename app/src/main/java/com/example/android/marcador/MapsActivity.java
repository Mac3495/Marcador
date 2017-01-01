package com.example.android.marcador;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

//Para que el fragment del mapa tengo ToolBar solo se debe cambiar la extencion a AppCompactActivity

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback , GoogleMap.OnMarkerClickListener{

    private GoogleMap mMap;
    Marker m1,m2,m3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        /*
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        */

        //Adiciona un marcador al mapa
        LatLng sydney = new LatLng(-34, 151);
        m1 = mMap.addMarker(new MarkerOptions().position(sydney).title("sidney")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        //Otro marcador
        LatLng laPaz = new LatLng(-16.5168649,-68.1133316);
        m2 = mMap.addMarker(new MarkerOptions().position(laPaz).title("La Paz")
                //Cambia el color del marcador
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng mexico = new LatLng(23.593928, -102.385300);
        m3 = mMap.addMarker(new MarkerOptions().position(mexico).title("Mexico")
                //Cambia el icono del marcador (La imagen debe ser muy pequeña menos de 64 bits)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icmar)));

        //Posicion de la camara
        mMap.moveCamera(CameraUpdateFactory.newLatLng(laPaz));

        //Habilita el onMarckerClickListenet
        googleMap.setOnMarkerClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.acerca:
                startActivity(new Intent(getApplicationContext(),SegundaActivity.class));
                break;
            case R.id.mensaje:
                Toast.makeText(getApplicationContext(),"Mensaje del menu",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn:
                Toast.makeText(getApplicationContext(),"Mensaje del menu",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Metodo para darle eventos a un marcador, se debe implementar OnMarckerClickListener
    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.getTitle().equals("sidney")){
            Toast.makeText(getApplicationContext(),marker.getTitle(),Toast.LENGTH_SHORT).show();
        }
        if(marker.getTitle().equals("La Paz")){
            startActivity(new Intent(getApplicationContext(),SegundaActivity.class));
            Toast.makeText(getApplicationContext(),marker.getTitle(),Toast.LENGTH_SHORT).show();
        }
        if(marker.getTitle().equals("Mexico")){
            Toast.makeText(getApplication(),marker.getPosition().toString(),Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
