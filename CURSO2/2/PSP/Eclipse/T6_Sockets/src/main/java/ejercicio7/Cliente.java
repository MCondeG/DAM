package ejercicio7;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {

		final int PUERTO = 5000;
		final String HOST = "localhost";

		String filename = "src/main/java/ejercicio7/texto.txt";
		File archivo = new File(filename);
		archivo = new File(archivo.getAbsolutePath());
		try {
			Socket socket = new Socket(HOST, PUERTO);
			System.out.println("Nombre del archivo: "+archivo.getName());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(archivo);
			System.out.println("Archivo enviado!");
			socket.close();
		} catch (IOException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}