package main.control.ejercicio1_manuelconde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import modelo.daos.DaoAlumno;
import modelo.daos.DaoParte;
import modelo.entidades.Parte;

public class PantallaParte extends AppCompatActivity {

    private EditText etAlumno;
    private CheckBox chb1;
    private CheckBox chb2;
    private CheckBox chb3;
    private RadioGroup rg;
    private RadioButton rb1;
    private RadioButton rb2;

    private DaoAlumno daoAl;
    private DaoParte daoPa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_parte);

        inicio();
    }

    protected void onResume() {
        super.onResume();

        borrar(this.etAlumno, this.chb1, this.chb2, this.chb3, this.rb1, this.rb2);
    }


    private void inicio() {

        this.etAlumno = (EditText)findViewById(R.id.editTextTextPersonName2);
        this.chb1 = (CheckBox)findViewById(R.id.checkBox);
        this.chb2 = (CheckBox)findViewById(R.id.checkBox2);
        this.chb3 = (CheckBox)findViewById(R.id.checkBox3);
        this.rg = (RadioGroup)findViewById(R.id.radioGroup);
        this.rb1 = (RadioButton)findViewById(R.id.radioButton);
        this.rb2 = (RadioButton)findViewById(R.id.radioButton2);
        this.daoAl = new DaoAlumno();
        this.daoPa = new DaoParte();
    }

    public void enviarParte(View v) {

        if (this.daoAl.buscarAlumno(this.etAlumno.getText().toString())) {

            Parte p = new Parte();

            p.setNombreAlumno(this.etAlumno.getText().toString());
            p.setIncidencia1(this.chb1.isChecked());
            p.setIncidencia2(this.chb2.isChecked());
            p.setIncidencia3(this.chb3.isChecked());
            p.setExpulsion(false);
            if(this.rg.getCheckedRadioButtonId() == rb2.getId()) p.setExpulsion(true);

            this.daoPa.addParte(p);


            Intent int2 = new Intent(this, ListViewPartes.class);
            int2.putExtra("partes", this.daoPa.getListaPartes());
            startActivity(int2);
        }
        else {
            Toast.makeText(this, "ERROR. Alumno no válido", Toast.LENGTH_SHORT).show();
            borrar(this.etAlumno, this.chb1, this.chb2, this.chb3, this.rb1, this.rb2);
        }
    }

    public static void borrar(EditText etAlumno, CheckBox chb1, CheckBox chb2, CheckBox chb3, RadioButton rb1, RadioButton rb2) {

        etAlumno.setText("");
        chb1.setChecked(false);
        chb2.setChecked(false);
        chb3.setChecked(false);
        rb1.setChecked(false);
        rb2.setChecked(false);
    }
}