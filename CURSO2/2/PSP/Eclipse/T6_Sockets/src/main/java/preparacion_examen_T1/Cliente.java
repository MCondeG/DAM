package preparacion_examen_T1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int PUERTO=5000;
		final String HOST="localhost";
		ObjectInputStream ois;
		DataOutputStream dos;
		
		try {
			Socket socket=new Socket(HOST,PUERTO);
			
			ois=new ObjectInputStream(socket.getInputStream());
			dos=new DataOutputStream(socket.getOutputStream());
			
			String filename="src\\texto";
			
			dos.writeUTF(filename);
			System.out.println("Mando la ruta!");
			
			File archivo=(File) ois.readObject();
	        FileReader fr = new FileReader (archivo);
	        BufferedReader br = new BufferedReader(fr);
	        
	        System.out.println("Recibo el archivo!");
	        System.out.println("Contenido: ");
	         String linea;
	         int num=1;
	         while((linea=br.readLine())!=null) {
	        	 System.out.println("linea "+num+" "+linea+" "+linea.length());
	        	 num++;
	         }
			
			socket.close();
			
		}catch(IOException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
