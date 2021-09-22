package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import modelo.*;
import control.*;
import javax.swing.SwingConstants;
import java.awt.Font;


public class Menu extends JFrame {		// interfaz gráfica. Clase MAIN

	private JPanel contentPane;
	private JTextField dia;
	private JTextField mes;
	private JTextField año;
	private JTextField hora;
	
	private static ListaPistas pistas;
	private static Util u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		pistas = new ListaPistas();
		u = new Util();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 260, 351, 263);
		
		JLabel lblNewLabel_1 = new JLabel("D\u00CDA");
		lblNewLabel_1.setBounds(55, 76, 33, 14);
		
		JLabel lblNewLabel_2 = new JLabel("MES");
		lblNewLabel_2.setBounds(134, 76, 32, 14);
		
		JLabel lblNewLabel_3 = new JLabel("A\u00D1O");
		lblNewLabel_3.setBounds(210, 76, 33, 14);
		
		JLabel lblNewLabel_4 = new JLabel("HORA");
		lblNewLabel_4.setBounds(286, 76, 41, 14);
		
		dia = new JTextField();
		dia.setBounds(47, 101, 41, 20);
		dia.setColumns(10);
		
		mes = new JTextField();
		mes.setBounds(127, 101, 41, 20);
		mes.setColumns(10);
		
		año = new JTextField();
		año.setBounds(202, 101, 45, 20);
		año.setColumns(10);
		
		hora = new JTextField();
		hora.setBounds(280, 101, 45, 20);
		hora.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(194, 150, 32, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		
		JLabel lblNewLabel_5 = new JLabel("    Pista");
		lblNewLabel_5.setBounds(137, 153, 47, 14);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(dia);
		contentPane.add(mes);
		contentPane.add(año);
		contentPane.add(lblNewLabel_5);
		contentPane.add(comboBox);
		contentPane.add(hora);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int codError;
				int numPista = comboBox.getSelectedIndex();
				
				if (!(hora.getText().isBlank() || dia.getText().isBlank() || mes.getText().isBlank() || año.getText().isBlank())) {
					Fecha f = new Fecha(Integer.parseInt(hora.getText()), Integer.parseInt(dia.getText()), Integer.parseInt(mes.getText()), Integer.parseInt(año.getText()));
					codError = pistas.getLp()[numPista].añadirReserva(f);
				}
				else codError = 3;
				
				switch (codError) {
				case 0:
					textArea.setText("Reserva realizada con éxito");
					break;
				case 1:
					textArea.setText("ERROR. Formato de fecha/hora incorrecto");
					break;
				case 2:
					textArea.setText("ERROR. Fecha/hora previamente reservada");
					break;
				case 3:
					textArea.setText("ERROR. Debe rellenar todos los campos");
					break;
				default:
					textArea.setText("ERROR DESCONOCIDO");
					break;
				}
			}
		});
		btnNewButton.setBounds(34, 196, 90, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Listar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int numPista = comboBox.getSelectedIndex();
				
				
				if (!(mes.getText().isBlank())) {
					
					int numMes = Integer.parseInt(mes.getText());
					ArrayList<Fecha> reservas = pistas.getLp()[numPista].getReservas().getLf();
					ArrayList<Fecha> reservasFiltradas = u.filtrarMes(reservas, numMes);
					
					if (!(reservasFiltradas.isEmpty())) {
						
						textArea.setText("dia/mes/año\thora\n\n");
						
						for (int i = 0; i < reservasFiltradas.size(); i++) {
							
							textArea.append(reservasFiltradas.get(i).toString() + "\n");
						}
					}
					else textArea.setText("No existen reservas previas para dicho mes en la pista " + (numPista + 1));
				}
				else textArea.setText("ERROR. Debe seleccionar un mes para consultar reservas");
			}
		});
		btnNewButton_1.setBounds(256, 196, 90, 45);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("RESERVAS   PADEL");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(102, 11, 177, 36);
		contentPane.add(lblNewLabel);
	}
}
