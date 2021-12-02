package sockets;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServidorTCP extends ConexionSocketsTCP {

	public ServidorTCP() {
		
		super("servidor");
		
		try {
			this.dis = new DataInputStream(this.cs.getInputStream());
			this.dos = new DataOutputStream(this.cs.getOutputStream());
		} catch (IOException ex) {
			Logger.getLogger(ConexionSocketsUDP.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	
	public ServerSocket getSs() {
		return ss;
	}

	public void setSs(ServerSocket ss) {
		this.ss = ss;
	}

	public DataInputStream getDis() {
		return dis;
	}

	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}

	public DataOutputStream getDos() {
		return dos;
	}

	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}

	public String getHOST() {
		return HOST;
	}
}