package com.example.rutas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.rutas.Entidades.GPS;
import com.example.rutas.Entidades.Posicion;
import com.example.rutas.Entidades.Ruta;
import com.example.rutas.Entidades.Tramo;
import com.example.rutas.RecyclerView.Recycler;
import com.example.rutas.Retrofit.EntidadesRetrofit.PosicionRetroFit;
import com.example.rutas.Retrofit.GestionRutasAPI;
import com.example.rutas.Retrofit.RetrofitCliente;
import com.example.rutas.Room.AppDB;
import com.example.rutas.Room.EntidadesRoom.PosicionRoom;
import com.example.rutas.Room.EntidadesRoom.RutaRoom;
import com.example.rutas.Room.EntidadesRoom.TramoRoom;
import com.example.rutas.SQL.DAOSQLite.Dao;
import com.example.rutas.SQL.DAOSQLite.DaoPosicionSQLite;
import com.example.rutas.SQL.DAOSQLite.DaoRutaSQLite;
import com.example.rutas.SQL.DAOSQLite.DaoTramoSQLite;
import com.example.rutas.SQL.EntidadesSQL.PosicionSQLite;
import com.example.rutas.SQL.EntidadesSQL.RutaSQLite;
import com.example.rutas.SQL.EntidadesSQL.TramoSQLite;
import com.example.rutas.SQL.GestionPosicion;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ListView lVPos;
    ArrayList<String> list;
    Button bgps;
    EditText nodo1,nodo2;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    GestionRutasAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("App de Rutas");


        //NAVIGATION VIEW Y DRAWERLAYOUT
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawerlayout);

        navigationView.setNavigationItemSelectedListener(this);




        //TOOLBAR
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //CUADRO DE DIALOGO
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bienvenido a la aplicación.")
                .setTitle("Bienvenida")
                .setPositiveButton("OK",(dialog,id)->{dialog.cancel();});
        AlertDialog dialogo= builder.create();
        dialogo.show();


        lVPos=(ListView) findViewById(R.id.LVpos);





  /*  //ROOM

        //CREAR POSICION
       PosicionRoom posicionRoom = new PosicionRoom(5.0f,25f,"HHHH");
        PosicionRoom posicionRoom2 = new PosicionRoom(5.0f,25f,"xxxx");
        AppDB.getAppDB(getApplicationContext()).daoPosicion().crearPosicion(posicionRoom);
        AppDB.getAppDB(getApplicationContext()).daoPosicion().crearPosicion(posicionRoom2);

        //VER TODAS LAS POSICIONES
        List<PosicionRoom> posicionesRoom=
                AppDB.getAppDB(getApplicationContext()).daoPosicion().verPosiciones();

        for (PosicionRoom posRoom:posicionesRoom) {
            Log.d("RUTASapp: ",posRoom.toString());
        }

        //VER POSICION POR ID
    PosicionRoom posicionIDRoom =
            AppDB.getAppDB(getApplicationContext()).daoPosicion().verPosicion(4);

        Log.d("RUTASapp: POS ID ",posicionIDRoom.toString());

        //CREAR TRAMO
        TramoRoom tramoRoom = new TramoRoom(1,posicionRoom.getLatitud(),posicionRoom.getLongitud(),"Tramo1");
        TramoRoom tramoRoom2 = new TramoRoom(2,posicionRoom2.getLatitud(),posicionRoom2.getLongitud(),"Tramo2");
        AppDB.getAppDB(getApplicationContext()).daoTramo().crearTramo(tramoRoom);
        AppDB.getAppDB(getApplicationContext()).daoTramo().crearTramo(tramoRoom2);

        //VER TODOS LOS TRAMOS
        List<TramoRoom> tramosRoom =
                AppDB.getAppDB(getApplicationContext()).daoTramo().verTramos();

        for (TramoRoom tramRoom:tramosRoom){
            Log.d("RUTASapp: ",tramRoom.toString());
        }

        //VER TRAMO POR ID
        TramoRoom tramoIDRoom =
                AppDB.getAppDB(getApplicationContext()).daoTramo().verTramo(11);
        Log.d("RUTASapp: TRAMO ID ",tramoIDRoom.toString());

        //CREAR RUTA
        RutaRoom rutaRoom = new RutaRoom(1,tramoRoom.getNodo_inicial(),tramoRoom.getNodo_final(),"Ruta 1");
        RutaRoom rutaRoom2 = new RutaRoom(2,tramoRoom2.getNodo_inicial(),tramoRoom2.getNodo_final(),"Ruta 2");
        AppDB.getAppDB(getApplicationContext()).daoRuta().crearRuta(rutaRoom);
        AppDB.getAppDB(getApplicationContext()).daoRuta().crearRuta(rutaRoom2);

        //VER TODAS LAS RUTAS
        List<RutaRoom> rutasRoom =
                AppDB.getAppDB(getApplicationContext()).daoRuta().verRutas();

        for (RutaRoom rutRoom : rutasRoom){
            Log.d("RUTASapp: ",rutRoom.toString());
        }

        //VER TRAMO POR ID
        RutaRoom rutaIDRoom =
                AppDB.getAppDB(getApplicationContext()).daoRuta().verRuta(9);
        Log.d("RUTASapp: RUTA ID ",rutaIDRoom.toString());
*/

