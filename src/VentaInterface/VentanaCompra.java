package VentaInterface;

import java.awt.EventQueue;
import java.awt.JobAttributes;
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
import VentaLogica.Maleta;
import VentaLogica.Tarjeta;
import mundo.CaribeAirlines;
import vueloLogica.Vuelo;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class VentanaCompra implements ActionListener {

	private JFrame panel;

	private ButtonGroup BGModalidad, BGClase;
	private JComboBox<String> comboBoxCiudadDestino, comboBoxCiudadOrigen;

	private JRadioButton RadioButtonIdaYRegreso, RadioButtonSoloIda, rdbtnEconomica, rdbtnEjecutiva,rdbtnTarjetaDebito,rdbtnTarjetaCredito;
	private JButton btnRegistro, btnCargarDatos, btnVerDisponibilidad, btnContinuar, btnAgregarMaleta,btnContinuar2,btnVerificarCupo ,btnComprar,btnEquiAdi,btnMascota, btnEscogerSilla ;
	
	private JLabel nombre, direccion, fecha, correo,lblMaleta;
	private Compra miCompra;
	private JTextPane ResumenMaletas; 
	private int contMaletas;
	private JTabbedPane tabbedPane;
	private JTextPane txtEstado;
	private JTextPane txtResumenCompra ;
	private JDateChooser fechaSalida, fechaRegreso;
	private JTextField txtIdentificacion;
	private JTextField txtNumtarjeta;
	private JTextField fechaTarjeta;
	private JTextField codigoTarjeta;
	private JTextField dimensiones;
	private JTextField peso;

	public VentanaCompra(CaribeAirlines ae) {

		panel = new JFrame();
		panel.setBounds(100, 100, 746, 485);
		panel.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 11, 711, 432);
		panel.getContentPane().add(tabbedPane);
		panel.setVisible(true);
		miCompra = new Compra(ae);

		// ***********************************************PANEL
		// VIAJE********************************************************************************************
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
		ciudades.add("Monterrey");
		ciudades.add("Bogotá");
		Iterator<String> it = ciudades.iterator();
		while (it.hasNext()) {
			String c = it.next();
			comboBoxCiudadDestino.addItem(c);
			comboBoxCiudadOrigen.addItem(c);
		}
		panelViaje.add(comboBoxCiudadDestino);

		txtEstado = new JTextPane();
		txtEstado.setText("");
		txtEstado.setBounds(10, 121, 352, 60);
		panelViaje.add(txtEstado);

		// CLASE ********
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

		BGClase = new ButtonGroup();

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
		fechaSalida.setMinSelectableDate(new java.util.Date());
		panelViaje.add(fechaSalida);

		fechaRegreso = new JDateChooser();
		fechaRegreso.setBounds(485, 110, 209, 20);
		fechaRegreso.setMinSelectableDate(new java.util.Date());
		panelViaje.add(fechaRegreso);

		btnVerDisponibilidad = new JButton("Ver disponibilidad de vuelos");
		btnVerDisponibilidad.setBounds(440, 250, 254, 49);
		btnVerDisponibilidad.addActionListener(this);
		panelViaje.add(btnVerDisponibilidad);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(440, 307, 254, 50);
		btnContinuar.addActionListener(this);
		panelViaje.add(btnContinuar);
		
		btnEscogerSilla = new JButton("Escoger Silla ");
		btnEscogerSilla.setBounds(525, 167, 169, 25);
		btnEscogerSilla.addActionListener(this);
		panelViaje.add(btnEscogerSilla);
		
		txtSilla = new JTextField();
		txtSilla.setText("\n");
		txtSilla.setBounds(580, 200, 114, 19);
		panelViaje.add(txtSilla);
		txtSilla.setColumns(10);

		// ***********************************************************PANEL
		// EQUIPAJE********************************************************************************************
		JPanel panelEquipaje = new JPanel();
		tabbedPane.addTab("Equipaje", null, panelEquipaje, null);
		panelEquipaje.setLayout(null);
		//tabbedPane.setEnabledAt(1, false);

		btnAgregarMaleta = new JButton("Agregar Maleta");
		btnAgregarMaleta.setBounds(12, 168, 236, 25);
		btnAgregarMaleta.addActionListener(this);
		panelEquipaje.add(btnAgregarMaleta);
		contMaletas = 0;
		lblMaleta = new JLabel("Maleta " + (contMaletas+1) + ":");
		lblMaleta.setBounds(12, 25, 121, 15);
		panelEquipaje.add(lblMaleta);

		dimensiones = new JTextField();
		dimensiones.setBounds(12, 79, 200, 19);
		panelEquipaje.add(dimensiones);
		dimensiones.setColumns(10);

		JLabel lblDimensionesAlturaanchoalto = new JLabel("Dimensiones: altura-ancho-largo\n");
		lblDimensionesAlturaanchoalto.setBounds(12, 52, 251, 15);
		panelEquipaje.add(lblDimensionesAlturaanchoalto);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(12, 110, 70, 15);
		panelEquipaje.add(lblPeso);

		peso = new JTextField();
		peso.setBounds(12, 137, 207, 19);
		peso.setColumns(10);
		panelEquipaje.add(peso);
		
		ResumenMaletas = new JTextPane();
		ResumenMaletas.setBounds(369, 25, 283, 307);
		panelEquipaje.add(ResumenMaletas);
		
		btnContinuar2 = new JButton("Continuar");
		btnContinuar2.setBounds(12, 283, 207, 53);
		btnContinuar2.addActionListener(this);
		panelEquipaje.add(btnContinuar2);
		
		btnMascota= new JButton("Agregar Mascota\n");
		btnMascota.setBounds(12, 205, 236, 25);
		btnMascota.addActionListener(this);
		panelEquipaje.add(btnMascota);
		
		btnEquiAdi = new JButton("Agregar equipaje adicional");
		btnEquiAdi.setBounds(12, 242, 236, 25);
		btnEquiAdi.addActionListener(this);
		panelEquipaje.add(btnEquiAdi );

		// **************************************************************PANEL
		// CLIENTE********************************************************************************************
		JPanel panelCliente_1 = new JPanel();
		tabbedPane.addTab("Cliente", null, panelCliente_1, null);
		//tabbedPane.setEnabledAt(2, false);
		panelCliente_1.setLayout(null);

		JLabel lblingreseSuNumero = new JLabel(
				"<html>Ingrese su numero de documento en caso de que este registrado, sino por favor registre sus datos desde el boton registro.</html>");
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
		
		ButtonGroup BGTarjeta = new ButtonGroup();

		rdbtnTarjetaDebito = new JRadioButton("Tarjeta Debito");
		rdbtnTarjetaDebito.setBounds(441, 51, 149, 23);
		BGTarjeta.add(rdbtnTarjetaDebito);
		panelCliente_1.add(rdbtnTarjetaDebito);

		rdbtnTarjetaCredito = new JRadioButton("Tarjeta credito");
		rdbtnTarjetaCredito.setBounds(441, 76, 149, 23);
		BGTarjeta.add(rdbtnTarjetaCredito);
		panelCliente_1.add(rdbtnTarjetaCredito);

		txtNumtarjeta = new JTextField();
		txtNumtarjeta.setBounds(441, 150, 242, 19);
		panelCliente_1.add(txtNumtarjeta);
		txtNumtarjeta.setColumns(10);

		JLabel lblIngreseElNumero = new JLabel("Ingrese el numero de la tarjeta ");
		lblIngreseElNumero.setBounds(441, 125, 277, 15);
		panelCliente_1.add(lblIngreseElNumero);

		JLabel lblIngreseLaFecha = new JLabel("Ingrese la fecha");
		lblIngreseLaFecha.setBounds(441, 206, 125, 15);
		panelCliente_1.add(lblIngreseLaFecha);

		fechaTarjeta = new JTextField();
		fechaTarjeta.setBounds(571, 204, 112, 19);
		panelCliente_1.add(fechaTarjeta);
		fechaTarjeta.setColumns(10);

		JLabel lblIngreseElCodigo = new JLabel("codigo de seguridad");
		lblIngreseElCodigo.setBounds(441, 184, 150, 15);
		panelCliente_1.add(lblIngreseElCodigo);

		codigoTarjeta = new JTextField();
		codigoTarjeta.setBounds(592, 182, 91, 19);
		panelCliente_1.add(codigoTarjeta);
		codigoTarjeta.setColumns(10);

		btnComprar = new JButton("COMPRAR");
		btnComprar.setBounds(441, 352, 253, 41);
		btnComprar.addActionListener(this);
		panelCliente_1.add(btnComprar);

		JLabel lblValorTotalDe = new JLabel("Valor total de la compra: $");
		lblValorTotalDe.setBounds(441, 12, 196, 15);
		panelCliente_1.add(lblValorTotalDe);

		JLabel lblResumenCompra = new JLabel("Resumen compra:");
		lblResumenCompra.setBounds(23, 270, 170, 15);
		panelCliente_1.add(lblResumenCompra);
		
		btnVerificarCupo = new JButton("Verificar cupo");
		btnVerificarCupo.setBounds(498, 233, 160, 25);
		btnVerificarCupo.addActionListener(this);
		panelCliente_1.add(btnVerificarCupo);
		
		txtResumenCompra = new JTextPane();
		txtResumenCompra.setBounds(19, 296, 394, 97);
		panelCliente_1.add(txtResumenCompra);

	}

	boolean moda = false;
	boolean clas = false;
	boolean continuar = false;
	boolean cupo = false;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (comboBoxCiudadOrigen==e.getSource()) {
				System.out.println(comboBoxCiudadOrigen.getSelectedIndex());
			if (comboBoxCiudadOrigen.getSelectedIndex()!=0) {
				comboBoxCiudadDestino.setEnabled(false);
				comboBoxCiudadDestino.setSelectedIndex(0);
				System.out.println("true");
			}else {
				System.out.println("false");
				
				comboBoxCiudadDestino.setEnabled(true);	
			}
			
		}
		
		if (e.getSource()==btnComprar) {
			if (txtResumenCompra.equals("")) {
				JOptionPane.showMessageDialog(null, "Primero debe revisar si tiene cupo y cumplir todos los requisitos anteriores");
			}else {
				String resumenTiquete = miCompra.getMiTiquete().toString();
				txtResumenCompra.setText(resumenTiquete);
				miCompra.guardarTiquete();
				JOptionPane.showMessageDialog(null, "Se ha guardado correctamente su reserva, porfavor revise su correo electronico");
			}
		}
		
		
		if (e.getSource()==btnVerificarCupo) {
			String iden = txtIdentificacion.getText();
			String num = txtNumtarjeta.getText();
			String cod = codigoTarjeta.getText();
			String fec = fechaTarjeta.getText();
			String tipo="";
			if (rdbtnTarjetaCredito.isSelected()) {
				tipo = "credito";
			}else if (rdbtnTarjetaDebito.isSelected()) {
				tipo = "debito";
			}else{
				JOptionPane.showMessageDialog(null, "Por favor seleccione el tipo de tarjeta");
			}
			
			
			boolean t = miCompra.verificarCupo(iden,num,cod,fec,tipo,miCompra.getMiTiquete().getTotal());
			
			
			if (t) {
				JOptionPane.showMessageDialog(null, "Su tarjeta tiene cupo y puede continuar con la compra");
				txtResumenCompra.setText(txtEstado.getText()+", Cantidad de Maletas "+contMaletas);
			}else {
				JOptionPane.showMessageDialog(null, "Su tarjeta no tiene cupo o escribio mal los datos");
			}
			
		}
		
		
		
		
		//*********************************************** PANEL EQUIPAJE****************************************************************************

		if (btnAgregarMaleta == e.getSource()) {
			int pe = Integer.parseInt(peso.getText());
			boolean verDim = verificarDimensionesMaleta();
			boolean verPeso = verificarPeso(pe);
			
			if (verPeso && verDim) {
				ResumenMaletas.setText(ResumenMaletas.getText()+"Maleta " + (contMaletas+1) + ": " +dimensiones.getText()+" Peso "+ pe+" \n");
				contMaletas++;
				lblMaleta.setText("Maleta " + (contMaletas+1) + ":");
				Maleta m = new Maleta(dimensiones.getText(), pe);
				miCompra.getMiTiquete().agregarMaleta(m);
				
				JOptionPane.showMessageDialog(null, "Maleta "+contMaletas+" agregada");
			}
			
		}
		
		if (e.getSource() == btnMascota) {
			AgregarMascota();
		}
		
		if (e.getSource()==btnEquiAdi) {
			AgregarEquipajeAdicional();
		}
		
		if (e.getSource()==btnContinuar2) {
			if (contMaletas==0) {
				if (JOptionPane.showConfirmDialog(null, "¿Desea continuar sin registrar maletas?")==JOptionPane.OK_OPTION) {
					tabbedPane.setEnabledAt(2,true);
					tabbedPane.setSelectedIndex(2);
				}
			}else {
				tabbedPane.setEnabledAt(2,true);
				tabbedPane.setSelectedIndex(2);
			}
		}
		

		// **************************************** PANEL VIAJE  *************************************************************************************
		
		if (e.getSource()==btnEscogerSilla) {
			VentanaSilla vs = new VentanaSilla(miCompra.getAerolinea());
			vs.frame.setVisible(true);
			if (comboBoxCiudadDestino.getSelectedItem().equals("Monterrey") || comboBoxCiudadDestino.getSelectedItem().equals("Cancun") || comboBoxCiudadOrigen.getSelectedItem().equals("Monterrey") || comboBoxCiudadOrigen.getSelectedItem().equals("Cancun")) {
				JOptionPane.showMessageDialog(null, "Su vuelo es nacional, Por favor escoja la silla del avion 1");
			}else {
				JOptionPane.showMessageDialog(null,"Su vuelo es internacional, Por favor escoja la silla del avion 2");
			}
		}
		
		
		if (e.getActionCommand() == "Solo ida" || e.getActionCommand() == "Ida y regreso") {
			moda = true;
			fechaRegreso.setEnabled(true);
			if (e.getActionCommand() == "Solo ida") {
				fechaRegreso.setEnabled(false);
			}
		}
		
		

		if (e.getActionCommand() == "Economica" || e.getActionCommand() == "Ejecutiva") {
			clas = true;
			miCompra.getMiTiquete().setTipoClase(e.getActionCommand());
		}

		if (e.getSource() == btnVerDisponibilidad) {
			if (clas && moda) {

				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				String fS = "", fD = "", cDest = "", cOrigen = "";
				String mostrar = "";
				Vuelo vueloRegreso = null, vueloSalida = null;
				boolean idaRegreso = RadioButtonIdaYRegreso.isSelected();
				cOrigen = (String) comboBoxCiudadOrigen.getSelectedItem();
				cDest = (String) comboBoxCiudadDestino.getSelectedItem();

				if (fechaSalida.getDate() != null) {
					fS = formato.format(fechaSalida.getDate());
					vueloSalida = miCompra.verificarVuelo(cOrigen, cDest, fS);

					if (vueloSalida != null) {
						mostrar += "El vuelo de ida se encuentra disponible para las " + vueloSalida.getAtributos().get("HoraSalida")
								+ " \n";
						miCompra.getMiTiquete().setVueloIda(vueloSalida);
						miCompra.getMiTiquete().setSilla(txtSilla.getText());
					} else {
						mostrar += "El vuelo de ida NO se encuentra en la fecha seleccionada \n";

					}
					if (idaRegreso) {
						if (fechaRegreso.getDate() != null) {

							fD = formato.format(fechaRegreso.getDate());
							vueloRegreso = miCompra.verificarVuelo(cDest, cOrigen, fD);
							if (vueloRegreso != null) {
								mostrar += "El vuelo de regreso se encuentra disponible para las "
										+ vueloRegreso.getAtributos().get("HoraSalida");
								miCompra.getMiTiquete().setVueloRegreso(vueloRegreso);
							} else {
								mostrar += "El vuelo de regreso no se encuentra en la fecha seleccionada ";
							}

						} else {
							JOptionPane.showMessageDialog(null, "Ingrese la fecha de regreso");
						}
					}
					JOptionPane.showMessageDialog(null, mostrar);
					txtEstado.setText(mostrar+", El precio total con las opciones seleccionadas es "+miCompra.getMiTiquete().getTotal());

					if (vueloSalida != null && ((idaRegreso && vueloRegreso != null) || !idaRegreso)) {
						continuar = true;
						miCompra.getMiTiquete().setVueloIda(vueloSalida);
						miCompra.getMiTiquete().setVueloRegreso(vueloRegreso);
					} else {
						continuar = false;
					}

				} else {
					JOptionPane.showMessageDialog(null, "Ingrese la fecha de salida");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Por favor escoja la clase y modalidad");
			}

		}

		if (btnContinuar == e.getSource()) {
			if (continuar) {
				tabbedPane.setEnabledAt(1, true);
				tabbedPane.setSelectedIndex(1);
			} else {
				JOptionPane.showMessageDialog(null,
						"Antes de continuar debe haber disponibilidad de vuelos, escoja otra fecha y verifique la disponibilidad");
			}
		}

		if (e.getSource() == btnCargarDatos) {
			String ident = txtIdentificacion.getText();
			Cliente c = miCompra.getCliente(ident);
			if (c != null) {
				nombre.setText(c.getNombre() + " " + c.getApellido());
				direccion.setText(c.getDireccion());
				miCompra.getMiTiquete().setIdMiCliente(ident);
				fecha.setText(c.getFechaNacimiento());
				correo.setText(c.getEmail());
			} else {
				JOptionPane.showMessageDialog(null, "No existe el usuario");
			}
		}
		if (e.getSource() == btnRegistro) {
			VentanaRegistroCliente vrc = new VentanaRegistroCliente(miCompra);

		}
	}
	int contMascota=1;
	private void AgregarMascota() {
		boolean v = true;
		int pe = 0;
		while (v) {
			try {
				String pes = JOptionPane.showInputDialog("Si la mascota pesa entre 3 y 9 Kg tiene una tarifa de 48 dolares \n Si pesa más de 9kg tiene un costo de 2 dolares por cada kg extra \n Ingrese el peso de la mascota "+contMascota);
				pe = Integer.parseInt(pes);
				v=false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Por favor ingrese solo numeros");
			}			
		}
		double valorAgregado = 0;
		if (pe<10) {
			valorAgregado = 48;
		}else {
			valorAgregado = 48+(pe-9)*2;
		}
		JOptionPane.showMessageDialog(null, "El precio agregado es de "+valorAgregado);
		double v1 = miCompra.getMiTiquete().agregarValor(valorAgregado);
		
		ResumenMaletas.setText(ResumenMaletas.getText()+ "\n Mascota "+contMascota+" peso: "+pe+" valor= "+valorAgregado+" \n");
		contMascota++;
		Maleta m = new Maleta("mascota",pe);
		miCompra.getMiTiquete().agregarMaleta(m);
		JOptionPane.showMessageDialog(null, "El valor total hasta el momento es de "+v1);

	}

	int contEquipajeExtra = 1 ;
	private JTextField txtSilla;
	private void AgregarEquipajeAdicional() {
		
		boolean v = true;
		int pe = 0;
		while (v) {
			try {
				String pes = JOptionPane.showInputDialog("Recuerde que por Kg tiene un costo de 8 dolares mas el 6.75% de impuesto sobre el total \n Ingrese el peso del equipaje extra "+contEquipajeExtra);
				pe = Integer.parseInt(pes);
				v=false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Por favor ingrese solo numeros");
			}			
		}
		
		double valorAgregado = Math.floor(pe*8*1.0675);
		JOptionPane.showMessageDialog(null, "El precio agregado es de "+valorAgregado);
		double v1 = miCompra.getMiTiquete().agregarValor(valorAgregado);
		
		ResumenMaletas.setText(ResumenMaletas.getText()+ "\n Equipaje extra "+contEquipajeExtra+" peso: "+pe+" valor= "+valorAgregado+" \n");
		contEquipajeExtra++;
		Maleta m = new Maleta("0-0-0",pe);
		miCompra.getMiTiquete().agregarMaleta(m);
		JOptionPane.showMessageDialog(null, "El valor total hasta el momento es de "+v1);
	}

	private boolean verificarPeso(int p) {
		if (miCompra.getMiTiquete().getVueloIda().getMiRuta().getAtributos().get("Tipo vuelo").equals("Nacional")) {
			if (rdbtnEconomica.isSelected()) {
				if (p>24) {
					JOptionPane.showMessageDialog(null, "El peso permitido en clase economica vuelo Nacional es menor a 24Kg");
				}else {
					if (contMaletas<1) {
						return true;
					}else {
						JOptionPane.showMessageDialog(null, "La cantidad maxima de maletas para economica nacional es 1");
					}
				}
			}else {
				if (p>34) {
					JOptionPane.showMessageDialog(null, "El peso permitido en clase ejecutiva vuelo Nacional es menor a 24Kg");
				}else {
					if (contMaletas<2) {
						return true;
					}else {
						JOptionPane.showMessageDialog(null, "La cantidad maxima de maletas para ejecutiva nacional es 2");
					}
				}
			}
		}else {
			if (rdbtnEconomica.isSelected()) {
				if (p>24) {
					JOptionPane.showMessageDialog(null, "El peso permitido en clase economica vuelo Internacional es menor a 24Kg");
				}else {
					if (contMaletas<2) {
						return true;
					}else {
						JOptionPane.showMessageDialog(null, "La cantidad maxima de maletas para economica internacional es 2");
					}
				}
			}else {
				if (p>34) {
					JOptionPane.showMessageDialog(null, "El peso permitido en clase ejecutiva vuelo Internacional es menor a 24Kg");
				}else {
					if (contMaletas<2) {
						return true;
					}else {
						JOptionPane.showMessageDialog(null, "La cantidad maxima de maletas para ejecutiva internacional es 2");
					}
				}
			}
		}
			
		return false;
	}

	

	private boolean verificarDimensionesMaleta() {
		String[] dim = dimensiones.getText().split("-");
		if (dim.length != 3) {
			JOptionPane.showMessageDialog(null, "Por favor ingrese bien las dimensiones en cm. Ej: 30+90+40");
		} else {
			int suma = 0;
			for (int i = 0; i < dim.length; i++) {
				suma += Integer.parseInt(dim[i]);
			}

			if (suma > 170) {
				JOptionPane.showMessageDialog(null, "La suma de las dimensiones no puede exceder 170cm");
			} else {
				return true;
			}
		}
		return false;
	}
}
