package modelo.entidades;

import java.io.Serializable;

public class Parte implements Serializable {

    private static int idParte = 1;
    private String nombreAlumno;
    private boolean incidencia1;
    private boolean incidencia2;
    private boolean incidencia3;
    private boolean expulsion;


    public Parte() {
        Parte.idParte++;
    }


    public static int getIdParte() {
        return Parte.idParte;
    }

    public static void incrementarIdParte() {
        Parte.idParte++;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public boolean isIncidencia1() {
        return incidencia1;
    }

    public void setIncidencia1(boolean incidencia1) {
        this.incidencia1 = incidencia1;
    }

    public boolean isIncidencia2() {
        return incidencia2;
    }

    public void setIncidencia2(boolean incidencia2) {
        this.incidencia2 = incidencia2;
    }

    public boolean isIncidencia3() {
        return incidencia3;
    }

    public void setIncidencia3(boolean incidencia3) {
        this.incidencia3 = incidencia3;
    }

    public boolean isExpulsion() {
        return expulsion;
    }

    public void setExpulsion(boolean expulsion) {
        this.expulsion = expulsion;
    }
}
