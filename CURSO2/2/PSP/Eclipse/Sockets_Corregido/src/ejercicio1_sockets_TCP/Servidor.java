package ejercicio1_sockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String[] args) {
	
		ServerSocket servidor=null;
		
		//se abre un puente de comunicacion entre el servidor y el cliente
		Socket socket = null;
		
		final int PUERTO=5000;
		
		
		//los mensajes viajan a traves de estos objetos
		//Las clases DataInputStream y DataOutputStream sirven para leer/escribir 
		//datos de tipo primitivo de una forma portable
		DataInputStream in;
		DataOutputStream out;
		
		try {
			servidor=new ServerSocket (PUERTO);
			System.out.println("Servidor iniciado");
			
			while(true) {
				//el servidor se mantiene a la escucha hasta que le llega
				//a traves del socket un mensaje
				socket=servidor.accept();
				
				in=new DataInputStream(socket.getInputStream());
				out=new DataOutputStream(socket.getOutputStream());
				
				String mensaje = in.readUTF();
				System.out.println(mensaje);
				
				out.writeUTF("Saludos desde el servidor");
				
				socket.close();
				
				System.out.println("Cliente desconectado");
			}
				
			
		}catch(IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
		}
	}

}
