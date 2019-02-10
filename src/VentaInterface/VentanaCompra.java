package VentaInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;
import VentaLogica.Cliente;
import VentaLogica.Compra;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;


public class VentanaCompra implements ActionListener{

	private JFrame panelCliente;
	
	
	private ButtonGroup BGModalidad,BGClase;
	private JComboBox<String> comboBoxCiudadDestino,comboBoxCiudadOrigen,comboBoxFechaSalida,comboBoxFechaRegreso;
	private JLabel lblFechaDeRegreso; 
	private JRadioButton RadioButtonIdaYRegreso,RadioButtonSoloIda,rdbtnEconomica,rdbtnEjecutiva;
	private JButton btnRegistro,btnCargarDatos;
	private JLabel nombre,direccion,fecha,correo;
	private Compra miCompra;
	private JTextField txtIdentificacion;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCompra window = new VentanaCompra();
					window.panelCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCompra() {

		panelCliente = new JFrame();
		panelCliente.setBounds(100, 100, 505, 361);
		panelCliente.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 11, 479, 312);
		panelCliente.getContentPane().add(tabbedPane);
		
		miCompra = new Compra();		
		HashSet<String> ciudades = miCompra.getCiudades();
		
		
		

		//PANEL CLIENTE********************************************************************************************
		JPanel panelCliente = new JPanel();
		tabbedPane.addTab("Cliente", null, panelCliente, null);
		panelCliente.setLayout(null);
		
		JLabel lblingreseSuNumero = new JLabel("<html>Ingrese su numero de documento en caso de que este registrado, sino por favor registre sus datos desde el boton registro.</html>");
		lblingreseSuNumero.setBounds(22, 6, 440, 80);
		panelCliente.add(lblingreseSuNumero);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(240, 98, 207, 19);
		panelCliente.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		btnRegistro = new JButton("REGISTRO");
		btnRegistro.setBounds(250, 248, 117, 25);
		btnRegistro.addActionListener(this);
		panelCliente.add(btnRegistro);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(12, 125, 70, 15);
		panelCliente.add(lblNombres);
		
		JLabel lblIdentificacion = new JLabel("Identificacion:\n");
		lblIdentificacion.setBounds(12, 100, 139, 15);
		panelCliente.add(lblIdentificacion);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(12, 152, 70, 15);
		panelCliente.add(lblDireccion);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(12, 179, 181, 15);
		panelCliente.add(lblFechaDeNacimiento);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(12, 206, 150, 15);
		panelCliente.add(lblCorreoElectronico);
		
		btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.setBounds(88, 248, 150, 25);
		btnCargarDatos.addActionListener(this);
		panelCliente.add(btnCargarDatos);
		
		nombre = new JLabel("");
		nombre.setBounds(239, 125, 208, 15);
		panelCliente.add(nombre);
		
		direccion = new JLabel("");
		direccion.setBounds(240, 152, 207, 15);
		panelCliente.add(direccion);
		
		fecha = new JLabel("");
		fecha.setBounds(240, 179, 207, 15);
		panelCliente.add(fecha);
		
		correo = new JLabel("");
		correo.setBounds(240, 206, 222, 15);
		panelCliente.add(correo);

		//PANEL MODALIDAD********************************************************************************************
		JPanel panelMod = new JPanel();
		tabbedPane.addTab("Modalidad", null, panelMod, null);
		panelMod.setLayout(null);
		
		BGModalidad = new ButtonGroup();
		
		RadioButtonIdaYRegreso = new JRadioButton("Ida y regreso");
		RadioButtonIdaYRegreso.setBounds(6, 32, 182, 23);
		BGModalidad.add(RadioButtonIdaYRegreso);
		RadioButtonIdaYRegreso.addActionListener(this);
		panelMod.add(RadioButtonIdaYRegreso);
				
		RadioButtonSoloIda = new JRadioButton("Solo ida");
		RadioButtonSoloIda.setBounds(6, 58, 109, 23);
		BGModalidad.add(RadioButtonSoloIda);
		RadioButtonSoloIda.addActionListener(this);
		panelMod.add(RadioButtonSoloIda);
		
		JLabel lblEscojaSuModalidad = new JLabel("Escoja su modalidad de viaje:");
		lblEscojaSuModalidad.setBounds(10, 11, 289, 14);
		panelMod.add(lblEscojaSuModalidad);
		
		
		
		
		// PANEL CIUDAD********************************************************************************************
		JPanel panelCiudad = new JPanel();
		tabbedPane.addTab("Ciudad", null, panelCiudad, null);
		panelCiudad.setLayout(null);
		
		JLabel lblCiudadOrigen = new JLabel("Ciudad Origen");
		lblCiudadOrigen.setBounds(10, 54, 133, 17);
		panelCiudad.add(lblCiudadOrigen);
		
		comboBoxCiudadOrigen = new JComboBox();
		comboBoxCiudadOrigen.setBounds(222, 52, 169, 20);
		panelCiudad.add(comboBoxCiudadOrigen);
		
		
		JLabel lblCiudadDestino = new JLabel("Ciudad Destino");
		lblCiudadDestino.setBounds(10, 83, 147, 14);
		panelCiudad.add(lblCiudadDestino);
		
