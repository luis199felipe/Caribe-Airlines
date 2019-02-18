package VentaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaRegistroTarjeta {

	private JFrame frame;

	

	/**
	 * Create the application.
	 */
	public VentanaRegistroTarjeta() {
		
	
		frame = new JFrame();
		frame.setBounds(100, 100, 321, 381);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JRadioButton rdbtnTarjetaDebito = new JRadioButton("Tarjeta Debito");
		rdbtnTarjetaDebito.setBounds(26, 49, 652, 23);
		frame.getContentPane().add(rdbtnTarjetaDebito);
		
		JRadioButton rdbtnTarjetaCredito = new JRadioButton("Tarjeta credito");
		rdbtnTarjetaCredito.setBounds(26, 86, 149, 23);
		frame.getContentPane().add(rdbtnTarjetaCredito);
		
		JTextField textField = new JTextField();
		textField.setBounds(26, 164, 265, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIngreseElNumero = new JLabel("Ingrese el numero de la tarjeta ");
		lblIngreseElNumero.setBounds(26, 128, 277, 15);
		frame.getContentPane().add(lblIngreseElNumero);
		
		JLabel lblIngreseLaFecha = new JLabel("Ingrese la fecha");
		lblIngreseLaFecha.setBounds(26, 206, 125, 15);
		frame.getContentPane().add(lblIngreseLaFecha);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(179, 204, 112, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIngreseElCodigo = new JLabel("codigo de seguridad");
		lblIngreseElCodigo.setBounds(26, 243, 265, 15);
		frame.getContentPane().add(lblIngreseElCodigo);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(179, 241, 112, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(98, 314, 117, 25);
		frame.getContentPane().add(btnGuardar);
		
		JLabel lblAgregarModoDe = new JLabel("Agregar Modo de pago");
		lblAgregarModoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarModoDe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAgregarModoDe.setBounds(28, 12, 263, 29);
		frame.getContentPane().add(lblAgregarModoDe);
	}
}
