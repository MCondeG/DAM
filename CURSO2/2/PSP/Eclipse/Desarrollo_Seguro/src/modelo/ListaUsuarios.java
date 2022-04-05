package modelo;

import java.util.ArrayList;

public class ListaUsuarios {
	
	private ArrayList<Usuario> usuarios;
	
	
	
	public ListaUsuarios() {
		
		this.usuarios = new ArrayList<Usuario>();
	}


	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	public void añadirUsuario(String name, String password) {
		
		this.usuarios.add(new Usuario(name, password));
	}
}