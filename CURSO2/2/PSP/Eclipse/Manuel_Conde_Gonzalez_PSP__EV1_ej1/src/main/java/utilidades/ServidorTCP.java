package utilidades;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServidorTCP extends ConexionSocketsTCP {

	public ServidorTCP() {
		
		super("servidor");
	}
	
	
	public ServerSocket getSs() {
		return ss;
	}

	public void setSs(ServerSocket ss) {
		this.ss = ss;
	}
	
	public String getHOST() {
		return HOST;
	}
}