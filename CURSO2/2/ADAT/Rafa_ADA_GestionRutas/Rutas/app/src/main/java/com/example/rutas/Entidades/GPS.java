package com.example.rutas.Entidades;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.rutas.R;
import com.example.rutas.Room.EntidadesRoom.PosicionRoom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GPS extends AppCompatActivity implements LocationListener{

    private TextView txtLat, txtLong, txtSrc, txtDir;
    private LocationManager locationManager;
    private String provider;
    private Button baddposicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gps_activity);
        setContentView(R.layout.gps_activity);
        this.setTitle("GPS");



        //Vinculamos cada objeto a la parte de la UI respectiva...
        txtLat = (TextView) findViewById(R.id.txt_lat);
        txtLong = (TextView) findViewById(R.id.txt_long);
        txtSrc = (TextView) findViewById(R.id.txt_src);
        txtDir = (TextView) findViewById(R.id.txt_dir);
        baddposicion =(Button)findViewById(R.id.bGuardaPosGPS);

//GUARDAR POSICION
        baddposicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String latitud = txtLat.getText().toString();
                Float latitudF = Float.valueOf(latitud);

                String longitud = txtLong.getText().toString();
                Float longitudF = Float.valueOf(longitud);

                String descripcion = txtDir.getText().toString();

                PosicionRoom posgps = new PosicionRoom(latitudF,longitudF,descripcion);

                System.out.println("Posicion guardada :"+posgps);

                ArrayList<PosicionRoom> posiciones = new ArrayList<>();
                posiciones.add(posgps);

                System.out.println("lista de posiciones: "+posiciones);

            }
        });


        //Inicializar el manager que nos va a dar la geoposición en base al GPS
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //Se usa la clase Criteria para obtener el mejor proveedor de localización
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        //false se establece para que no esté activo permanentemente
        provider = locationManager.getBestProvider(criteria, false);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1000
            );
        }



        Location location = locationManager.getLastKnownLocation(provider);

        if (location != null) {
            txtSrc.setText("Source = " + provider);
            onLocationChanged(location);
        }
    }//ONCREATE


    //
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }



    @Override
    protected void onResume() {
        super.onResume();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1000
            );
        }


        locationManager.requestLocationUpdates(provider, 500 /*milisegundos de update*/, 1 /*metros de recorrido del usuario*/, this);
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.getDefault());

        List<Address> direccion=null;
        try {
            direccion = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        double alt = location.getAltitude();

        txtLat.setText(String.valueOf(lat));
        txtLong.setText(String.valueOf(lng));
        txtSrc.setText("Source = "+provider);
        txtDir.setText(direccion.get(0).getAddressLine(0));

    } //ONLOCATIONCHANGE

    @Override
    public void onStatusChanged(String provider, int status, Bundle bundle) {
        txtSrc.setText("Source = "+provider);
    }

    @Override
    public void onProviderEnabled(String provider) {
        txtSrc.setText("Source = "+provider);
    }

    @Override
    public void onProviderDisabled(String provider) {
        txtSrc.setText("Source = "+provider);
    }
}


