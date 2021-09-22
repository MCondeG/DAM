package entidades;

public class Usuario {



    private String nombre;
    private String Password;

    public Usuario(String nombre,String password) {
       setNombre(nombre);
       setPassword(password);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
