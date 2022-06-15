package com.example.rutas.Retrofit;

import com.example.rutas.Retrofit.EntidadesRetrofit.PosicionRetroFit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GestionRutasAPI {

    @GET("posiciones")
    Call<List<PosicionRetroFit>> getPosiciones();
}
