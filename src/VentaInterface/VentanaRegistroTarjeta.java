package VentaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import VentaLogica.Compra;
import VentaLogica.Tarjeta;

public class VentanaRegistroTarjeta implements ActionListener{

	private JFrame frame;
	private JRadioButton rdbtnTarjetaDebito,rdbtnTarjetaCredito;
	private JButton btnGuardar ;
	private JTextField fecha,numero,codigo;
	private JLabel lblCupoDisponibles;
	private JTextField txtCupo;
	private String miUsuario;
	private Compra miCompra;

	/**
	 * Create the application.
	 */
	public VentanaRegistroTarjeta(String iden,Compra c) {
		
		miUsuario = iden;
		miCompra = c;
		frame = new JFrame();
		frame.setBounds(100, 100, 321, 381);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		ButtonGroup BGTipo = new ButtonGroup(); 
		
		rdbtnTarjetaDebito = new JRadioButton("Tarjeta Debito");
		rdbtnTarjetaDebito.setBounds(26, 49, 652, 23);
		BGTipo.add(rdbtnTarjetaDebito);
		frame.getContentPane().add(rdbtnTarjetaDebito);
		
		rdbtnTarjetaCredito = new JRadioButton("Tarjeta credito");
		rdbtnTarjetaCredito.setBounds(26, 86, 149, 23);
		BGTipo.add(rdbtnTarjetaCredito);
		frame.getContentPane().add(rdbtnTarjetaCredito);
		
		numero = new JTextField();
		numero.setBounds(26, 164, 265, 19);
		frame.getContentPane().add(numero);
		numero.setColumns(10);
		
		JLabel lblIngreseElNumero = new JLabel("Ingrese el numero de la tarjeta ");
		lblIngreseElNumero.setBounds(26, 128, 277, 15);
		frame.getContentPane().add(lblIngreseElNumero);
		
		JLabel lblIngreseLaFecha = new JLabel("Ingrese la fecha");
		lblIngreseLaFecha.setBounds(26, 206, 125, 15);
		frame.getContentPane().add(lblIngreseLaFecha);
		
		fecha = new JTextField();
		fecha.setBounds(179, 204, 112, 19);
		frame.getContentPane().add(fecha);
		fecha.setColumns(10);
		
		JLabel lblIngreseElCodigo = new JLabel("codigo de seguridad");
		lblIngreseElCodigo.setBounds(26, 243, 149, 15);
		frame.getContentPane().add(lblIngreseElCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(179, 241, 112, 19);
		frame.getContentPane().add(codigo);
		codigo.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(98, 314, 117, 25);
		btnGuardar.addActionListener(this);
		frame.getContentPane().add(btnGuardar);
		
		JLabel lblAgregarModoDe = new JLabel("Agregar Modo de pago");
		lblAgregarModoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarModoDe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAgregarModoDe.setBounds(28, 12, 263, 29);
		frame.getContentPane().add(lblAgregarModoDe);
		
		lblCupoDisponibles = new JLabel("Cupo disponibles");
		lblCupoDisponibles.setBounds(36, 270, 125, 15);
		frame.getContentPane().add(lblCupoDisponibles);
		
		txtCupo = new JTextField();
		txtCupo.setBounds(179, 272, 114, 19);
		frame.getContentPane().add(txtCupo);
		txtCupo.setColumns(10);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnGuardar) {
			String tipo="";
			if (rdbtnTarjetaCredito.isSelected()) {
				tipo="credito";
			}else {
				tipo="debito";
			}
			Tarjeta t = new Tarjeta(tipo, Double.parseDouble(txtCupo.getText()),miUsuario, numero.getText(), fecha.getText(), codigo.getText());
			miCompra.agregarTarjeta(t);
			JOptionPane.showMessageDialog(null, "Tarjeta agregada correctamente");
			frame.setVisible(false);
		}	
	}
}