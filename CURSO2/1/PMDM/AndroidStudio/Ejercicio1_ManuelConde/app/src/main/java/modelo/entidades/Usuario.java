package modelo.entidades;

public class Usuario {

    private String nombre;
    private String contraseña;
    private static int cont = 0;


    public Usuario() {
        this.nombre = "usuario"+(Integer.toString(cont));
        this.contraseña = "pass"+(Integer.toString(cont));
        cont++;
    }

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        cont++;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {

        return ("USUARIO: "+this.nombre+"\n");

    }
}