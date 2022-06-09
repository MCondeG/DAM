package controlador;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public abstract class ConexionSockets {
	
	protected int puerto; 						//Puerto para la conexión
	protected String ip;						//Host para la conexión	
	
	protected ServerSocket socketServidor; 		//Socket del servidor
	protected Socket socketCliente; 			//Socket del cliente
	protected DataInputStream flujoEntrada; 	//Flujo de datos de entrada
	protected DataOutputStream flujoSalida; 	//Flujo de datos de salida
	protected ObjectInputStream objetoEntrada;	//Objetos de entrada
	protected ObjectOutputStream objetoSalida;	//Objetos de salida
	
	
	public void cerrar() {
		
		if (!this.socketCliente.isClosed()) {
			try {
				this.socketCliente.close();
				this.flujoEntrada.close();
				this.flujoSalida.close();
				if (this.objetoEntrada != null) this.objetoEntrada.close();
				this.objetoSalida.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
}