package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class ListaUsuarios implements Serializable {
	
	private ArrayList<Usuario> usuarios;
	
	
	public ListaUsuarios() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public ListaUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	public void añadir(Usuario user) {
		this.usuarios.add(user);
	}
	
	public void eliminar(Usuario usuario) {
	    
		int index = this.usuarios.stream()
			    .map(user -> user.getIp())
			    .collect(Collectors.toList())
			    .indexOf(usuario.getIp());

		this.usuarios.remove(index);
	}
	
	public boolean buscarUsuario(String ip){
	    return this.usuarios.stream()
	    		.anyMatch(o -> o.getIp()
	    		.equals(ip));
	}
}