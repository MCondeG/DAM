package com.example.videojuego;


import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowMetrics;
import android.widget.ImageView;
import android.widget.Toast;

/*

Implementación del esquema general de un videojuego.
También lo convertiremos en un motor de videojuegos para futuros proyectos
En Android los juegos se programan directamente "a pelo"

*/

public class MainActivity extends Activity {

    Pong pong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //obtenemos la pantalla
        Display display= getWindowManager().getDefaultDisplay();
        Point size=new Point();
        display.getSize(size);
        //gameView=new GameView(this,area.right-area.left,area.bottom-area.top);



        pong=new Pong(this,size.x,size.y);

        setContentView(pong);
    }


    @Override
    protected void onResume() {
        super.onResume();
        pong.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pong.pause();
    }
}