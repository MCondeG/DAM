package ejercicio5;

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
				
				String mensaje=dis.readUTF();
				System.out.println(mensaje);
				
				float num1=-2, num2=-2, res=-3;
				
				if(mensaje.contains("+")) {
					System.out.println("SUMA");
					mensaje.replace(" ", "");
					int inx = mensaje.indexOf("+");
					num1=Float.parseFloat(mensaje.substring(0, inx));
					System.out.println("num1 "+num1);
					num2=Float.parseFloat(mensaje.substring(inx+1));
					System.out.println("num 2"+num2);
					res=num1+num2;
					System.out.println("res "+res);
				}else if(mensaje.contains("-")) {
					System.out.println("RESTA");
					mensaje.replace(" ", "");
					int inx = mensaje.indexOf("-");
					num1=Float.parseFloat(mensaje.substring(0, inx));
					System.out.println("num1 "+num1);
					num2=Float.parseFloat(mensaje.substring(inx+1));
					System.out.println("num2 "+num2);
					res=num1-num2;
					System.out.println("res "+res);
				}else if(mensaje.contains("*")) {
					System.out.println("MULTIPLICACION");
					mensaje.replace(" ", "");
					int inx = mensaje.indexOf("*");
					num1=Float.parseFloat(mensaje.substring(0, inx));
					System.out.println("num1 "+num1);
					num2=Float.parseFloat(mensaje.substring(inx+1));
					System.out.println("num2 "+num2);
					res=num1*num2;
					System.out.println("res "+res);
				}else if(mensaje.contains("/")) {
					System.out.println("DIVISION");
					mensaje.replace(" ", "");
					int inx = mensaje.indexOf("/");
					num1=Float.parseFloat(mensaje.substring(0, inx));
					System.out.println("num1 "+num1);
					num2=Float.parseFloat(mensaje.substring(inx+1));
					System.out.println("num2 "+num2);
					res=num1/num2;
					System.out.println("res "+res);
				}
				
				dos.writeUTF("El resultado es: "+res);
				socket.close();
				System.out.println("Cliente desconectado");
			}
		}catch(IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}
	}

}
