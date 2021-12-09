package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import utilidades.ClienteTCP;

public class Cliente {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Integer num = 0;
		String mensaje;
		
		ClienteTCP cliente = new ClienteTCP();
		DataOutputStream dos;
		
		try {
			do {
				dos = new DataOutputStream(cliente.getCs().getOutputStream());
				
				System.out.println("Introduce un entero (negativo para finalizar)");
				num = sc.nextInt();
				mensaje = num.toString();
				
				dos.writeUTF(mensaje);
							
			} while (num >= 0);
		}
		catch(IOException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,ex);
		}
		
		sc.close();
	}
}