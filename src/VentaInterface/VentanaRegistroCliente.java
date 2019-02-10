package VentaInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import VentaLogica.Cliente;
import VentaLogica.Compra;

import javax.swing.JButton;

public class VentanaRegistroCliente implements ActionListener{

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtIdentificacion;
	private JTextField txtDireccion;
	private JTextField txtFechaNacimiento;
	private JTextField txtEmail;
	private JButton btnGuardar;
	private Compra miC;

	
	public VentanaRegistroCliente(Compra miCompra) {

		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		miC = miCompra;
		
		JLabel lblRegistroDeCliente = new JLabel("REGISTRO DE CLIENTE");
		lblRegistroDeCliente.setBounds(135, 12, 172, 15);
		frame.getContentPane().add(lblRegistroDeCliente);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(12, 54, 70, 15);
		frame.getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(12, 81, 70, 15);
		frame.getContentPane().add(lblApellidos);
		
		JLabel lblIdentificacion = new JLabel("Identificacion:\n");
		lblIdentificacion.setBounds(12, 108, 139, 15);
		frame.getContentPane().add(lblIdentificacion);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(12, 135, 70, 15);
		frame.getContentPane().add(lblDireccion);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(12, 162, 181, 15);
		frame.getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(12, 185, 150, 15);
		frame.getContentPane().add(lblCorreoElectronico);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(225, 52, 203, 19);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(225, 79, 203, 19);
		frame.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(225, 106, 203, 19);
		frame.getContentPane().add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(225, 133, 203, 19);
		frame.getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setText("DD/MM/AAAA\n");
		txtFechaNacimiento.setBounds(225, 160, 203, 19);
		frame.getContentPane().add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(225, 183, 203, 19);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(168, 233, 117, 25);
		btnGuardar.addActionListener(this);
		frame.getContentPane().add(btnGuardar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnGuardar) {
			Cliente c = new Cliente(txtIdentificacion.getText(), txtNombre.getText(), txtApellido.getText(), txtDireccion.getText(), txtEmail.getText(), txtFechaNacimiento.getText());
			miC.agregraCliente(c);
		}
	}
}
