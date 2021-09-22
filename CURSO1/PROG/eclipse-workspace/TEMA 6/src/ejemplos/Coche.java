package ejemplos;


//Clase Coche (estructura genérica de las clases)

public class Coche {
	
	
	//Atributos de la clase Coche
	
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	
	
	//Constructor
	
	Coche (String mat, String mar, String mod, String col) {
		
		this.matricula = mat;
		this.marca = mar;
		this.modelo = mod;
		this.color = col;
	}
	
	
	//Setters
	
	public void setMatricula (String nuevaMat) {
		this.matricula = nuevaMat;
	}
	
	public void setMarca (String nuevaMar) {
		this.marca = nuevaMar;
	}
	
	public void setModelo (String nuevoMod) {
		this.modelo = nuevoMod;
	}
	
	public void setColor (String nuevoCol) {
		this.color = nuevoCol;
	}
	
	
	//Getters
	
	public String getMatricula () {
		return (this.matricula);
	}
	
	public String getMarca () {
		return (this.marca);
	}
	
	public String getModelo () {
		return (this.modelo);
	}
	
	public String getColor () {
		return (this.color);
	}
	
	
	//Métodos de la clase Coche
	
	public void imprimirCoche () {
		
		System.out.println("Matrícula: "+this.matricula);
		System.out.println("Marca: "+this.marca);
		System.out.println("Modelo: "+this.modelo);
		System.out.println("Color: "+this.color);
	}
}