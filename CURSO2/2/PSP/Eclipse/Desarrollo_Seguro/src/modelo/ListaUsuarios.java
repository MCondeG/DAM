package modelo;

import java.util.ArrayList;

public class ListaUsuarios {
	
	private ArrayList<Usuario> Usuarios;
	
	
	
	public ListaUsuarios() {
		
		this.Usuarios = new ArrayList<Usuario>();
	}


	
	public ArrayList<Usuario> getUsuarios() {
		return Usuarios;
	}


	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.Usuarios = usuarios;
	}
	
	
	
}