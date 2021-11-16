
package modelo;

public class Alumno {
    private int id_alumno;
    private String nombreUsuario;
    private String nombre;
    private String password;
    private int id_grupo;
    private Grupo g;
    private Matricula m;

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_profesor) {
        this.id_alumno = id_profesor;
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

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public Grupo getGrupo() {
        return g;
    }

    
    public void setGrupo(Grupo g) {
        this.g = g;
    }

    public Matricula getMatricula() {
        return m;
    }

    public void setMatricula(Matricula m) {
        this.m = m;
    }
    
    
}