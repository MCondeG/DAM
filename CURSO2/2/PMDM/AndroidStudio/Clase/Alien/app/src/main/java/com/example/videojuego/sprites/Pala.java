package com.example.videojuego.sprites;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.example.videojuego.GameView;
import com.example.videojuego.Pong;

public  class Pala extends SpriteRect {

    public final int STOP=0;
    public final int LEFT=1;
    public final int RIGHT=2;
    public int estadoPala=STOP;




    public Pala(int x, int y){

        super(x,y);


       
        //longitud y anchura de la pala
        ancho=mScreenX/8;
        alto=mScreenY/25;
        //Posición inicial de la pala
        mXCoord=mScreenX/2;
        mYCoord=mScreenY-20;
        //tamaño del rectángulo que pinta a la pala
        mRect=new RectF(mXCoord, mYCoord, mXCoord+ ancho, mYCoord+ alto);
        //Velocidad de la pala
        velInicialX=30;
        velActualX=velInicialX;

    }

    @Override
    public boolean colision(Sprite s) {
        return false;
    }


    public void setEstadoPala(int estadoPala) {
        this.estadoPala = estadoPala;
    }


    public void icrementaVelocidad(){

        velActualX*=1.2f;

    }
    public void reset() {

        velActualX=velInicialX;


    }

    @Override
    public void update(GameView game, float fps) {

        switch (estadoPala){
            case STOP: break;
            case LEFT:  mXCoord=mXCoord-velActualX;break;
            case RIGHT: mXCoord=mXCoord+velActualX;break;
        }

        //Controlamos los bordes
        if (colisionBordeLeft())  mXCoord=0;
        if (colisionBordeRight())  mXCoord=mScreenX-(mRect.right-mRect.left);

        //Damos las coordenadas del Rectángulo. Solo se han modificado el eje X
        mRect.left=mXCoord;
        mRect.right=mXCoord+ ancho;
    }



    @Override
    public void pinta(Canvas canvas) {

        //dibujamos pala
        paint.setColor(Color.argb(255, 255, 255, 255));
        canvas.drawRect(getRect(), paint);

    }
}
