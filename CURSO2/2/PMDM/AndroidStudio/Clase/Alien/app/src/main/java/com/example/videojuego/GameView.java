package com.example.videojuego;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.example.videojuego.sprites.Bola;
import com.example.videojuego.sprites.Pala;
import com.example.videojuego.sprites.Sprite;

import java.util.LinkedList;

public abstract class GameView extends SurfaceView implements Runnable {

     /*
        VARIABLES DEL DISPOSITIVO Y HARDWARE
     */

    //hilo para realizar el bucle del juego
    Thread hilo = null;
    //superfice general para dibujar en ella
    SurfaceHolder mSurfaceHolder;
    //variable que se debe conocer dentro y fuera del hilo (volatile)
    protected volatile boolean enEjecucion;
    //Variable para saber si el juego está pausado
    public boolean pausado = true;

    /*
        PANTALLA Y SOFTWARE
     */

    //Canvas y pintura del dibujo
    Canvas canvas;
    Paint paint;
    //Tamaño de la pantalla en píxeles
    int mScreenX, mScreenY;

    //Guardar los FPS del videojuego
    long FPS;
    private long ultimoProceso=0;
    private static int PERIODO_PROCESO=30;
    public float factor_mov;
    long ahora, tiempo_transcurrido;

    LinkedList<Sprite> actores=new LinkedList<>();

    public GameView(Context context, int x, int y) {
        super(context);
        //inicializar tamaño de pantalla
        mScreenX = x;
        mScreenY = y;
        //inicializar objetos de dibujo
        mSurfaceHolder = this.getHolder();
        paint = new Paint();
    }



    @Override
    public void run() {
        while (enEjecucion) {
            if (!pausado) {
                update();
            }
       }
     }

    public void update(){
        ahora=System.currentTimeMillis();       //100000
        if(ultimoProceso+PERIODO_PROCESO>ahora){   //0+200>100000?? No
            return;
        }
        tiempo_transcurrido=ahora-ultimoProceso;  //tiempo_transcurrido=1000000-0
        factor_mov=(tiempo_transcurrido)/PERIODO_PROCESO; //factor_mov=100000 el primero no es realista
        ultimoProceso=ahora;

        actualiza();
        limpia();
        draw();

    }

    //reanuda la partida
    public void resume() {
        enEjecucion = true;
        hilo = new Thread(this);
        hilo.start();
    }

    //pausa la partida
    public void pause() {
        enEjecucion = false;
        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public abstract void actualiza();
    synchronized public void limpia(){
        for (int i=0;i<actores.size();i++)
            if(!actores.get(i).isVisible()) {
                actores.remove(i);
            }
    }
    public void draw(){
        //comprobar si la superficie a pintar es válida
        if (mSurfaceHolder.getSurface().isValid()) {
            //Se empieza a pintar. Hay que bloquear el canvas a pintar
            canvas = mSurfaceHolder.lockCanvas();
            dibuja(canvas);

            paint.setTextSize(50);
            canvas.drawText("ahora: " + this.ahora, 50, 150, paint);
            canvas.drawText("ultimo proceso: " + this.ultimoProceso, 50, 250, paint);
            canvas.drawText("tiempo transcurrido: " + this.tiempo_transcurrido, 50, 350, paint);
            canvas.drawText("factor movimiento: " + this.factor_mov, 50, 450, paint);
            // Se desbloquea el canvas añadiendo lo que se ha pintado
            mSurfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
    public abstract void dibuja(Canvas canvas);
}