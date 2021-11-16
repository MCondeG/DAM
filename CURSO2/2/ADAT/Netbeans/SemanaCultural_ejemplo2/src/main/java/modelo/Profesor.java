
package modelo;

public class Profesor {
    private int id_profesor;
    private String nombreUsuario;
    private String nombre;
    private String password;

    public Profesor(int id_profesor, String nombreUsuario, String nombre, String password) {
        this.id_profesor = id_profesor;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.password = password;
    }

    public Profesor() {
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
