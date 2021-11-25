package ejercicio1_sockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		
		final int PUERTO=5000;
		final String HOST="127.0.0.1";
		
		DataInputStream in;
		DataOutputStream out;
		
		try {
			Socket socket=new Socket(HOST,PUERTO);
			
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			out.writeUTF("Saludos desde el cliente!!!");
			
			String mensaje=in.readUTF();
			
			System.out.println(mensaje);
			
			socket.close();
			
		}catch(IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
		}

	}

}
