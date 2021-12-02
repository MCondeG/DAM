package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket servidor=null;
		//puente de comunicacion entre server y cliente
		Socket socket=null;
		
		final int PUERTO=5000;
		
		//Los mensajes viajan a través de estos objetos
		//Las clases DataInputStream y DataOutputStream sirven para ller/escribir
		DataInputStream dis;
		DataOutputStream dos;
		
		try {
			servidor=new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			
			while(true) {
				socket=servidor.accept();
				
				dis=new DataInputStream(socket.getInputStream());
				dos=new DataOutputStream(socket.getOutputStream());
				
				String mensaje=dis.readUTF();
				System.out.println(mensaje);
				
				dos.writeUTF("Saludos desde el servidor!!!");
				socket.close();
				System.out.println("Cliente desconectado");
			}
		}catch(IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}
	}

}
