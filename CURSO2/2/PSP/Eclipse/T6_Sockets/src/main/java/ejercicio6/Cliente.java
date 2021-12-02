package ejercicio6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int PUERTO=5000;
		final String HOST="localhost";

		DataInputStream dis;
		DataOutputStream dos;
		
		Scanner sc = new Scanner(System.in);
		
		String mensaje="";
		Boolean sigue = true;
		do {
			try {
				Socket socket = new Socket(HOST,PUERTO);
					
				dis=new DataInputStream(socket.getInputStream());
				dos=new DataOutputStream(socket.getOutputStream());
					
				mensaje= sc.nextLine();
					
				System.out.println("Envio: "+mensaje);
				dos.writeUTF(mensaje);
					
				mensaje=dis.readUTF();
				System.out.println("Recibo: "+mensaje);
					
				if(mensaje.equals("Cerrar")) sigue = false;
				socket.close();
			}catch(IOException ex) {
				Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,ex);
			}
		} while(sigue);
		
		sc.close();
	}

}
