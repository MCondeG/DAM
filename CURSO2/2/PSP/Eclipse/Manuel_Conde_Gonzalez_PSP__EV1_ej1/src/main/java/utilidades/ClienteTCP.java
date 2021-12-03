package utilidades;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteTCP extends ConexionSocketsTCP {

	public ClienteTCP() {
		
		super("cliente");
	}


	public Socket getCs() {
		return cs;
	}

	public void setCs(Socket cs) {
		this.cs = cs;
	}

	public String getHOST() {
		return HOST;
	}
}