package mundoInterace;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import mundo.CaribeAirlines;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextPane;

public class VentanaConsultas implements ActionListener {

	private JFrame frame;
	private JButton btnPunto_2, btnPunto, btnPunto_3, btnPunto_4;
	private CaribeAirlines aerolinea;
	private JTextPane txtPunto4, txtPunto1, txtPunto3 ,txtPunto2; 
	
	
	public VentanaConsultas(CaribeAirlines ae) {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 417);
		frame.getContentPane().setLayout(null);
		aerolinea=ae;
		
		
		JLabel lblRequisitosFuncionales = new JLabel("REQUISITOS FUNCIONALES");
		lblRequisitosFuncionales.setFont(new Font("Dialog", Font.BOLD, 22));
		lblRequisitosFuncionales.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequisitosFuncionales.setBounds(0, 12, 727, 44);
		frame.getContentPane().add(lblRequisitosFuncionales);

		btnPunto = new JButton("Punto 1");
		btnPunto.setBounds(34, 84, 117, 25);
		btnPunto.addActionListener(this);
		frame.getContentPane().add(btnPunto);

		btnPunto_2 = new JButton("Punto 2");
		btnPunto_2.setBounds(34, 171, 117, 25);
		btnPunto_2.addActionListener(this);
		frame.getContentPane().add(btnPunto_2);

		btnPunto_3 = new JButton("Punto 3");
		btnPunto_3.setBounds(34, 262, 117, 25);
		btnPunto_3.addActionListener(this);
		frame.getContentPane().add(btnPunto_3);

		btnPunto_4 = new JButton("Punto 4");
		btnPunto_4.setBounds(34, 326, 117, 25);
		btnPunto_4.addActionListener(this);
		frame.getContentPane().add(btnPunto_4);

		txtPunto1 = new JTextPane();
		txtPunto1.setText(
				"Buscar un determinado cliente y mostrar la siguiente información: cantidad de vuelos que ha realizado, peso total de equipaje por todos los vuelos, pago total por equipaje adicional para todos los vuelos, pago total realizado por mascota para todos los vuelos, clase en la cual más ha viajado históricamente, horas totales de vuelo y cuál ha sido el tipo de tarjeta (débito o crédito) que más ha usado para hacer la compra del tiquete.");
		txtPunto1.setBounds(176, 51, 551, 91);
		frame.getContentPane().add(txtPunto1);

		txtPunto2 = new JTextPane();
		txtPunto2.setText(
				"Mostrar para un determinado avión, cual es la silla que más ha sido utilizada en un rango de fechas.");
		txtPunto2.setBounds(176, 171, 551, 44);
		frame.getContentPane().add(txtPunto2);

		txtPunto3 = new JTextPane();
		txtPunto3.setText("Mostrar para un terminado avión, la siguiente información: hora total de horas de vuelo, pilotos y tripulación histórica, cantidad total de pasajeros de acuerdo a la categoría (ejecutiva y económica) y carga total trasportada.");
		txtPunto3.setBounds(176, 248, 551, 55);
		frame.getContentPane().add(txtPunto3);

		txtPunto4 = new JTextPane();
		
		txtPunto4.setText(
				"Ordenar y mostrar la información de los pilotos de acuerdo a la cantidad de horas de vuelo que hayan tenido en un determinado rango de fechas.");
		txtPunto4.setBounds(176, 315, 551, 61);
		frame.getContentPane().add(txtPunto4);
		frame.setVisible(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPunto) {
			System.out.println("LLEGO 0.1");
			String cedula = JOptionPane.showInputDialog("Ingrese la cedula del cliente que desea obtener la informacion");
			System.out.println("LLEGO 0.2");
			String impr = aerolinea.consulta1(cedula);
			
			
			
			txtPunto1.setText(impr);
		}
		if (e.getSource() == btnPunto_2) {
			txtPunto2.setText("");
		}
		if (e.getSource() == btnPunto_3) {
			String con3 = aerolinea.consulta3(JOptionPane.showInputDialog("Ingrese el nombre del avion"));
			txtPunto3.setText(con3);
		}
		if (e.getSource() == btnPunto_4) {
			txtPunto4.setText("");
		}
	}
}
