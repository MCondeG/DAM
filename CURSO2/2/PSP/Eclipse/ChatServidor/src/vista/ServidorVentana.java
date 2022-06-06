package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import controlador.Paquete;
import controlador.sockets.Servidor;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;


public class ServidorVentana implements Runnable {

	private JFrame frame;
	private JTextArea textArea;
	
	private Servidor servidor;
	private Paquete datos;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServidorVentana window = new ServidorVentana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ServidorVentana() {
		initialize();
		
		this.datos = new Paquete();
	}

	
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 700, 400);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		this.textArea = new JTextArea();
		this.textArea.setBounds(12, 57, 676, 247);
		this.frame.getContentPane().add(this.textArea);
		
		JLabel lblServidor = new JLabel("SERVIDOR");
		lblServidor.setFont(new Font("Dialog", Font.BOLD, 18));
		lblServidor.setBounds(290, 12, 116, 15);
		this.frame.getContentPane().add(lblServidor);
		
		
		Thread h = new Thread(this);
		h.start();
	}

	
	@Override
	public void run() {
		
		String nick, ip, mensaje;
		
		this.servidor = new Servidor();
		
		try {			
			do {
				this.servidor.setObjetoEntrada(new ObjectInputStream(this.servidor.getSocketCliente().getInputStream()));
				
				//ObjectInputStream o = new ObjectInputStream(this.servidor.getSocketCliente().getInputStream());
				
				//this.datos = (Paquete) o.readObject();
				
				
				nick = datos.getNick();
				ip = datos.getIp();
				mensaje = datos.getMensaje();
				
				
				this.textArea.append("\n" + mensaje);
				
				servidor.cerrar();
			} while(true);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
}