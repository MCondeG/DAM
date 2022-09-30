package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button boton0;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;
    private Button boton5;
    private Button boton6;
    private Button boton7;
    private Button boton8;
    private Button boton9;
    private Button botonSuma;
    private Button botonResta;
    private Button botonX;
    private Button botonDiv;
    private Button botonIgual;
    private Button botonC;

    private int cont;
    private int op;
    private double n1;
    private double n2;
    private double result;
    private boolean p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVariables();
    }


    private void inicializaVariables() {

        this.textView = (TextView)findViewById(R.id.textView);
        this.boton0 = (Button)findViewById(R.id.boton0);
        this.boton1 = (Button)findViewById(R.id.boton1);
        this.boton2 = (Button)findViewById(R.id.boton2);
        this.boton3 = (Button)findViewById(R.id.boton3);
        this.boton4 = (Button)findViewById(R.id.boton4);
        this.boton5 = (Button)findViewById(R.id.boton5);
        this.boton6 = (Button)findViewById(R.id.boton6);
        this.boton7 = (Button)findViewById(R.id.boton7);
        this.boton8 = (Button)findViewById(R.id.boton8);
        this.boton9 = (Button)findViewById(R.id.boton9);
        this.botonSuma = (Button)findViewById(R.id.botonSuma);
        this.botonResta = (Button)findViewById(R.id.botonResta);
        this.botonX = (Button)findViewById(R.id.botonX);
        this.botonDiv = (Button)findViewById(R.id.botonDiv);
        this.botonIgual = (Button)findViewById(R.id.botonIgual);
        this.botonC = (Button)findViewById(R.id.botonC);

        this.cont = 0;
        this.op = 0;
        this.n1 = 0;
        this.n2 = 0;
        this.result = 0;
        this.p = false;
    }


    public void escribeNum(View v) {

        if(this.textView.getText().toString().equals("ERROR")) this.textView.setText("");

        String id = getResources().getResourceEntryName(v.getId());
        id = id.substring(5);

        this.textView.append(id);
    }

    public void decimal(View v) {

        this.textView.append(".");
        this.cont++;
    }

    public void negativo(View v) {

        String[] partes = this.textView.getText().toString().split("\n");

        if (this.p) this.textView.setText(partes[0] + "\n" + partes[1] + "\n-" + partes[2]);
        else {
            if (Double.parseDouble(this.textView.getText().toString()) > 0) {
                this.textView.setText("-" + this.textView.getText());
                this.cont++;
            }
        }
    }

    public void operacion(View v) {

        String id = getResources().getResourceEntryName(v.getId());
        id = id.substring(5);


        try{
            this.cont = this.textView.getText().toString().length();
            this.n1 = Double.parseDouble(this.textView.getText().toString());

            switch (id) {
                case "Suma":
                    this.textView.append("\n+\n");
                    this.op = 1;
                    break;
                case "Resta":
                    this.textView.append("\n-\n");
                    this.op = 2;
                    break;
                case "X":
                    this.textView.append("\nx\n");
                    this.op = 3;
                    break;
                case "Div":
                    this.textView.append("\n/\n");
                    this.op = 4;
                    break;
                default:
                    break;
            }

            this.p = true;
            this.cont++;
        }
        catch (Exception e){
            this.error();
        }
    }

    public void borrar(View v) {

        this.textView.setText("");
        this.cont = 0;
        this.n1 = 0;
        this.n2 = 0;
        this.result = 0;
    }

    public void resultado(View v) {

        try {
            this.n2 = Double.parseDouble(this.textView.getText().toString().substring(this.cont+1));

            switch (this.op) {
                case 1:
                    this.result = n1 + n2;
                    break;
                case 2:
                    this.result = n1 - n2;
                    break;
                case 3:
                    this.result = n1 * n2;
                    break;
                case 4:
                    this.result = n1 / n2;
                    break;
                default:
                    break;
            }

            this.textView.setText(Double.toString(result));
            this.cont = 0;
            this.p = false;
        }
        catch (Exception e) {
            this.error();
        }
    }


    public void error() {
        this.textView.setText("ERROR");
        this.cont = 0;
        this.n1 = 0;
        this.n2 = 0;
        this.result = 0;
    }
}