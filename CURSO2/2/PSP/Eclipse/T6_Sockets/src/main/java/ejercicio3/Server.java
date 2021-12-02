package ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

	public static void main(String[] args) {
		
		ServerSocket servidor = null;
		Socket socket = null;
		
		final int PUERTO = 5000;
		
		DataInputStream dis;
		DataOutputStream dos;
		
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			
			while(true) {
				socket = servidor.accept();
				
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				
				String mensaje = dis.readUTF();
				System.out.println("Recibido "+mensaje);
				Float cuadrado = Float.parseFloat(mensaje);
				cuadrado *= cuadrado;
				mensaje = cuadrado.toString();
				System.out.println(mensaje);
				
				System.out.println("Enviado: "+ mensaje);
				dos.writeUTF(mensaje);
				socket.close();
				System.out.println("Cliente desconectado");
			}
		}catch(IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
}