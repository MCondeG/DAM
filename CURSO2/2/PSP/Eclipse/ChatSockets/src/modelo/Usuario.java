package modelo;

import java.io.Serializable;
import java.net.SocketException;

import controlador.Network;


public class Usuario implements Serializable {	
	
	private String nick;
	private String ip;
		
	
	public Usuario() {
		
	}
	
	public Usuario(String nick) {
		
		this.nick = nick;
		
		try {
			this.ip = Network.getFirstNonLoopbackAddress(true, false).getHostAddress();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	@Override
	public String toString() {
		return (this.nick + "   " + this.ip);
	}
}