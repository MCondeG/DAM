package com.example.hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int numero, res;

    Button button, button2;
    EditText textview, textview2, textview3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciamos elementos del interfaz

        button=this.findViewById(R.id.button);
        button2=this.findViewById(R.id.button2);
        textview=this.findViewById(R.id.textView);
        textview2=this.findViewById(R.id.textView2);
        textview3=this.findViewById(R.id.textView3);




        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               //MiHilo mihilo=new MiHilo(Integer.parseInt(textview.getText().toString()));
              // mihilo.start();

                MiHiloTask mihilotask=new MiHiloTask();
                mihilotask.execute( Integer.parseInt(textview.getText().toString()));

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textview3.append("hola");
            }
        });



    }
    private class MiHilo extends Thread{
        int n;
        public MiHilo(int n){
            this.n=n;
        }
        @Override
        public void run(){
            res=calculaFactorial(n);
            Log.d("hilos","hola "+res);

            //Para poder acceder a elementos del interfaz desde el interior del hilo
            runOnUiThread(new Runnable(){
                @Override
                public void run() {
                    textview2.setText(""+res);
                }
            });
       }

    }

    private class MiHiloTask extends AsyncTask<Integer ,Integer,Integer>{

        private ProgressDialog progreso;

        @Override
        protected void onPreExecute() {
            progreso=new ProgressDialog(MainActivity.this);
            progreso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progreso.setMessage("calculando...");
            progreso.setCancelable(true);
            progreso.setOnCancelListener(new DialogInterface.OnCancelListener(){

                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    MiHiloTask.this.cancel(true);
                }
            });
            progreso.setMax(100);
            progreso.setProgress(0);
            progreso.show();
        }

        //Se ejecuta en un nuevo hilo
        @Override
        protected Integer doInBackground(Integer... n) {
            //int res;
            //res=calculaFactorial(n[0]);
            int res=1;
            for (int i=1;i<=n[0]&&!isCancelled();i++){
                res*=i;
                SystemClock.sleep(1000);
                publishProgress(res,i*100/n[0]);
            }
            return res;
        }

        @Override
        protected void onProgressUpdate(Integer... valor) {
            textview2.setText(""+valor[0]);
            progreso.setProgress(valor[1]);
        }

        @Override
        protected void onPostExecute(Integer res) {
           progreso.dismiss();
            textview2.setText(""+res);
        }
        @Override
        protected void onCancelled(){
            textview2.setText("Cancelado");
        }
    }

    private int calculaFactorial(int n){
        int res=1;
        for (int i=1;i<=n;i++){
            res*=i;
            SystemClock.sleep(1000);
        }
        return res;
    }



}