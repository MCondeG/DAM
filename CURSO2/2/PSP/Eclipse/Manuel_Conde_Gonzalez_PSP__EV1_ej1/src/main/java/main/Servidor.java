package main;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import utilidades.Fichero;
import utilidades.ServidorTCP;


public class Servidor {
	
	public static void main(String[] args) {
		
		int num = 0;
		String mensaje;
		Socket socket = null;
		
		ServidorTCP servidor = new ServidorTCP();
		DataInputStream dis;
		
		final String ruta = "src/main/java/main/texto.txt/";
		Fichero fichero = new Fichero(ruta);
		
		try {
			System.out.println("Servidor recibiendo mensajes\n");
			socket = servidor.getSs().accept();
			
			do {				
				dis = new DataInputStream(socket.getInputStream());
				mensaje = dis.readUTF();
				System.out.println("OK");
				
				num = Integer.parseInt(mensaje);
				
				if (num >= 0) fichero.escribirFichero(ruta, mensaje);
				
			} while(num >= 0);
			
			System.out.println("\nCerrando Servidor");
			servidor.getSs().close();
		}
		catch(IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
}