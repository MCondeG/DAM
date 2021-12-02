package ejercicio5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int PUERTO=5000;
		final String HOST="localhost";
		
		DataInputStream dis;
		DataOutputStream dos;
		
		try {
			Socket socket=new Socket(HOST,PUERTO);
			
			dis=new DataInputStream(socket.getInputStream());
			dos=new DataOutputStream(socket.getOutputStream());
			
			dos.writeUTF("2-5");
			
			String mensaje=dis.readUTF();
			System.out.println(mensaje);
			
			socket.close();
			
		}catch(IOException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,ex);
		}
	}

}
