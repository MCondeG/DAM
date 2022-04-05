package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import modelo.ListaUsuarios;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Pantalla {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private ListaUsuarios usuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.usuarios = new ListaUsuarios();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(166, 178, 135, 39);
		btnEnviar.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				usuarios.añadirUsuario(textField.getText(), passwordField.getText());
			}
		});
		
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnEnviar);
		
		JLabel lblNewLabel1 = new JLabel("Usuario");
		lblNewLabel1.setBounds(46, 60, 100, 20);
		frame.getContentPane().add(lblNewLabel1);
		
		JLabel lblNewLabel2 = new JLabel("Contraseña");
		lblNewLabel2.setBounds(46, 100, 100, 20);
		frame.getContentPane().add(lblNewLabel2);
		
		textField = new JTextField();
		textField.setBounds(150, 60, 170, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setText("");
		passwordField.setBounds(150, 100, 170, 20);
		frame.getContentPane().add(passwordField);
	}
}