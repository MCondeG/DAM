package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import controlador.Log;
import controlador.Servidor;
import modelo.ListaUsuarios;
import modelo.Paquete;
import modelo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;


public class ServidorVentana implements Runnable {

	private JFrame frame;
	private JTextArea textArea;
	
	private Servidor servidor;
	
	private ListaUsuarios usuarios;
	private Paquete datos;
	
	private Log log;
	
	
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
		this.usuarios = new ListaUsuarios();
		this.datos = new Paquete();
		this.log = new Log("log.txt");
		
		initialize();		
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
		
		
		this.frame.addWindowListener(new CreaLog());
	}

	
	@Override
	public void run() {
		
		String ipEmisor, ipReceptor, mensaje;
		
		this.servidor = new Servidor(9999);

		try {
			do {
				this.servidor.abrir();
				
				
				this.datos = (Paquete) this.servidor.getObjetoEntrada().readObject();
				
				ipEmisor = this.datos.getEmisor().getIp();
				mensaje = this.datos.getMensaje();
				
								
				if (this.usuarios.buscarUsuario(ipEmisor)) {
					
					if (this.datos.getMensaje().equals("     OFFLINE")) {
						this.usuarios.eliminar(this.datos.getEmisor());
						
						for(Usuario u: this.usuarios.getUsuarios()) {
								System.out.println(u.toString());
						}
						this.actualizaLista();
						
						String texto = "\n" + ipEmisor + mensaje;
						this.textArea.append(texto);
					}
					else {
						
						ipReceptor = this.datos.getReceptor().getIp();
						
						Socket socketEmisor = new Socket(ipReceptor, 9090);
						ObjectOutputStream oos = new ObjectOutputStream(socketEmisor.getOutputStream());		
						oos.writeObject(this.datos);
						
						
						String texto = "\nMensaje redirigido de:   " + ipEmisor + "     a:   " + ipReceptor;
						this.textArea.append(texto);
					}
				}
				else {
					this.usuarios.añadir(this.datos.getEmisor());
					
					this.actualizaLista();
					
					
					String texto = "\n" + ipEmisor + mensaje;
					this.textArea.append(texto);
				}
				
				this.servidor.cerrar();
					
			} while(true);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	
	private void actualizaLista() throws UnknownHostException, IOException {
		
		for (Usuario usuario: this.usuarios.getUsuarios()) {
			
			this.datos.setUsuariosOnline(this.usuarios.getUsuarios());
			
			Socket enviaLista = new Socket(usuario.getIp(), 9090);	
			ObjectOutputStream oos = new ObjectOutputStream(enviaLista.getOutputStream());		
			oos.writeObject(this.datos);
									
			
			oos.close();
			enviaLista.close();
		}
	}
	
	
	
	private class CreaLog extends WindowAdapter {
		
		@Override
		public void windowClosing(WindowEvent e) {
	
			try {
				log.escribirLog(textArea.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}