/*
      //SQLITE
        Dao.setGestorBD(new GestionPosicion(this));

        //fuerzo a crear de nuevo las tablas
    ((GestionPosicion)Dao.gestorBd).borrarTablas();
        Dao.gestorBd.onCreate(Dao.gestorBd.getWritableDatabase());

        //CREAR POSICION
        DaoPosicionSQLite daoposicion=new DaoPosicionSQLite();

        daoposicion.crearPosicionSQlite(new PosicionSQLite(15f,25f,"Sevilla"));
        daoposicion.crearPosicionSQlite(new PosicionSQLite(145f,125f,"Huelva"));

        //VER POSICION POR ID Y VER TODAS LAS POSICIONES
        PosicionSQLite pos= daoposicion.verPosicionSQlite(1);
        PosicionSQLite pos2= daoposicion.verPosicionSQlite(2);
        ArrayList<PosicionSQLite> posiciones= daoposicion.verPosicionesSQlite();

        Log.d("Ver Posicion ID:1: ",pos.getDescripcion());
        Log.d("Ver Posiciones: ",posiciones.toString());


        //CREAR TRAMO
        DaoTramoSQLite daotramo=new DaoTramoSQLite();

        daotramo.crearTramoSQlite(new TramoSQLite(55f,45f,"Tramo Sevilla-Huelva",1));
        daotramo.crearTramoSQlite(new TramoSQLite(27f,105f,"Tramo HEULVA-SEVILLA",2));

        //VER TRAMO POR ID Y VER TODOS LOS TRAMOS
        TramoSQLite tramoSQLite= daotramo.verTramoSQlite(1);
        ArrayList<TramoSQLite> tramoSQLites= daotramo.verTramosSQlite();

        Log.d("Ver TRAMO ID:1: ",tramoSQLite.getDescripcion());
        Log.d("Ver TRAMOS: ",tramoSQLites.toString());



        //CREAR RUTA
        DaoRutaSQLite daoruta=new DaoRutaSQLite();

        daoruta.crearRutaSQlite(new RutaSQLite(15f,45f,"Ruta1",1));
        daoruta.crearRutaSQlite(new RutaSQLite(185f,455f,"Ruta2",1));
        daoruta.crearRutaSQlite(new RutaSQLite(45f,45f,"a",1));


        //VER RUTA POR ID Y VER TODAS LAS RUTAS
        RutaSQLite rutaSQLite= daoruta.verRutaSQlite(2);
        ArrayList<RutaSQLite> rutas= daoruta.verRutasSQlite();

        Log.d("Ver RUTA ID:2: ",rutaSQLite.getDescripcion());
        Log.d("Ver RUTAS: ",rutas.toString());

*/

        //GPS
        bgps = (Button) findViewById(R.id.buttonGPS);

        bgps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GPS.class);
                startActivity(intent);
            }
        });


        //RETROFIT
        Log.d("/retrofit","probando retrofit");

        Retrofit retrofit= RetrofitCliente.getClient("http://127.0.0.1:8080/posiciones/");
        api = retrofit.create(GestionRutasAPI.class);

        Call<List<PosicionRetroFit>> call=api.getPosiciones();

        call.enqueue(new Callback<List<PosicionRetroFit>>() {
            @Override
            public void onResponse(Call<List<PosicionRetroFit>> call, Response<List<PosicionRetroFit>> response) {
                List<PosicionRetroFit> posicionesRF=response.body();
                for(PosicionRetroFit posicionRF:posicionesRF){
                    Log.d("/retrofit","posicion");
                    Log.d("/retrofit",posicionRF.getDescripcion());
                }
            }

            @Override
            public void onFailure(Call<List<PosicionRetroFit>> call, Throwable t) {
                Log.d("/retrofit","error: "+t.toString());
            }
        });







    }//ON CREATE

    private void lanzarTramoConRetorno() {
        Intent intent = new Intent(this, Tramo.class);
        startActivityForResult(intent, 1234);
    }

    private void lanzarPosicionConRetorno() {
        Intent intent = new Intent(this, Posicion.class);
        startActivityForResult(intent, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == 7) {



            ArrayList<String> list = data.getStringArrayListExtra("key");
            ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
            lVPos.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();


        }
    }//onActivityResult



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.tramo:
                lanzarTramoConRetorno();
                break;
            case R.id.posicion:
                lanzarPosicionConRetorno();
                break;

            case R.id.inicio:
                Intent intent3 = new Intent(this,MainActivity.class);
                startActivity(intent3);
                break;

            case R.id.ruta:
                Intent intent4 = new Intent(this, Ruta.class);
                startActivity(intent4);
                break;

            case R.id.recycler:
                Intent intent5 = new Intent(this, Recycler.class);
                startActivity(intent5);
                break;
        }
        return true;
    }//onOptionsItemSelected




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);

        return true;
    }

    private void selectItemNav(MenuItem item) {


        switch (item.getItemId()){
            case R.id.posicion:
                Intent intent = new Intent(MainActivity.this,Posicion.class);
                startActivity(intent);
                break;
            case R.id.tramo:
                Intent intent2 = new Intent(MainActivity.this,Tramo.class);
                startActivity(intent2);
                break;
            case R.id.ruta:
                Intent intent3 = new Intent(MainActivity.this,Ruta.class);
                startActivity(intent3);
                break;
        }
    }


}//MAIN