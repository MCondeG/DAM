package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.Paquete;
import controlador.sockets.Cliente;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;


public class ClienteVentana {

	private JFrame frame;
	private JTextArea campoChat;
	private JTextField campoMensaje, nick, ip;
	private JButton btnEnviar;
	
	private Cliente cliente;
	private Paquete datos;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteVentana window = new ClienteVentana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public ClienteVentana() {
		initialize();
		
		this.datos = new Paquete();
	}
	
	
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 400, 700);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		JLabel lblChat = new JLabel("- CHAT -");
		lblChat.setFont(new Font("Dialog", Font.BOLD, 18));
		lblChat.setBounds(156, 12, 81, 15);
		this.frame.getContentPane().add(lblChat);
		
		this.campoChat = new JTextArea();
		campoChat.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.campoChat.setBounds(27, 93, 342, 346);
		this.frame.getContentPane().add(this.campoChat);
		
		this.nick = new JTextField();
		this.nick.setBounds(27, 11, 114, 19);
		this.frame.getContentPane().add(this.nick);
		this.nick.setColumns(10);
		
		this.ip = new JTextField();
		this.ip.setBounds(255, 11, 114, 19);
		this.frame.getContentPane().add(this.ip);
		this.ip.setColumns(10);
		
		this.campoMensaje = new JTextField();
		this.campoMensaje.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.campoMensaje.setBounds(27, 473, 342, 41);
		this.frame.getContentPane().add(this.campoMensaje);
		this.campoMensaje.setColumns(10);
		
		this.btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Dialog", Font.BOLD, 14));
		this.btnEnviar.setBounds(140, 541, 117, 41);
		EnviaTexto evento = new EnviaTexto();
		this.btnEnviar.addActionListener(evento);
		this.frame.getContentPane().add(this.btnEnviar);
	}
	
	
	private class EnviaTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			datos.setNick(nick.getText());
			datos.setIp(ip.getText());
			datos.setMensaje(campoMensaje.getText());
			
			try {
				cliente = new Cliente();
				
				cliente.setObjetoSalida(new ObjectOutputStream(cliente.getFlujoSalida()));
				
				cliente.getObjetoSalida().writeObject(datos);
				
				cliente.cerrar();
			} catch (UnknownHostException e1) {
				System.out.println(e1.getMessage());
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
}