		comboBoxCiudadDestino = new JComboBox();
		comboBoxCiudadDestino.setBounds(222, 80, 169, 20);
		Iterator<String> it = ciudades.iterator();
		
		while (it.hasNext()) {
			String c = it.next();
			comboBoxCiudadDestino.addItem(c);
			comboBoxCiudadOrigen.addItem(c);
		}
		comboBoxCiudadDestino.setSelectedIndex(1);
		comboBoxCiudadDestino.addActionListener(this);
		comboBoxCiudadOrigen.addActionListener(this);
		panelCiudad.add(comboBoxCiudadDestino);
		
		JLabel lblEscojaLaCiudad = new JLabel("Escoja la ciudad de origen y para donde se dirige.");
		lblEscojaLaCiudad.setBounds(24, 12, 381, 14);
		panelCiudad.add(lblEscojaLaCiudad);
		
		JTextPane txtpnTengaEnCuenta = new JTextPane();
		txtpnTengaEnCuenta.setText("Tenga en cuenta de que para vuelos nacionales tendr\u00E1 un coste adicional del 0.8% e internacional del 0.97%");
		txtpnTengaEnCuenta.setBounds(10, 121, 381, 60);
		panelCiudad.add(txtpnTengaEnCuenta);
		
		
		
		//PANEL CLASE ********************************************************************************************
		JPanel panelClase = new JPanel();
		tabbedPane.addTab("Clase", null, panelClase, null);
		panelClase.setLayout(null);
		
		BGClase =new ButtonGroup();
		
		rdbtnEconomica = new JRadioButton("Economica");
		rdbtnEconomica.setBounds(10, 35, 109, 23);
		BGClase.add(rdbtnEconomica);
		panelClase.add(rdbtnEconomica);
		
		rdbtnEjecutiva = new JRadioButton("Ejecutiva");
		rdbtnEjecutiva.setBounds(10, 61, 109, 23);
		BGClase.add(rdbtnEjecutiva);
		panelClase.add(rdbtnEjecutiva);
		
		JLabel lblEscojaLaClase = new JLabel("Escoja la clase preferente del viaje.");
		lblEscojaLaClase.setBounds(10, 11, 395, 14);
		panelClase.add(lblEscojaLaClase);
		
		
		
		//PANEL FECHAS********************************************************************************************
		JPanel panelFechas = new JPanel();
		tabbedPane.addTab("Fechas", null, panelFechas, null);
		panelFechas.setLayout(null);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida (DD/MM/AAAA)");
		lblFechaDeSalida.setBounds(17, 32, 223, 14);
		panelFechas.add(lblFechaDeSalida);
		
		lblFechaDeRegreso = new JLabel("Fecha de regreso (DD/MM/AAAA)");
		lblFechaDeRegreso.setBounds(10, 67, 230, 14);
		panelFechas.add(lblFechaDeRegreso);
		
		comboBoxFechaSalida = new JComboBox();
		comboBoxFechaSalida.setBounds(258, 29, 147, 20);
		panelFechas.add(comboBoxFechaSalida);
		
		comboBoxFechaRegreso = new JComboBox();
		comboBoxFechaRegreso.setBounds(258, 64, 147, 20);
		panelFechas.add(comboBoxFechaRegreso);
		
		
		//PANEL FECHAS********************************************************************************************
		JPanel panelEquipaje = new JPanel();
		tabbedPane.addTab("Equipaje", null, panelEquipaje , null);
		panelEquipaje.setLayout(null);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnCargarDatos) {
			Cliente c = miCompra.getCliente(txtIdentificacion.getText());
			if (c!=null) {
				nombre.setText(c.getNombre()+" "+c.getApellido());
				direccion.setText(c.getDireccion());
				fecha.setText(c.getFechaNacimiento());
				correo.setText(c.getEmail());
			}else {
				JOptionPane.showMessageDialog(null, "No existe el usuario");
			}
		}
		if (e.getSource() == btnRegistro) {
			VentanaRegistroCliente vrc = new VentanaRegistroCliente(miCompra);
			
		}
		
		
		if (e.getSource()==RadioButtonSoloIda) {
			comboBoxFechaRegreso.hide();
			lblFechaDeRegreso.hide();
		}
		if(e.getSource()==RadioButtonIdaYRegreso) {
			comboBoxFechaRegreso.show();
			lblFechaDeRegreso.show();
		}
		
		if (e.getSource() == comboBoxCiudadOrigen) {
			if (!comboBoxCiudadOrigen.getSelectedItem().equals("CDMX")) {
				comboBoxCiudadDestino.setSelectedIndex(0);
				comboBoxCiudadDestino.disable();
			}else {
				comboBoxCiudadDestino.enable();
				comboBoxCiudadDestino.setSelectedIndex(1);
			}
		}
		
		if (e.getSource()==comboBoxCiudadDestino) {
			
			List<String> fechasSalida = miCompra.getFechasDeCiudad(String.valueOf(comboBoxCiudadDestino.getSelectedItem()));			
			Iterator<String> it = fechasSalida.iterator();
			while (it.hasNext()) {
				String f = it.next();
				comboBoxFechaSalida.addItem(f);
				comboBoxFechaRegreso.addItem(f);
			}
		}
	}
}
