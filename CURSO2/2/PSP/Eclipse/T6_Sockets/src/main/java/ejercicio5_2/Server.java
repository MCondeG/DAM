package ejercicio5_2;

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
				
				Float num1=dis.readFloat();
				Float num2=dis.readFloat();
				String tipo=dis.readUTF();
				
				System.out.println(num1+" "+tipo+" "+num2);
				
				float res=-99999f;
				
				if(tipo.equals("+")) {
					System.out.println("SUMA");
					res=num1+num2;
					System.out.println("res "+res);
				}else if(tipo.equals("-")) {
					System.out.println("RESTA");
					res=num1-num2;
					System.out.println("res "+res);
				}else if(tipo.equals("*")) {
					System.out.println("MULTIPLICACION");
					res=num1*num2;
					System.out.println("res "+res);
				}else if(tipo.equals("/")) {
					System.out.println("DIVISION");
					res=num1/num2;
					System.out.println("res "+res);
				}
				
				dos.writeFloat(res);
				socket.close();
				System.out.println("Cliente desconectado");
			}
		}catch(IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}
	}

}
