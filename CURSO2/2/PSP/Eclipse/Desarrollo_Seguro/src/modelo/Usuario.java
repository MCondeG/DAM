package modelo;

import controlador.Seguridad;

public class Usuario {
	
	private String name;
	private String password;
	
	
	public Usuario() {
		
	}
	
	public Usuario (String name, String password) {
		
		this.name = name;
		this.password = Seguridad.codificarPassword(password);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		
		return ("Usuario [NAME = " + this.name + ", PASSWORD = " + this.password + "]");
	}
}