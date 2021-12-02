package preparacion_examen_T1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
		
		DataInputStream dis;
		ObjectOutputStream oos;
		

		
		try {
			servidor=new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			
			
			while(true) {
				socket=servidor.accept();
				
				dis=new DataInputStream(socket.getInputStream());
				oos=new ObjectOutputStream(socket.getOutputStream());
				
				String filename =dis.readUTF();
				System.out.println("Recibo ruta del archivo!");
				System.out.println(filename);
				
				File archivo = new File(filename);
				archivo = new File(archivo.getAbsolutePath());
				
				oos.writeObject(archivo);
				socket.close();
				System.out.println("Cliente desconectado");
			}
		}catch(IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}
	}

}
