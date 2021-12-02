package ejercicio4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ejercicio1.Server;

public class Cliente {

	public static void main(String[] args) {
		final int PUERTO_SERVIDOR = 5000;
		byte[] buffer = new byte[1024];
		
		try {
			//obtengio la localizacion de localhost
			InetAddress direccionServidor = InetAddress.getByName("localhost");
			//InetAddress direccionServidor = InetAddress.("172.16.19.244");
			//creo el socket
			DatagramSocket socketUDP= new DatagramSocket();
			
			int numero=5;
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(baos); 
			
			//Convierto el mensaje a bytes
			dos.writeInt(numero); // wrap as data stream, and use it
			dos.writeUTF("Envio: "+numero); // write some data (String)
			dos.flush(); 
			
			dos.close(); // !!! flush and close
			
			buffer = baos.toByteArray(); // buf contains written data
			baos.close();
			//creo un datagrama
			DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
			
			//lo envio con send
			System.out.println("Envio el datagrama");
			socketUDP.send(pregunta);
			
			//preparo la respuesta
			buffer = new byte[1024];
			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
			
			//recibo la respuesta
			socketUDP.receive(peticion);
			System.out.println("Recibo la peticion");
			
			buffer = peticion.getData();
			ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
			DataInputStream dis = new DataInputStream(bais);
			
			//cojo los datos y lo muestro
			String mensaje="";
			mensaje=dis.readUTF();
			System.out.println("Recibo: "+mensaje);
			
			dis.close();
			socketUDP.close();
		}catch (SocketException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}catch(UnknownHostException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		} catch (EOFException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		} catch(IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
}
