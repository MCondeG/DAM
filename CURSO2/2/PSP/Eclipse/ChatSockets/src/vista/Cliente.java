package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;


public class Cliente {

	private JFrame frame;
	private JTextField textField;
	private JButton btnEnviar;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Cliente() {
		initialize();
	}
	
	
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 700, 400);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCliente.setBounds(300, 12, 100, 15);
		this.frame.getContentPane().add(lblCliente);
		
		this.textField = new JTextField();
		this.textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.textField.setBounds(87, 148, 522, 41);
		this.frame.getContentPane().add(this.textField);
		this.textField.setColumns(10);
		
		this.btnEnviar = new JButton("Enviar");
		this.btnEnviar.setBounds(293, 235, 117, 41);
		EnviaTexto evento = new EnviaTexto();
		this.btnEnviar.addActionListener(evento);
		this.frame.getContentPane().add(this.btnEnviar);
	}
	
	
	private class EnviaTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				Socket s = new Socket("127.0.0.1", 9999);
				
				DataOutputStream flujo_salida = new DataOutputStream(s.getOutputStream());
				flujo_salida.writeUTF(textField.getText());
			} catch (UnknownHostException e1) {
				System.out.println(e1.getMessage());
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
}