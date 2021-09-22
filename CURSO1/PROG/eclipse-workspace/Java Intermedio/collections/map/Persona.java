package map;

public class Persona {
 
    private String nombre;
    private String contrase�a;
    private static int cont = 0;
    
    
    public Persona() {
        this.nombre = "usuario"+(Integer.toString(cont));
        this.contrase�a = "pass"+(Integer.toString(cont));
        cont++;
    }
    
    public Persona(String nombre, String contrase�a) {
        this.nombre = nombre;
        this.contrase�a = contrase�a;
        cont++;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrase�a() {
        return contrase�a;
    }

    public void setContrase�a(String contrase�a) {
        this.contrase�a = contrase�a;
    }
    
    @Override
    public String toString() {
		
	return (this.nombre+", "+this.contrase�a+"\n");

    }
}