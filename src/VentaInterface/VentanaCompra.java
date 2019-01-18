package VentaInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;

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
import VentaLogica.Compra;


public class VentanaCompra implements ActionListener{

	private JFrame frame;
	
	
	private ButtonGroup BGModalidad,BGClase;
	private JComboBox<String> comboBoxCiudadDestino,comboBoxCiudadOrigen,comboBoxFechaSalida,comboBoxFechaRegreso;
	private JLabel lblFechaDeRegreso; 
	private JRadioButton RadioButtonIdaYRegreso,RadioButtonSoloIda,rdbtnEconomica,rdbtnEjecutiva;
	
	
	private Compra miCompra;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCompra window = new VentanaCompra();
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
	public VentanaCompra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 395, 258);
		frame.getContentPane().add(tabbedPane);
		
		miCompra = new Compra();		
		HashSet<String> ciudades = miCompra.getCiudades();
		

		
		
		//PANEL MODALIDAD********************************************************************************************
		JPanel panelMod = new JPanel();
		tabbedPane.addTab("Modalidad", null, panelMod, null);
		panelMod.setLayout(null);
		
		BGModalidad = new ButtonGroup();
		
		RadioButtonIdaYRegreso = new JRadioButton("Ida y regreso");
		RadioButtonIdaYRegreso.setBounds(6, 87, 109, 23);
		BGModalidad.add(RadioButtonIdaYRegreso);
		RadioButtonIdaYRegreso.addActionListener(this);
		panelMod.add(RadioButtonIdaYRegreso);
				
		RadioButtonSoloIda = new JRadioButton("Solo ida");
		RadioButtonSoloIda.setBounds(6, 130, 109, 23);
		BGModalidad.add(RadioButtonSoloIda);
		RadioButtonSoloIda.addActionListener(this);
		panelMod.add(RadioButtonSoloIda);
		
		
		
		
		// PANEL CIUDAD********************************************************************************************
		JPanel panelCiudad = new JPanel();
		tabbedPane.addTab("Ciudad", null, panelCiudad, null);
		panelCiudad.setLayout(null);
		
		JLabel lblCiudadOrigen = new JLabel("Ciudad Origen");
		lblCiudadOrigen.setBounds(10, 82, 97, 17);
		panelCiudad.add(lblCiudadOrigen);
		
		comboBoxCiudadOrigen = new JComboBox();
		comboBoxCiudadOrigen.setBounds(144, 80, 169, 20);
		panelCiudad.add(comboBoxCiudadOrigen);
		
		
		JLabel lblCiudadDestino = new JLabel("Ciudad Destino");
		lblCiudadDestino.setBounds(10, 138, 97, 14);
		panelCiudad.add(lblCiudadDestino);
		
		comboBoxCiudadDestino = new JComboBox();
		comboBoxCiudadDestino.setBounds(144, 135, 169, 20);
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
		
		
		
		//PANEL CLASE y CANTIDAD DE PERSONAS********************************************************************************************
		JPanel panelClase = new JPanel();
		tabbedPane.addTab("Clase del servicio", null, panelClase, null);
		panelClase.setLayout(null);
		
		BGClase =new ButtonGroup();
		
		rdbtnEconomica = new JRadioButton("Economica");
		rdbtnEconomica.setBounds(25, 30, 109, 23);
		BGClase.add(rdbtnEconomica);
		panelClase.add(rdbtnEconomica);
		
		rdbtnEjecutiva = new JRadioButton("Ejecutiva");
		rdbtnEjecutiva.setBounds(25, 68, 109, 23);
		BGClase.add(rdbtnEjecutiva);
		panelClase.add(rdbtnEjecutiva);
		
		JLabel lblCantidadDePersonas = new JLabel("Cantidad de personas");
		lblCantidadDePersonas.setBounds(25, 128, 109, 14);
		panelClase.add(lblCantidadDePersonas);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(144, 125, 29, 20);
		panelClase.add(spinner);
		
		
		
		//PANEL FECHAS********************************************************************************************
		JPanel panelFechas = new JPanel();
		tabbedPane.addTab("Fechas", null, panelFechas, null);
		panelFechas.setLayout(null);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida (DD/MM/AA)");
		lblFechaDeSalida.setBounds(10, 60, 161, 14);
		panelFechas.add(lblFechaDeSalida);
		
		lblFechaDeRegreso = new JLabel("Fecha de regreso (DD/MM/AA)");
		lblFechaDeRegreso.setBounds(10, 133, 147, 14);
		panelFechas.add(lblFechaDeRegreso);
		
		comboBoxFechaSalida = new JComboBox();
		comboBoxFechaSalida.setBounds(213, 57, 147, 20);
		panelFechas.add(comboBoxFechaSalida);
		
		comboBoxFechaRegreso = new JComboBox();
		comboBoxFechaRegreso.setBounds(213, 130, 147, 20);
		panelFechas.add(comboBoxFechaRegreso);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
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
			
			System.out.println("Se actualizo la ciudad destino "+String.valueOf(comboBoxCiudadDestino.getSelectedItem()));
			HashSet<String> fechasSalida = miCompra.getFechasDeCiudad(String.valueOf(comboBoxCiudadDestino.getSelectedItem()));
			
			Iterator<String> it = fechasSalida.iterator();
			while (it.hasNext()) {
				String f = it.next();
				comboBoxFechaSalida.addItem(f);
			}
			
			HashSet<String> fechasRegreso = miCompra.getFechasDeCiudad("CDMX");
			System.out.println(fechasRegreso);
			Iterator<String> it2 = fechasRegreso.iterator();
			while (it2.hasNext()) {
				String f = it2.next();
				comboBoxFechaRegreso.addItem(f);
			}
		}
	}
}
