package hilos5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import hilos7.Directorio;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private Directorio directorio;
	private Hilo h;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		
		this.directorio =  new Directorio("src");
		this.h = new Hilo(this.directorio);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(104, 12, 224, 141);
		frame.getContentPane().add(textArea);
		
		JButton button1 = new JButton("START");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h.start();
			}
		});
		button1.setBounds(51, 201, 117, 25);
		frame.getContentPane().add(button1);
		
		JButton button2 = new JButton("STOP");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h.stop();
			}
		});
		button2.setBounds(263, 201, 117, 25);
		frame.getContentPane().add(button2);
	}
}
