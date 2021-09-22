package ejercicios;

import java.util.Scanner;

public class Libros extends Publicacion {
	
	boolean prestado;
	static Scanner sc = new Scanner (System.in);
	
	Libros () {
		
	}
	
	Libros (int codigo, String titulo, int año,boolean p) {
		
		super (codigo, titulo, año);
		this.prestado = p;
		
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	@Override
	public String toString() {
		return "\nPrestado=" + prestado + "\nCódigo=" + this.getCodigo() + "\nTítulo=" + this.getTitulo()
				+ "\nAño=" + this.getAño();
	}

	public void prestar () {
		
		if (prestado()) System.out.println("Prestar");
		else System.out.println("No se puede");
	}
	
	public void devolver () {
		
		if (!prestado()) System.out.println("Devolver");	
		else System.out.println("No se puede");
		
	}
	
	public boolean prestado () {
		
		boolean prestar = false;
		
		if (prestar == true) {
			
			prestar = true;
			
		}
		
		else {
			
			prestar = false;
			
		}
		
		return prestar;
		
	}
	
	public Libros pedirDatosT () {
		
		Libros datos = new Libros ();
		
		System.out.println("Introduce el código del libro: ");
		datos.setCodigo(sc.nextInt());
		
		System.out.println("Introduce el título del libro: ");
		datos.setTitulo(sc.next());
		
		System.out.println("Introduce el año del libro: ");
		datos.setAño(sc.nextInt());
		
		System.out.println("¿Está prestado el libro?");
		String prest = sc.next();
		
		if (prest.compareTo("si") == 0) {
			
			datos.setPrestado(true);
			
		}
		
		if (prest.compareTo("no") == 0) {
			
			datos.setPrestado(false);
			
		}
		
		return datos; 
		
	}


}