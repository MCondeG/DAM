package modelo;

import java.io.Serializable;
import java.util.ArrayList;


public class Paquete implements Serializable {
	
	
	private Usuario emisor;
	private Usuario receptor = null;
	private String mensaje;
	
	private ArrayList<Usuario> usuariosOnline;
	
	
	public Paquete() {
		this.emisor = null;
		this.receptor = null;
		this.mensaje = "";
		this.usuariosOnline = null;
	}
	
	public Paquete(Usuario emisor, Usuario receptor, String mensaje, ArrayList<Usuario> usuariosOnline) {
		this.emisor = emisor;
		this.receptor = receptor;
		this.mensaje = mensaje;
		this.usuariosOnline = usuariosOnline;
	}
	

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ArrayList<Usuario> getUsuariosOnline() {
		return usuariosOnline;
	}

	public void setUsuariosOnline(ArrayList<Usuario> usuariosOnline) {
		this.usuariosOnline = usuariosOnline;
	}
}