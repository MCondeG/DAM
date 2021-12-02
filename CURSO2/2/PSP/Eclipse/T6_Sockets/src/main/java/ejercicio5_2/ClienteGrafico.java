package ejercicio5_2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class ClienteGrafico extends JFrame {

	private JPanel contentPane;
	private JTextField n1;
	private JTextField n2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGrafico frame = new ClienteGrafico();
					frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteGrafico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tit = new JLabel("Calculadora");
		tit.setBounds(66, 12, 128, 38);
		contentPane.add(tit);
		
		n1 = new JTextField();
		n1.setBounds(174, 75, 114, 19);
		contentPane.add(n1);
		n1.setColumns(10);
		
		n2 = new JTextField();
		n2.setBounds(174, 118, 114, 19);
		contentPane.add(n2);
		n2.setColumns(10);
		
		JLabel resul = new JLabel("");
		resul.setBounds(132, 230, 161, 29);
		contentPane.add(resul);
		
		JLabel lblNewLabel = new JLabel("Numero 1");
		lblNewLabel.setBounds(66, 77, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero 2");
		lblNewLabel_1.setBounds(66, 120, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton suma = new JButton("+");
		suma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numero1= n1.getText();
				String numero2= n2.getText();
				float num1=0, num2=0;
				String cadena="";
				if(!numero1.trim().equals("") || !numero1.isEmpty()) {
					num1=Float.parseFloat(numero1);
					num2=Float.parseFloat(numero2);
				}
				cadena= conectaServer(num1, num2, "+");
				resul.setText(cadena);
			}
		});
		suma.setBounds(39, 161, 117, 25);
		contentPane.add(suma);
		
		JButton resta = new JButton("-");
		resta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numero1= n1.getText();
				String numero2= n2.getText();
				float num1=0, num2=0;
				String cadena="";
				if(!numero1.trim().equals("") || !numero1.isEmpty()) {
					num1=Float.parseFloat(numero1);
					num2=Float.parseFloat(numero2);
				}
				cadena= conectaServer(num1, num2, "-");
				resul.setText(cadena);
			}
		});
		resta.setBounds(171, 161, 117, 25);
		contentPane.add(resta);
		
		JButton multiplica = new JButton("*");
		multiplica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numero1= n1.getText();
				String numero2= n2.getText();
				float num1=0, num2=0;
				String cadena="";
				if(!numero1.trim().equals("") || !numero1.isEmpty()) {
					num1=Float.parseFloat(numero1);
					num2=Float.parseFloat(numero2);
				}
				cadena= conectaServer(num1, num2, "*");
				resul.setText(cadena);
			}
		});
		multiplica.setBounds(171, 198, 117, 25);
		contentPane.add(multiplica);
		
		JButton divide = new JButton("/");
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numero1= n1.getText();
				String numero2= n2.getText();
				float num1=0, num2=0;
				String cadena="";
				if(!numero1.trim().equals("") || !numero1.isEmpty()) {
					num1=Float.parseFloat(numero1);
					num2=Float.parseFloat(numero2);
				}
				cadena= conectaServer(num1, num2, "/");
				resul.setText(cadena);
			}
		});
		divide.setBounds(39, 198, 117, 25);
		contentPane.add(divide);
	}

	
	public String conectaServer(float num1, float num2, String tipo) {
		final int PUERTO=5000;
		final String HOST="localhost";
		
		float res=0;
		
		DataInputStream dis;
		DataOutputStream dos;
		
		try {
			Socket socket=new Socket(HOST,PUERTO);
			
			dis=new DataInputStream(socket.getInputStream());
			dos=new DataOutputStream(socket.getOutputStream());
			
			dos.writeFloat(num1);
			dos.writeFloat(num2);
			dos.writeUTF(tipo);
			
			res=dis.readFloat();
			System.out.println(res);
			
			socket.close();
			
		}catch(IOException ex) {
			Logger.getLogger(ClienteGrafico.class.getName()).log(Level.SEVERE,null,ex);
		}
		return "El resultado es: "+res;
	}

	
	
}
