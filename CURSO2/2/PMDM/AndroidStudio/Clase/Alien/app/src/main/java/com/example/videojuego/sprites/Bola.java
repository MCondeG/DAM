package com.example.videojuego.sprites;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.example.videojuego.GameView;
import com.example.videojuego.Pong;

import java.util.LinkedList;
import java.util.Random;

public class Bola extends SpriteRect {


    public Bola( int x, int y) {
        super(x,y);
        ancho=mScreenX/100;
        alto=ancho;
        //tamaño del rectángulo que pinta a la pala
        mRect=new RectF(mXCoord, mYCoord, mXCoord+ ancho, mYCoord+ alto);
        //Se inicializa la velocidad. Esta representará lo que se mueve el objeto tanto en horizontal como en vertical
        //al igualar, se moverá en diagonal.
        velInicialX=mScreenY/100;
        velInicialY=mScreenY/100;

        velActualX=velInicialX;
        velActualY=velInicialY;

    }

    @Override
    public boolean colision(Sprite s) {
        return false;
    }


    //Invertir velocidad X
    public void invertirVelX(){
        velActualX=-velActualX;
    }
    //Invertir velocidad Y
    public void invertirVelY(){
        velActualY=-velActualY;
    }


    //acelerar aleatoriamete la velocidad
    public void setRandomXVelocity(){
        Random random=new Random();
        int addVelocity=random.nextInt(2);
        this.velActualX+=addVelocity;
        if (addVelocity==0)invertirVelX();


    }

    //acelerar un 10% cada vez que se choque con la pala/ se salga de la pantalla

    public void icrementaVelocidad(){
        velActualX*=1.1f;
        velActualY*=1.1f;

    }

    @Override
    public void reset() {
        mRect.left=mScreenX/2;
        mRect.right=mScreenX/2+ ancho;
        mRect.top=mScreenY-20;
        mRect.bottom=mScreenY-20+alto;
        this.velActualX=velInicialX;
        this.velActualY=velInicialY;
    }

    @Override
    public void update(GameView game, float fps) {

        Pong pong=(Pong)game;

        //calculamos las coordenadas actuales y
        //Se actualiza la esquina inferior derecha del rectangulo a partir de la anterior
        mRect.left=mRect.left+velActualX*pong.factor_mov;
        mRect.top=mRect.top+velActualY*pong.factor_mov;
        //mRect.left=mRect.left+velActualX;
        //mRect.top=mRect.top+velActualY;
        mRect.right=mRect.left+ancho;
        mRect.bottom=mRect.top+alto;

        //Comprobamos colisiones de nuestra bola con el resto de objetos del juego
        //en este caso de la pala
        LinkedList<Sprite> objetos=pong.getActores();

        for(Sprite objeto:objetos){

            if (!objeto.equals(this)){

                if (objeto.isVisible()&&colision(objeto)){




                    if (objeto instanceof Bola) {

                   ((Bola) objeto).setRandomXVelocity();
                   ((Bola) objeto).invertirVelY();
                       objeto.recolocaY(((Bola) objeto).getRect().top - 2);
                        setRandomXVelocity();
                        invertirVelY();
                     //this.visible=false;
                     //  objeto.visible=false;


                    }else{
                        setRandomXVelocity();
                        invertirVelY();
                        recolocaY(((Bola) objeto).getRect().top - 2);

                    }


                }
            }
        }


/*
        for (Sprite actor : actores) {
            if (colision(actor)&&actor.visible) {
                setRandomXVelocity();
                invertirVelY();
                setRandomXVelocity();
                if (actor instanceof Bola) {

                    ((Bola) actor).setRandomXVelocity();
                    ((Bola) actor).invertirVelY();
                    ((Bola) actor).setRandomXVelocity();

                 this.visible=false;
                 actor.visible=false;

                }
                recolocaY(actor.getRect().top - 2);

                //emite sonido
            }
        }
    */

        //comprobamos colisiones con los bordes

        //comprobamos si la bola se sale por izda o dercha
        if (colisionBordeRight()) {
            invertirVelX();
            recolocaX(mScreenX - ancho - 2);
            //emite sonido

        }
        if (colisionBordeLeft()) {
            invertirVelX();
            recolocaX(2);
            //emite sonido
        }

        //comprobamos si la bola se sale por arriba
        if (colisionBordeTop()) {
            invertirVelY();
            recolocaY(10);
            //emite sonido
        }

        //comprobamos si la bola se sale por abajo
        if (colisionBordeBottom()) {

            invertirVelY();
            recolocaY(mScreenY - 2);
            //emite sonido
            pong.vidas--;
            if ( pong.vidas == 0) {
                // pong.pausado = true;
               // pong.setupGame();
            }
        }
    }


    public  void pinta(Canvas canvas){

        paint.setColor(color);
        float centroX=ancho/2+ mRect.left;
        float centroY=alto/2+mRect.top;
        canvas.drawCircle(centroX,centroY,ancho/2, paint);

    }
}