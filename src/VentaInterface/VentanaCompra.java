package VentaInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
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

import com.toedter.calendar.JDateChooser;

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
	 
	private JRadioButton RadioButtonIdaYRegreso,RadioButtonSoloIda,rdbtnEconomica,rdbtnEjecutiva;
	private JButton btnRegistro,btnCargarDatos,btnVerDisponibilidad ;
	private JLabel nombre,direccion,fecha,correo;
	private Compra miCompra;
	private JTabbedPane tabbedPane;
	
	private JDateChooser fechaSalida,fechaRegreso;
	private JTextField txtIdentificacion;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	

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
		panelCliente.setBounds(100, 100, 746, 485);
		panelCliente.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 11, 711, 432);
		panelCliente.getContentPane().add(tabbedPane);
		
		miCompra = new Compra();		
		
		
		
		
		// ***********************************************PANEL VIAJE********************************************************************************************
		JPanel panelViaje = new JPanel();
		tabbedPane.addTab("Viaje", null, panelViaje, null);
		panelViaje.setLayout(null);
		
		JLabel lblEscojaLaCiudad = new JLabel("Escoja la ciudad de origen y para donde se dirige.");
		lblEscojaLaCiudad.setBounds(10, 12, 381, 14);
		panelViaje.add(lblEscojaLaCiudad);
		
		JLabel lblCiudadOrigen = new JLabel("Ciudad Origen");
		lblCiudadOrigen.setBounds(10, 38, 133, 17);
		panelViaje.add(lblCiudadOrigen);
		
		comboBoxCiudadOrigen = new JComboBox();
		comboBoxCiudadOrigen.setBounds(193, 38, 169, 20);
		panelViaje.add(comboBoxCiudadOrigen);
		
		
		JLabel lblCiudadDestino = new JLabel("Ciudad Destino");
		lblCiudadDestino.setBounds(10, 83, 147, 14);
		panelViaje.add(lblCiudadDestino);
		
		comboBoxCiudadDestino = new JComboBox();
		comboBoxCiudadDestino.setBounds(193, 80, 169, 20);
		
		comboBoxCiudadDestino.addActionListener(this);
		comboBoxCiudadOrigen.addActionListener(this);
		
		ArrayList<String> ciudades = new ArrayList<String>();
		ciudades.add("CDMX");
		ciudades.add("Cancun");
		ciudades.add("Panama");
		ciudades.add("Los Angeles");
		ciudades.add("Buenos Aires");
		ciudades.add("Moterrey");
		ciudades.add("Bogotá");
		Iterator<String> it = ciudades.iterator();
		while (it.hasNext()) {
			String c = it.next();
			comboBoxCiudadDestino.addItem(c);
			comboBoxCiudadOrigen.addItem(c);
		}
		panelViaje.add(comboBoxCiudadDestino);
		
		
		
		
		JTextPane txtpnTengaEnCuenta = new JTextPane();
		txtpnTengaEnCuenta.setText("Tenga en cuenta de que para vuelos nacionales tendr\u00E1 un coste adicional del 0.8% e internacional del 0.97%");
		txtpnTengaEnCuenta.setBounds(10, 121, 352, 60);
		panelViaje.add(txtpnTengaEnCuenta);
		
		
		
		//CLASE ********
		BGModalidad = new ButtonGroup();
		
		RadioButtonIdaYRegreso = new JRadioButton("Ida y regreso");
		RadioButtonIdaYRegreso.setBounds(8, 224, 182, 23);
		BGModalidad.add(RadioButtonIdaYRegreso);
		RadioButtonIdaYRegreso.addActionListener(this);
		panelViaje.add(RadioButtonIdaYRegreso);
				
		RadioButtonSoloIda = new JRadioButton("Solo ida");
		RadioButtonSoloIda.setBounds(10, 251, 109, 23);
		BGModalidad.add(RadioButtonSoloIda);
		RadioButtonSoloIda.addActionListener(this);
		panelViaje.add(RadioButtonSoloIda);
		
		JLabel lblEscojaSuModalidad = new JLabel("Escoja su modalidad de viaje:");
		lblEscojaSuModalidad.setBounds(10, 202, 289, 14);
		panelViaje.add(lblEscojaSuModalidad);
		
		BGClase =new ButtonGroup();
		
		rdbtnEconomica = new JRadioButton("Economica");
		rdbtnEconomica.setBounds(10, 307, 109, 23);
		BGClase.add(rdbtnEconomica);
		panelViaje.add(rdbtnEconomica);
		
		rdbtnEjecutiva = new JRadioButton("Ejecutiva");
		rdbtnEjecutiva.setBounds(10, 334, 109, 23);
		rdbtnEconomica.addActionListener(this);
		rdbtnEjecutiva.addActionListener(this);
		BGClase.add(rdbtnEjecutiva);
		panelViaje.add(rdbtnEjecutiva);
		
		JLabel lblEscojaLaClase = new JLabel("Escoja la clase preferente del viaje.");
		lblEscojaLaClase.setBounds(10, 285, 395, 14);
		panelViaje.add(lblEscojaLaClase);
		
		
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida (DD/MM/AAAA)");
		lblFechaDeSalida.setBounds(471, 12, 223, 14);
		panelViaje.add(lblFechaDeSalida);
		
		JLabel lblFechaDeRegreso = new JLabel("Fecha de regreso (DD/MM/AAAA)");
		lblFechaDeRegreso.setBounds(464, 83, 230, 14);
		panelViaje.add(lblFechaDeRegreso);
		
		fechaSalida = new JDateChooser();
		fechaSalida.setBounds(481, 38, 209, 20);
		panelViaje.add(fechaSalida);
		
		fechaRegreso = new JDateChooser();
		fechaRegreso .setBounds(485, 110, 209, 20);
		panelViaje.add(fechaRegreso );
		
		btnVerDisponibilidad = new JButton("Ver disponibilidad de vuelos");
		btnVerDisponibilidad.setBounds(440, 250, 254, 49);
		btnVerDisponibilidad.addActionListener(this);
		panelViaje.add(btnVerDisponibilidad);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(440, 307, 254, 50);
		panelViaje.add(btnContinuar);
		
		
		
		
		
		//PANEL Equipaje********************************************************************************************
		JPanel panelEquipaje = new JPanel();
		tabbedPane.addTab("Equipaje", null, panelEquipaje , null);
		panelEquipaje.setLayout(null);
		tabbedPane.setEnabledAt(1,false);
		
		JButton btnAgregarMaleta = new JButton("Agregar Maleta");
		btnAgregarMaleta.setBounds(12, 168, 207, 25);
		panelEquipaje.add(btnAgregarMaleta);
		
		JLabel lblMaleta = new JLabel("Maleta #: 1");
		lblMaleta.setBounds(12, 25, 121, 15);
		panelEquipaje.add(lblMaleta);
		
		textField_4 = new JTextField();
		textField_4.setBounds(12, 79, 200, 19);
		panelEquipaje.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDimensionesAlturaanchoalto = new JLabel("Dimensiones: altura*ancho*alto");
		lblDimensionesAlturaanchoalto.setBounds(12, 52, 251, 15);
		panelEquipaje.add(lblDimensionesAlturaanchoalto);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(12, 110, 70, 15);
		panelEquipaje.add(lblPeso);
		
		textField_5 = new JTextField();
		textField_5.setBounds(12, 137, 207, 19);
		panelEquipaje.add(textField_5);
		textField_5.setColumns(10);
		
		
		

		//PANEL CLIENTE********************************************************************************************
		JPanel panelCliente_1 = new JPanel();
		tabbedPane.addTab("Cliente", null, panelCliente_1, null);
		panelCliente_1.setLayout(null);
		
		JLabel lblingreseSuNumero = new JLabel("<html>Ingrese su numero de documento en caso de que este registrado, sino por favor registre sus datos desde el boton registro.</html>");
		lblingreseSuNumero.setBounds(23, 6, 375, 80);
		panelCliente_1.add(lblingreseSuNumero);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(191, 98, 207, 19);
		panelCliente_1.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		btnRegistro = new JButton("REGISTRO");
		btnRegistro.setBounds(191, 233, 117, 25);
		btnRegistro.addActionListener(this);
		panelCliente_1.add(btnRegistro);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(12, 125, 70, 15);
		panelCliente_1.add(lblNombres);
		
		JLabel lblIdentificacion = new JLabel("Identificacion:\n");
		lblIdentificacion.setBounds(12, 100, 139, 15);
		panelCliente_1.add(lblIdentificacion);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(12, 152, 70, 15);
		panelCliente_1.add(lblDireccion);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(12, 179, 181, 15);
		panelCliente_1.add(lblFechaDeNacimiento);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(12, 206, 150, 15);
		panelCliente_1.add(lblCorreoElectronico);
		
		btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.setBounds(22, 233, 150, 25);
		btnCargarDatos.addActionListener(this);
		panelCliente_1.add(btnCargarDatos);
		
		nombre = new JLabel("");
		nombre.setBounds(190, 129, 208, 15);
		panelCliente_1.add(nombre);
		
		direccion = new JLabel("");
		direccion.setBounds(191, 152, 207, 15);
		panelCliente_1.add(direccion);
		
		fecha = new JLabel("");
		fecha.setBounds(191, 179, 207, 15);
		panelCliente_1.add(fecha);
		
		correo = new JLabel("");
		correo.setBounds(191, 206, 222, 15);
		panelCliente_1.add(correo);
		
		
		
		JRadioButton rdbtnTarjetaDebito = new JRadioButton("Tarjeta Debito");
		rdbtnTarjetaDebito.setBounds(441, 51, 149, 23);
		panelCliente_1.add(rdbtnTarjetaDebito);
		
		JRadioButton rdbtnTarjetaCredito = new JRadioButton("Tarjeta credito");
		rdbtnTarjetaCredito.setBounds(441, 76, 149, 23);
		panelCliente_1.add(rdbtnTarjetaCredito);
		
		textField = new JTextField();
		textField.setBounds(441, 150, 265, 19);
		panelCliente_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblIngreseElNumero = new JLabel("Ingrese el numero de la tarjeta ");
		lblIngreseElNumero.setBounds(441, 125, 277, 15);
		panelCliente_1.add(lblIngreseElNumero);
		
		JLabel lblIngreseLaFecha = new JLabel("Ingrese la fecha");
		lblIngreseLaFecha.setBounds(441, 206, 125, 15);
		panelCliente_1.add(lblIngreseLaFecha);
		
		textField_1 = new JTextField();
		textField_1.setBounds(571, 204, 112, 19);
		panelCliente_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIngreseElCodigo = new JLabel("codigo de seguridad");
		lblIngreseElCodigo.setBounds(26, 243, 265, 15);
		panelCliente_1.add(lblIngreseElCodigo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(429, 263, 265, 19);
		panelCliente_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre del titular");
		lblIngreseElNombre.setBounds(441, 238, 265, 15);
		panelCliente_1.add(lblIngreseElNombre);
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 241, 91, 19);
		panelCliente_1.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.setBounds(577, 317, 117, 76);
		panelCliente_1.add(btnComprar);
		
		JLabel lblValorTotalDe = new JLabel("Valor total de la compra: $");
		lblValorTotalDe.setBounds(441, 12, 196, 15);
		panelCliente_1.add(lblValorTotalDe);
		
		JLabel lblResumenCompra = new JLabel("Resumen compra:");
		lblResumenCompra.setBounds(23, 288, 170, 15);
		panelCliente_1.add(lblResumenCompra);
		
		
		
		
	}

	boolean moda = false;
	boolean clas = false;
	
	@Override	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Solo ida" || e.getActionCommand() == "Ida y regreso") {
			miCompra.getMiTiquete().setTipoClase(e.getActionCommand());
			moda = true;
			fechaRegreso.setEnabled(true);
			if (e.getActionCommand()=="Solo ida") {
				fechaRegreso.setEnabled(false);
			}
		}
		
		if (e.getActionCommand() == "Economica" || e.getActionCommand() == "Ejecutiva") {
			clas = true;
			miCompra.getMiTiquete().setModalidad(e.getActionCommand());
			System.out.println("Cambio a modalidada "+ miCompra.getMiTiquete().getModalidad());
		}
		
		if (e.getSource()==btnVerDisponibilidad ) {
			if (clas && moda) {
				
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				String fS="",fD="",cDest="",cOrigen="";
				String mostrar = "";
				HashMap<String,String> vueloRegreso=null,vueloSalida=null;
				boolean idaRegreso = RadioButtonIdaYRegreso.isSelected();
				cOrigen= (String)comboBoxCiudadOrigen.getSelectedItem();
				cDest = (String)comboBoxCiudadDestino.getSelectedItem();
				
				if (fechaSalida.getDate()!=null  ) {
					fS = formato.format(fechaSalida.getDate());
					vueloSalida = miCompra.verificarVuelo(cOrigen,cDest,fS);
					
					if (vueloSalida!=null) {
						mostrar+="El vuelo de ida se encuentra disponible para las "+vueloSalida.get("HoraSalida")+" \n";
					}else {
						mostrar+="El vuelo de ida no se encuentra en la fecha seleccionada ";
					}
					if ( idaRegreso) {
						if (fechaRegreso.getDate() != null ) {
							
							if (idaRegreso) {
								fD = formato.format(fechaRegreso.getDate());
								vueloRegreso = miCompra.verificarVuelo(cDest,cOrigen,fD);
								mostrar+="El vuelo de regreso se encuentra disponible para las "+vueloSalida.get("HoraSalida");
							}else {
								mostrar+="El vuelo de regreso no se encuentra en la fecha seleccionada ";
							}
						}else {
							JOptionPane.showMessageDialog(null,"Ingrese la fecha de regreso");
						}
					}
					JOptionPane.showMessageDialog(null,mostrar);
				}else {
					JOptionPane.showMessageDialog(null,"Ingrese la fecha de salida");
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Por favor escoja la clase y modalidad");
			}
			
		}
		
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
		
	
	}
}
