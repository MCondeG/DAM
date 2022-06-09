package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.Cliente;
import controlador.Network;
import controlador.Servidor;
import modelo.Paquete;
import modelo.Usuario;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import javax.swing.JComboBox;


public class ClienteVentana implements Runnable {

	private JFrame frame;
	private JTextArea campoChat;
	private JTextField campoMensaje;
	private JLabel nick;
	private JComboBox<Usuario> comboBoxUsers;
	private JButton btnEnviar;
	
	private Cliente cliente;
	private Servidor socketReceptor;
	
	private Usuario emisor;
	private Usuario receptor;
	private Paquete datosEnvio;
	private Paquete datosRecepcion;
	
	private final String IPSERVIDOR = "192.168.1.133";
	
	
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
		this.datosEnvio = new Paquete();
		this.datosRecepcion = new Paquete();
		
		initialize();		
	}
	
	
	private void initialize() {
		
		String nick_usuario = JOptionPane.showInputDialog("Nick: ");
		
		this.emisor = new Usuario(nick_usuario);
		
		
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 400, 700);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		this.campoChat = new JTextArea();
		campoChat.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.campoChat.setBounds(27, 93, 342, 346);
		this.frame.getContentPane().add(this.campoChat);
		
		this.nick = new JLabel("");
		this.nick.setText(nick_usuario);
		this.nick.setFont(new Font("Dialog", Font.BOLD, 14));
		this.nick.setBounds(27, 43, 140, 24);
		this.frame.getContentPane().add(this.nick);
		
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
		
		this.comboBoxUsers = new JComboBox<Usuario>();
		this.comboBoxUsers.setFont(new Font("Dialog", Font.BOLD, 14));
		this.comboBoxUsers.setBounds(178, 43, 210, 24);
		this.frame.getContentPane().add(this.comboBoxUsers);
				
		
		Thread h = new Thread(this);
		h.start();
		
		
		this.frame.addWindowListener(new AvisaOnline());
	}
	
	
	@Override
	public void run() {
		
		this.socketReceptor = new Servidor(9090);
		
		try {		
			do {
				this.socketReceptor.abrir();

				this.datosRecepcion = (Paquete) this.socketReceptor.getObjetoEntrada().readObject();
				
				if (!(this.datosRecepcion.getMensaje().equals("     ONLINE") || this.datosRecepcion.getMensaje().equals("     OFFLINE"))) {
					this.campoChat.append("\n" + this.datosRecepcion.getEmisor().getNick() + " a " + this.datosRecepcion.getReceptor().getNick() + ": " + this.datosRecepcion.getMensaje());
				}
				else {
					this.comboBoxUsers.removeAllItems();
					
					for (Usuario usuario: this.datosRecepcion.getUsuariosOnline()) {
						
						if(!(usuario.getIp().equals(Network.getFirstNonLoopbackAddress(true, false).getHostAddress()))) {
							this.comboBoxUsers.addItem(usuario);					}					
						}
					}

				this.socketReceptor.cerrar();
				
			} while(true);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private class EnviaTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			receptor = (Usuario) (comboBoxUsers.getSelectedItem());
			
			
			campoChat.append("\n" + nick.getText() + " a " + receptor.getNick() + ": " + campoMensaje.getText());	
			
						
			datosEnvio.setEmisor(emisor);
			datosEnvio.setReceptor(receptor);
			datosEnvio.setMensaje(campoMensaje.getText());
			

			campoMensaje.setText("");
			
			try {
				cliente = new Cliente(IPSERVIDOR);
				
				cliente.getObjetoSalida().writeObject(datosEnvio);
				
				cliente.cerrar();
				
			} catch (UnknownHostException e1) {
				System.out.println(e1.getMessage());
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
	
	
	
	private class AvisaOnline extends WindowAdapter {
		
		@Override
		public void windowOpened(WindowEvent e) {
	
			try {
				Socket online = new Socket(IPSERVIDOR, 9999);
				
				Paquete userOnline = new Paquete();
				userOnline.setEmisor(new Usuario(nick.getText()));
				userOnline.setMensaje("     ONLINE");
				
				ObjectOutputStream oos = new ObjectOutputStream(online.getOutputStream());
				oos.writeObject(userOnline);
				
				
				oos.close();
				online.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		@Override public void windowClosing(WindowEvent e) {
			
			try {
				Socket online = new Socket(IPSERVIDOR, 9999);
				
				Paquete userOnline = new Paquete();
				userOnline.setEmisor(new Usuario(nick.getText()));
				userOnline.setMensaje("     OFFLINE");
				
				ObjectOutputStream oos = new ObjectOutputStream(online.getOutputStream());
				oos.writeObject(userOnline);
				
				
				oos.close();
				online.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}		
		}
	}
}