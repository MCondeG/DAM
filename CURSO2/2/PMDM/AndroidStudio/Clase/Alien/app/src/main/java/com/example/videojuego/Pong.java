package com.example.videojuego;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.view.MotionEvent;

import com.example.videojuego.sprites.Bola;
import com.example.videojuego.sprites.Pala;
import com.example.videojuego.sprites.Sprite;

import java.util.ArrayList;
import java.util.LinkedList;

public class Pong extends GameView {

    /*
       VARIABLES DEL JUEGO
    */
    //Actores del juego
    Bola bola;
    Pala pala;

    public LinkedList<Sprite> getActores() {
        return actores;
    }
    public LinkedList<Sprite> nuevos=new LinkedList<>();

    //Efectos de sonido

    //variables del juego
    public int puntuacion = 0;
    public int vidas = 3;


    public Pong (Context context, int x, int y) {

        super(context,x,y);

        //actores del juego
        pala = new Pala(mScreenX, mScreenY);
        bola = new Bola(mScreenX, mScreenY);
        actores.add(pala);
        actores.add(bola);

        //hacemos que la bola pueda interaccionar con la pala
        //bola.addListenerColision(pala);
        //carga de sonidos

        //Inicializa los valores del juego.
        setupGame();


    }

    public void setupGame() {
        bola.reset();
        pala.reset();
        if (vidas == 0) {
            puntuacion = 0;
            vidas = 3;

        }

    }

    //Realiza la lógica del juego, movimientos, física, colisiones, interacciones..etc
    @Override
    public void actualiza() {
        //recalculamos los valores de posición actualizada de los actores
        for (Sprite actor : actores) {
            if(actor.isVisible())
               actor.update(this, FPS);
        }

        actores.addAll(nuevos);
        nuevos=new LinkedList<>();
    }


    //dibuja la pantalla
    @Override
    public void dibuja(Canvas canvas) {

        //se pinta desde la capa más lejana hasta la más cercana
        canvas.drawColor(Color.argb(255, 20, 128, 188));
       //pintamos los actores del juego
        synchronized(actores) {
            for (Sprite actor : actores) {

                    actor.pinta(canvas);


            }
        }
        //dibujamos puntuacion y vidas
        paint.setTextSize(30);
        canvas.drawText("Factor_mov: " + this.factor_mov + "  Vidas: " + actores.size(), 10, 50, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:

                pausado = false;
                if (event.getX() < mScreenX / 2) {
                    pala.setEstadoPala(pala.LEFT);
                   bola = new Bola(mScreenX, mScreenY);
                   synchronized(actores){
                       //actores.addFirst(bola);
                       nuevos.add(bola);
                    }

                   puntuacion++;




                } else {
                    pala.setEstadoPala(pala.RIGHT);
                }
                break;
            case MotionEvent.ACTION_UP:
                pala.setEstadoPala(pala.STOP);
                break;

        }
        return true;
    }


}
