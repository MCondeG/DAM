package ejercicio7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

	public static void main(String[] args) {

		ServerSocket servidor = null;
		Socket socket = null;
	    FileReader fr = null;
	    BufferedReader br = null;

		final int PUERTO = 5000;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			socket = servidor.accept();

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			File archivo = (File) ois.readObject();
			
			System.out.println("Nombre del archivo: "+archivo.getName());
			
	        fr = new FileReader (archivo);
	        br = new BufferedReader(fr);
	        
	        System.out.println("Contenido: ");
	         String linea;
	         int num=1;
	         while((linea=br.readLine())!=null) {
	        	 System.out.println("linea "+num+" "+linea+" "+linea.length());
	        	 num++;
	         }
	            
	      	
	        br.close();
	        fr.close();
			socket.close();
			System.out.println("Cliente desconectado");

		} catch (IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}