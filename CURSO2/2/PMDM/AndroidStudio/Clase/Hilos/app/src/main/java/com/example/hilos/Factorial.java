package com.example.hilos;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

public class Factorial implements Runnable {



    int n;
    int res;
    public Factorial(int n){
        this.n=n;



    }


    @Override
    public void run(){
        res=calculaFactorial(n);
        Log.d("hilo runnable","hola "+res);


    }


    private int calculaFactorial(int n){
        int res=1;
        for (int i=1;i<=n;i++){
            res*=i;
            SystemClock.sleep(1000);
        }
        return res;
    }

    public int getRes() {
        return res;
    }
}
