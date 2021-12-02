package ejercicio6;

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
		
		final int PUERTO=5000;
		
		DataInputStream dis;
		DataOutputStream dos;
		
		try {
			servidor=new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			String mensaje = "";
			Boolean sigue = true;
			while(sigue) {
				socket=servidor.accept();
				
				dis=new DataInputStream(socket.getInputStream());
				dos=new DataOutputStream(socket.getOutputStream());
				
				mensaje=dis.readUTF();
				System.out.println("Recibido: "+mensaje);
				
				String contestacion="OK";
				
				if(mensaje.equalsIgnoreCase("no")) {
					sigue = false;
					contestacion = "Cerrar";
				}
				
				System.out.println("Enviado: "+contestacion);
				dos.writeUTF(contestacion);
			}
			socket.close();
			System.out.println("Cliente desconectado");

		}catch(IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}
	}

}
