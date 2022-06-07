package com.example.videojuego.sprites;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.example.videojuego.GameView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Sprite {

     //tamaño de la pantalla
     int mScreenX, mScreenY;

     //Velocidades de eje X y eje Y de partida
     float velInicialX;
     float velInicialY;
     //velocidades actuales
     float velActualX;
     float velActualY;
     //la imagen se pinta o no se pinta y permanece oculta
     boolean visible;
     int color;

     Paint paint;

     //Para controlar las colisiones
     protected List<Sprite> actores=new LinkedList<>();

     public boolean isVisible() {
          return visible;
     }

     //Se le pasa el tamaño de la pantalla
     public Sprite(int screenX, int screenY){
          //anchura y altura de la pantalla
          mScreenX=screenX;
          mScreenY=screenY;
          color=Color.argb(255, 255, 255, 255);
          visible=true;
          paint=new Paint();
     }
     // se le pasa tamaño de la pantalla y tamaño de la imagen
     public Sprite (int screenX, int screenY, int x, int y){
          mScreenX=screenX;
          mScreenY=screenY;
          color=Color.argb(255, 255, 255, 255);
          paint=new Paint();
     }


     public void addListenerColision(Sprite s){actores.add(s);}

     public abstract boolean colision(Sprite s);
     public abstract boolean colisionBordeLeft();
     public abstract boolean colisionBordeRight();
     public abstract boolean colisionBordeTop();
     public abstract boolean colisionBordeBottom();
     public abstract void recolocaX(float x);
     public abstract void recolocaY(float y);
     public void recolocaXY(float x,float y){

     }



     public  void pinta(Canvas canvas){

      }

     public abstract void reset();
     public abstract void update(GameView game, float fps);


}
